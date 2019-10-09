package cn.dnaizn.mall.advertisement.service.impl;

import cn.dnaizn.mall.service.ContentService;
import cn.dnaizn.mall.mapper.ContentMapper;
import cn.dnaizn.mall.pojo.Content;
import cn.dnaizn.mall.pojo.ContentExample;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import jodd.util.StringUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentMapper contentMapper;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 查询全部
     */
    @Override
    public List<Content> findAll() {
        return contentMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Content> page = (Page<Content>) contentMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Content content) {
        contentMapper.insert(content);
        Jedis jedis = redisUtil.getJedis();
        String contentKey = "content:" + content.getCategoryId() + ":List";
        jedis.del(contentKey);
        jedis.close();
    }


    /**
     * 修改
     */
    @Override
    public void update(Content content) {
        Long categoryId = contentMapper.selectByPrimaryKey(content.getId()).getCategoryId();
        Jedis jedis = redisUtil.getJedis();
        String contentKey = "content:" + categoryId + ":List";
        jedis.del(contentKey);
        contentMapper.updateByPrimaryKey(content);
        if (categoryId.longValue() != content.getCategoryId().longValue()) {
            contentKey = "content:" + content.getCategoryId() + ":List";
            jedis.del(contentKey);
        }
        jedis.close();
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Content findOne(Long id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        Jedis jedis = redisUtil.getJedis();
        for (Long id : ids) {
            Long categoryId = contentMapper.selectByPrimaryKey(id).getCategoryId();
            String contentKey = "content:" + categoryId + ":List";
            jedis.del(contentKey);
            contentMapper.deleteByPrimaryKey(id);
        }
        jedis.close();
    }


    @Override
    public PageResult findPage(Content content, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();

        if (content != null) {
            if (content.getTitle() != null && content.getTitle().length() > 0) {
                criteria.andTitleLike("%" + content.getTitle() + "%");
            }
            if (content.getUrl() != null && content.getUrl().length() > 0) {
                criteria.andUrlLike("%" + content.getUrl() + "%");
            }
            if (content.getPic() != null && content.getPic().length() > 0) {
                criteria.andPicLike("%" + content.getPic() + "%");
            }
            if (content.getStatus() != null && content.getStatus().length() > 0) {
                criteria.andStatusLike("%" + content.getStatus() + "%");
            }

        }

        Page<Content> page = (Page<Content>) contentMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Content> findByCategoryId(Long categoryId) {
        //根据广告分类ID查询广告列表
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria2 = contentExample.createCriteria();
        criteria2.andCategoryIdEqualTo(categoryId);
        criteria2.andStatusEqualTo("1");//开启状态
        contentExample.setOrderByClause("sort_order");//排序
        return contentMapper.selectByExample(contentExample);
    }

    @Autowired
    RedissonClient redissonClient;

    @Override
    public List<Content> getContentById(Long categoryId) {
        List<Content> list;
        Jedis jedis = redisUtil.getJedis();
        String contentKey = "content:" + categoryId + ":List";
        String contentList = jedis.get(contentKey);
        if (StringUtil.isNotBlank(contentList)) {
            list = JSON.parseArray(contentList, Content.class);
        } else {
            RLock lock = redissonClient.getLock("ADContentLock");//声明锁
            lock.lock();//上锁
            try {
                list = findByCategoryId(categoryId);
                if (list != null) {
                    jedis.set("content:" + categoryId + ":List", JSON.toJSONString(list));
                } else {
                    jedis.setex("content:" + categoryId + ":List", 60 * 3, "");
                }
            } finally {
                lock.unlock();
            }
//            //设置分布式锁
//            String token = UUID.randomUUID().toString();
//            String OK = jedis.set("content:" + categoryId + ":lock", token, "nx", "px", 10 * 1000);
//            if (StringUtil.isNotBlank(OK) && OK.equals("OK")) {
//                list = findByCategoryId(categoryId);
//                if (list != null) {
//                    jedis.set("content:" + categoryId + ":List", JSON.toJSONString(list));
//                } else {
//                    jedis.setex("content:" + categoryId + ":List", 60 * 3, "");
//                }
//                String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//                jedis.eval(luaScript, Collections.singletonList("content:" + categoryId + ":lock"), Collections.singletonList(token));
////				String lockToken = jedis.get("content:"+categoryId+":lock");
////				if (StringUtil.isNotBlank(lockToken)&&lockToken.equals(token)){
////					jedis.del("content:"+categoryId+":lock");
////				}
//            } else {
//                //设置失败,自旋
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return getContentById(categoryId);
//            }
        }
        jedis.close();
        return list;
    }
}
