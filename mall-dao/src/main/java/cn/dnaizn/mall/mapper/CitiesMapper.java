package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.Cities;
import cn.dnaizn.mall.pojo.CitiesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CitiesMapper {
    int countByExample(CitiesExample example);

    int deleteByExample(CitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    List<Cities> selectByExample(CitiesExample example);

    Cities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByExample(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);
}