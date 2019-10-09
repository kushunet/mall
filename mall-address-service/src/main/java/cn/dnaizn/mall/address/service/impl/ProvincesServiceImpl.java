package cn.dnaizn.mall.address.service.impl;

import cn.dnaizn.mall.mapper.ProvincesMapper;
import cn.dnaizn.mall.pojo.Provinces;
import cn.dnaizn.mall.pojo.ProvincesExample;
import cn.dnaizn.mall.service.ProvincesService;
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
public class ProvincesServiceImpl implements ProvincesService {

	@Autowired
	private ProvincesMapper provincesMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Provinces> findAll() {
		return provincesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Provinces> page=   (Page<Provinces>) provincesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Provinces provinces) {
		provincesMapper.insert(provinces);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Provinces provinces){
		provincesMapper.updateByPrimaryKey(provinces);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Provinces findOne(Integer id){
		return provincesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			provincesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Provinces provinces, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ProvincesExample example=new ProvincesExample();
		ProvincesExample.Criteria criteria = example.createCriteria();
		
		if(provinces!=null){			
						if(provinces.getProvinceid()!=null && provinces.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+provinces.getProvinceid()+"%");
			}
			if(provinces.getProvince()!=null && provinces.getProvince().length()>0){
				criteria.andProvinceLike("%"+provinces.getProvince()+"%");
			}
	
		}
		
		Page<Provinces> page= (Page<Provinces>)provincesMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
