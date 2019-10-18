package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.SellerExamine;
import cn.dnaizn.mall.pojo.SellerExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerExamineMapper {
    int countByExample(SellerExamineExample example);

    int deleteByExample(SellerExamineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SellerExamine record);

    int insertSelective(SellerExamine record);

    List<SellerExamine> selectByExample(SellerExamineExample example);

    SellerExamine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SellerExamine record, @Param("example") SellerExamineExample example);

    int updateByExample(@Param("record") SellerExamine record, @Param("example") SellerExamineExample example);

    int updateByPrimaryKeySelective(SellerExamine record);

    int updateByPrimaryKey(SellerExamine record);
}