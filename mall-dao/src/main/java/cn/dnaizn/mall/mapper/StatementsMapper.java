package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.Statements;
import cn.dnaizn.mall.pojo.StatementsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatementsMapper {
    int countByExample(StatementsExample example);

    int deleteByExample(StatementsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Statements record);

    int insertSelective(Statements record);

    List<Statements> selectByExample(StatementsExample example);

    Statements selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Statements record, @Param("example") StatementsExample example);

    int updateByExample(@Param("record") Statements record, @Param("example") StatementsExample example);

    int updateByPrimaryKeySelective(Statements record);

    int updateByPrimaryKey(Statements record);
}