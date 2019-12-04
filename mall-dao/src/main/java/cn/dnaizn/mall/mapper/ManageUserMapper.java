package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.ManageUser;
import cn.dnaizn.mall.pojo.ManageUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageUserMapper {
    int countByExample(ManageUserExample example);

    int deleteByExample(ManageUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManageUser record);

    int insertSelective(ManageUser record);

    List<ManageUser> selectByExample(ManageUserExample example);

    ManageUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManageUser record, @Param("example") ManageUserExample example);

    int updateByExample(@Param("record") ManageUser record, @Param("example") ManageUserExample example);

    int updateByPrimaryKeySelective(ManageUser record);

    int updateByPrimaryKey(ManageUser record);
}