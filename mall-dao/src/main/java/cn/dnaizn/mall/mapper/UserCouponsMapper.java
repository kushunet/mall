package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.UserCoupons;
import cn.dnaizn.mall.pojo.UserCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCouponsMapper {
    int countByExample(UserCouponsExample example);

    int deleteByExample(UserCouponsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCoupons record);

    int insertSelective(UserCoupons record);

    List<UserCoupons> selectByExample(UserCouponsExample example);

    UserCoupons selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCoupons record, @Param("example") UserCouponsExample example);

    int updateByExample(@Param("record") UserCoupons record, @Param("example") UserCouponsExample example);

    int updateByPrimaryKeySelective(UserCoupons record);

    int updateByPrimaryKey(UserCoupons record);
}