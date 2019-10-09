package cn.dnaizn.mall.address.service.impl;



import cn.dnaizn.mall.mapper.AreasMapper;
import cn.dnaizn.mall.pojo.Areas;
import cn.dnaizn.mall.pojo.AreasExample;
import cn.dnaizn.mall.service.AreasService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class AreasServiceImpl implements AreasService {

	@Autowired
	private AreasMapper areasMapper;

	/**
	 * 查询全部
	 */
	@Override
	public  List<Areas> findAll() {
		return areasMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Areas> page=   (Page<Areas>) areasMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Areas areas) {
		areasMapper.insert(areas);
	}


	/**
	 * 修改
	 */
	@Override
	public void update(Areas areas){
		areasMapper.updateByPrimaryKey(areas);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Areas findOne(Integer id){
		return areasMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			areasMapper.deleteByPrimaryKey(id);
		}
	}


		@Override
	public PageResult findPage(Areas areas, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		AreasExample example=new AreasExample();
		AreasExample.Criteria criteria = example.createCriteria();

		if(areas!=null){
						if(areas.getAreaId()!=null && areas.getAreaId().length()>0){
				criteria.andAreaIdLike("%"+areas.getAreaId()+"%");
			}
			if(areas.getArea()!=null && areas.getArea().length()>0){
				criteria.andAreaLike("%"+areas.getArea()+"%");
			}
			if(areas.getCityId()!=null && areas.getCityId().length()>0){
				criteria.andCityIdLike("%"+areas.getCityId()+"%");
			}

		}

		Page<Areas> page= (Page<Areas>)areasMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

}
