package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.TransfersList;
import cn.dnaizn.mall.pojo.TransfersListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransfersListMapper {
    int countByExample(TransfersListExample example);

    int deleteByExample(TransfersListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransfersList record);

    int insertSelective(TransfersList record);

    List<TransfersList> selectByExample(TransfersListExample example);

    TransfersList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransfersList record, @Param("example") TransfersListExample example);

    int updateByExample(@Param("record") TransfersList record, @Param("example") TransfersListExample example);

    int updateByPrimaryKeySelective(TransfersList record);

    int updateByPrimaryKey(TransfersList record);
}