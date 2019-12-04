package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.StatementsList;
import cn.dnaizn.mall.pojo.StatementsListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatementsListMapper {
    int countByExample(StatementsListExample example);

    int deleteByExample(StatementsListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatementsList record);

    int insertSelective(StatementsList record);

    List<StatementsList> selectByExample(StatementsListExample example);

    StatementsList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatementsList record, @Param("example") StatementsListExample example);

    int updateByExample(@Param("record") StatementsList record, @Param("example") StatementsListExample example);

    int updateByPrimaryKeySelective(StatementsList record);

    int updateByPrimaryKey(StatementsList record);
}