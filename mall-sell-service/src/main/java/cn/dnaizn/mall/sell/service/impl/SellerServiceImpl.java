package cn.dnaizn.mall.sell.service.impl;


import cn.dnaizn.mall.DTO.SellerFormDTO;
import cn.dnaizn.mall.DTO.SellerRegisterDTO;
import cn.dnaizn.mall.mapper.SellerBriefMapper;
import cn.dnaizn.mall.mapper.SellerMapper;
import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.pojo.SellerExample;
import cn.dnaizn.mall.service.SellerService;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.jms.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    SellerBriefMapper sellerBriefMapper;

    @Autowired
    RedisUtil redisUtil;

	@Autowired
	ActiveMQUtil activeMQUtil;

    /**
     * 查询全部
     */
    @Override
    public List<Seller> findAll() {
        Jedis jedis = redisUtil.getJedis();
        jedis.publish("mall.message", "增加了一个");
        jedis.close();
        return sellerMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Seller> page = (Page<Seller>) sellerMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(SellerRegisterDTO sellerRegisterDTO) {
        Seller seller = new Seller();
        SellerBrief sellerBrief = new SellerBrief();
        seller.setSellerId(sellerRegisterDTO.getSellerId());
        seller.setPassword(sellerRegisterDTO.getPassword());
        seller.setMobile(sellerRegisterDTO.getMobile());
        seller.setCreateTime(new Date());
        seller.setStatus(0);
        sellerBrief.setSellerId(seller.getSellerId());
        Jedis jedis = redisUtil.getJedis();
        String sellerMobileKey = "sellerFormDTO:" + sellerRegisterDTO.getMobile() + ":form";
        jedis.del(sellerMobileKey);
        sellerMapper.insertSelective(seller);
        sellerBriefMapper.insertSelective(sellerBrief);
        jedis.publish("mall.message", "增加了一个");
        jedis.close();
    }


    /**
     * 修改
     */
    @Override
    public void update(Seller seller) {
        sellerMapper.updateByPrimaryKey(seller);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Seller findOne(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            sellerMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(Seller seller, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SellerExample example = new SellerExample();
        SellerExample.Criteria criteria = example.createCriteria();

        if (seller != null) {
            if (seller.getSellerId() != null && seller.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + seller.getSellerId() + "%");
            }
            if (seller.getName() != null && seller.getName().length() > 0) {
                criteria.andNameLike("%" + seller.getName() + "%");
            }
            if (seller.getNickName() != null && seller.getNickName().length() > 0) {
                criteria.andNickNameLike("%" + seller.getNickName() + "%");
            }
            if (seller.getPassword() != null && seller.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + seller.getPassword() + "%");
            }
            if (seller.getEmail() != null && seller.getEmail().length() > 0) {
                criteria.andEmailLike("%" + seller.getEmail() + "%");
            }
            if (seller.getMobile() != null && seller.getMobile().length() > 0) {
                criteria.andMobileLike("%" + seller.getMobile() + "%");
            }
            if (seller.getTelephone() != null && seller.getTelephone().length() > 0) {
                criteria.andTelephoneLike("%" + seller.getTelephone() + "%");
            }
            if (seller.getAddressDetail() != null && seller.getAddressDetail().length() > 0) {
                criteria.andAddressDetailLike("%" + seller.getAddressDetail() + "%");
            }
            if (seller.getLinkmanName() != null && seller.getLinkmanName().length() > 0) {
                criteria.andLinkmanNameLike("%" + seller.getLinkmanName() + "%");
            }
            if (seller.getLinkmanQq() != null && seller.getLinkmanQq().length() > 0) {
                criteria.andLinkmanQqLike("%" + seller.getLinkmanQq() + "%");
            }
            if (seller.getLinkmanMobile() != null && seller.getLinkmanMobile().length() > 0) {
                criteria.andLinkmanMobileLike("%" + seller.getLinkmanMobile() + "%");
            }
            if (seller.getLinkmanEmail() != null && seller.getLinkmanEmail().length() > 0) {
                criteria.andLinkmanEmailLike("%" + seller.getLinkmanEmail() + "%");
            }
            if (seller.getLicense() != null && seller.getLicense().length() > 0) {
                criteria.andLicenseLike("%" + seller.getLicense() + "%");
            }
            if (seller.getPapers() != null && seller.getPapers().length() > 0) {
                criteria.andPapersLike("%" + seller.getPapers() + "%");
            }
            if (seller.getLogoPic() != null && seller.getLogoPic().length() > 0) {
                criteria.andLogoPicLike("%" + seller.getLogoPic() + "%");
            }
            if (seller.getBrief() != null && seller.getBrief().length() > 0) {
                criteria.andBriefLike("%" + seller.getBrief() + "%");
            }
            if (seller.getLegalPerson() != null && seller.getLegalPerson().length() > 0) {
                criteria.andLegalPersonLike("%" + seller.getLegalPerson() + "%");
            }
            if (seller.getLegalPersonCardId() != null && seller.getLegalPersonCardId().length() > 0) {
                criteria.andLegalPersonCardIdLike("%" + seller.getLegalPersonCardId() + "%");
            }
            if (seller.getLegalPersonPic() != null && seller.getLegalPersonPic().length() > 0) {
                criteria.andLegalPersonPicLike("%" + seller.getLegalPersonPic() + "%");
            }
            if (seller.getBankName() != null && seller.getBankName().length() > 0) {
                criteria.andBankNameLike("%" + seller.getBankName() + "%");
            }
            if (seller.getBankUser() != null && seller.getBankUser().length() > 0) {
                criteria.andBankUserLike("%" + seller.getBankUser() + "%");
            }

        }

        Page<Seller> page = (Page<Seller>) sellerMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(String sellerId, Integer status) {
        Seller seller = sellerMapper.selectByPrimaryKey(sellerId);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }

    @Override
    public Seller findMobile(String mobile) {
        return sellerMapper.findMobile(mobile);
    }

    @Override
    public void SellerRegister(SellerFormDTO sellerFormDTO) {
        Seller seller = sellerMapper.selectByPrimaryKey(sellerFormDTO.getSellerId());
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerFormDTO.getSellerId());
        seller.setSellerId(seller.getSellerId());
        seller.setNickName(sellerFormDTO.getNickName());
        seller.setLinkmanName(sellerFormDTO.getLinkmanName());
        seller.setLinkmanMobile(sellerFormDTO.getLinkmanMobile());
        seller.setAddress(sellerFormDTO.getAdcode());
        seller.setAddressDetail(sellerFormDTO.getAddressDetail());
        seller.setLicense(sellerFormDTO.getLicense());
        seller.setPapers(sellerFormDTO.getPapers());
        seller.setLegalPerson(sellerFormDTO.getLegalPerson());
        seller.setLegalPersonCardId(sellerFormDTO.getLegalPersonCardId());
        seller.setLegalPersonPic(sellerFormDTO.getLegalPersonPic());
        sellerBrief.setSellerId(seller.getSellerId());
        sellerBrief.setNickName(sellerFormDTO.getNickName());
        sellerBrief.setLinkmanName(sellerFormDTO.getLinkmanName());
        sellerBrief.setLinkmanMobile(sellerFormDTO.getLinkmanMobile());
        sellerBrief.setCategory1Id(sellerFormDTO.getCategory1Id());
        sellerBrief.setCategory2Id(sellerFormDTO.getCategory2Id());
        sellerBrief.setCategory3Id(sellerFormDTO.getCategory3Id());
        sellerBrief.setAdcode(sellerFormDTO.getAdcode());
        sellerBrief.setAddressDetail(sellerFormDTO.getAddressDetail());
        sellerBrief.setAlbum(sellerFormDTO.getAlbum());
        sellerBrief.setLocation(sellerFormDTO.getLocation());
        Jedis jedis = redisUtil.getJedis();
        String sellerFormKey = "sellerFormDTO:" + seller.getSellerId() + ":form";
        String sellerForm = jedis.get(sellerFormKey);
        if (StringUtil.isNotBlank(sellerForm)) {
            jedis.del(sellerFormKey);
        }
        jedis.set("sellerFormDTO:" + seller.getSellerId() + ":form", JSON.toJSONString(sellerFormDTO));
        jedis.close();
        sellerMapper.updateByPrimaryKey(seller);
        sellerBriefMapper.updateByPrimaryKey(sellerBrief);
    }

    @Override
    public SellerFormDTO getSellerRegisterById(String sellerId) {
        SellerFormDTO sellerFormDTO;
        Jedis jedis = redisUtil.getJedis();
        String sellerFormKey = "sellerFormDTO:" + sellerId + ":form";
        String sellerForm = jedis.get(sellerFormKey);
        sellerFormDTO = JSON.parseObject(sellerForm, SellerFormDTO.class);
        jedis.close();
        return sellerFormDTO;
    }

    /**
     * 注册
     *
     * @param mobile
     */
    @Override
    public void createSmsCode(String mobile) {
        //生成随机数
        String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
        System.out.println(code);
        Jedis jedis = redisUtil.getJedis();
        String sellerMobileKey = "sellerFormDTO:" + mobile + ":form";
        jedis.setex(sellerMobileKey, 20 * 60, code);
        jedis.close();
        //发送短信内容MQ
        ConnectionFactory connectionFactory = activeMQUtil.getConnectionFactory();
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);//开启事务
            Queue queue = session.createQueue("sms");
            MessageProducer producer = session.createProducer(queue);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("mobile", mobile);//手机号
            mapMessage.setString("template_code", "SMS_173246457");
            mapMessage.setString("sign_name", "毒奶最牛");
            Map map = new HashMap();
            map.put("code", code);
            mapMessage.setString("param", JSON.toJSONString(map));
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(mapMessage);
            session.commit();//提交事务
            connection.close();//关闭事务
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    /**
     * 校验验证码
     *
     * @param mobile
     * @param code
     * @return
     */
    @Override
    public boolean checkSmsCode(String mobile, String code) {
        Jedis jedis = redisUtil.getJedis();
        String sellerPhoneKey = "sellerFormDTO:" + mobile + ":form";
        String systemCode = jedis.get(sellerPhoneKey);
        jedis.close();
        if (systemCode == null) {
            return false;
        }
        if (!code.equals(systemCode)) {
            return false;
        }
        return true;
    }
}
