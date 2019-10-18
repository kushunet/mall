package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.FullReduction;
import cn.dnaizn.mall.pojo.FullReductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FullReductionMapper {
    int countByExample(FullReductionExample example);

    int deleteByExample(FullReductionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FullReduction record);

    int insertSelective(FullReduction record);

    List<FullReduction> selectByExample(FullReductionExample example);

    FullReduction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FullReduction record, @Param("example") FullReductionExample example);

    int updateByExample(@Param("record") FullReduction record, @Param("example") FullReductionExample example);

    int updateByPrimaryKeySelective(FullReduction record);

    int updateByPrimaryKey(FullReduction record);
}