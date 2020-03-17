package com.huaian.portablecode.mapper;

import com.huaian.portablecode.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProfileMapper {

    @Select("select * from USER_INFO u where u.pid = #{openId} and u.cart_num = #{cartNum}")
    UserDetail getInfoByOpenIdAndCartNum(@Param("openId") String openId, @Param("cartNum")String cartNum);

    @Update("update user_info set user_name = #{user_name}, cart_num=#{cart_num},\n" +
            "bel_est = #{bel_est}, det_addr = #{det_addr}, phone = #{phone}\n" +
            "where pid = #{pid}\n" +
            "and cart_num = #{cart_num} ")
    int update(UserDetail userDetail);
}
