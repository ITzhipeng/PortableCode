package com.huaian.portablecode.mapper;

import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.entity.UserHealthInfo;
import com.huaian.portablecode.entity.UserRegister;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(name,sfzhm) values(#{name},#{sfzhm})")
    void addUser(@Param("name") String name, @Param("sfzhm") String sfzhm);

    @Select("select BEL_CUN from OTH_ABROAD_HA where rownum <= 1")
    List<String> query();

    @Insert("insert into user_regis (id,openid,phone,regis_time,type,source,ent_time,upd_time)values(#{id},#{openid},#{phone},#{regis_time},#{type},#{source},#{ent_time},#{upd_time})")
    void getUserRegis(UserRegister userRegister);

@Insert("insert into user_info (id,pid,user_name,user_id,nati,cart_typ,cart_num,is_regis,regis_rela,cart_dir,user_dir,user_addr,user_typ,ba_reason,ba_date,unit,car_info,live_typ,bel_cun,bel_xj,bel_soc,bel_netw,bel_est,det_addr,longitude,latitude,identity,user_role,area_arr,fist_color,source,ent_time,upd_time,phone)values(#{id},#{pid},#{user_name},#{user_id},#{nati},#{cart_typ},#{cart_num},#{is_regis},#{regis_rela},#{cart_dir},#{user_dir},#{user_addr},#{user_typ},#{ba_reason},#{ba_date},#{unit},#{car_info},#{live_typ},#{bel_cun},#{bel_xj},#{bel_soc},#{bel_netw},#{bel_est},#{det_addr},#{longitude},#{latitude},#{identity},#{user_role},#{area_arr},#{fist_color},#{source},#{ent_time},#{upd_time},#{phone})")
    void getUserInfo(UserDetail userDetail);

@Insert("insert into user_health_info (id,user_id,is_ft_one,is_ft_two,is_ft_three,is_ft_four,\n" +
        "    is_ft_five,is_sep_stay,is_out_ts,tt_is_abr,from_count,source,ent_time,upd_time)\n" +
        "    values(#{id},#{user_id},#{is_ft_one},#{is_ft_two},#{is_ft_three},#{is_ft_four},\n" +
        "    #{is_ft_five},#{is_sep_stay},#{is_out_ts},#{tt_is_abr},#{from_count},#{source},\n" +
        "    #{ent_time},#{upd_time})")
    void user_health_info(UserHealthInfo userHealthInfo);
}
