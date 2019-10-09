package cn.dnaizn.mall.address.service.impl;


import cn.dnaizn.mall.mapper.CitiesMapper;
import cn.dnaizn.mall.pojo.Cities;
import cn.dnaizn.mall.pojo.CitiesExample;
import cn.dnaizn.mall.service.CitiesService;
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
public class CitiesServiceImpl implements CitiesService {

	@Autowired
	private CitiesMapper citiesMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Cities> findAll() {
		return citiesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Cities> page=   (Page<Cities>) citiesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Cities cities) {
		citiesMapper.insert(cities);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Cities cities){
		citiesMapper.updateByPrimaryKey(cities);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Cities findOne(Integer id){
		return citiesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			citiesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Cities cities, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		CitiesExample example=new CitiesExample();
		CitiesExample.Criteria criteria = example.createCriteria();
		
		if(cities!=null){			
						if(cities.getCityId()!=null && cities.getCityId().length()>0){
				criteria.andCityIdLike("%"+cities.getCityId()+"%");
			}
			if(cities.getCity()!=null && cities.getCity().length()>0){
				criteria.andCityLike("%"+cities.getCity()+"%");
			}
			if(cities.getProvinceid()!=null && cities.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+cities.getProvinceid()+"%");
			}
	
		}
		
		Page<Cities> page= (Page<Cities>)citiesMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
