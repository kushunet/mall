package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.Incomes;
import cn.dnaizn.mall.pojo.IncomesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomesMapper {
    int countByExample(IncomesExample example);

    int deleteByExample(IncomesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Incomes record);

    int insertSelective(Incomes record);

    List<Incomes> selectByExample(IncomesExample example);

    Incomes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Incomes record, @Param("example") IncomesExample example);

    int updateByExample(@Param("record") Incomes record, @Param("example") IncomesExample example);

    int updateByPrimaryKeySelective(Incomes record);

    int updateByPrimaryKey(Incomes record);
}