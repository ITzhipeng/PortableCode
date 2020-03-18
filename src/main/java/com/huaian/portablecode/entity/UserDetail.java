package com.huaian.portablecode.entity;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {
    String id  ;//	ID
    String pid;//	同users的id
    String user_name;//	用户姓名(加密)
    String user_id;//	用户id
    String nati;//	国籍
    String cart_typ;//	证件类型(1身份证 2其他)
    String cart_num;//	证件号码(加密)
    String is_regis;//	是否自己填写(0否，1是)
    String regis_rela;//	与注册人的关系type_id=3
    String cart_dir;//	用户身份证照片路径
    String user_dir;//	用户照片路径
    String user_addr;//	用户户口地址
    String user_typ;//	人员类型（外地来淮…）
    String ba_reason;//	来淮事由(企业务工、旅游…)
    Date ba_date;//	来淮日期
    String unit;//	工作单位
    String car_info;//	车辆信息
    String live_typ;//	居住处所类型type_id=6
    String bel_cun;//	所属区县
    String bel_xj;//	所属乡镇/街道
    String bel_soc;//	所属社区
    String bel_netw;//	所属网格
    String bel_est;//	所属小区
    String det_addr;//	详细地址
    String longitude;//	经度
    String latitude;//	纬度
    String identity;//	识别码(身份)
    String user_role;//	用户角色type_id=2
    String area_arr;//	管理区域代码 多个逗号分隔
    String fist_color;//	首次判定健康颜色type_id=1
    String source;//	数据来源
    Date ent_time;//	数据入库时间
    Date upd_time;//	数据更新时间
    String phone; // 手机号码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNati() {
        return nati;
    }

    public void setNati(String nati) {
        this.nati = nati;
    }

    public String getCart_typ() {
        return cart_typ;
    }

    public void setCart_typ(String cart_typ) {
        this.cart_typ = cart_typ;
    }

    public String getCart_num() {
        return cart_num;
    }

    public void setCart_num(String cart_num) {
        this.cart_num = cart_num;
    }

    public String getIs_regis() {
        return is_regis;
    }

    public void setIs_regis(String is_regis) {
        this.is_regis = is_regis;
    }

    public String getRegis_rela() {
        return regis_rela;
    }

    public void setRegis_rela(String regis_rela) {
        this.regis_rela = regis_rela;
    }

    public String getCart_dir() {
        return cart_dir;
    }

    public void setCart_dir(String cart_dir) {
        this.cart_dir = cart_dir;
    }

    public String getUser_dir() {
        return user_dir;
    }

    public void setUser_dir(String user_dir) {
        this.user_dir = user_dir;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

    public String getUser_typ() {
        return user_typ;
    }

    public void setUser_typ(String user_typ) {
        this.user_typ = user_typ;
    }

    public String getBa_reason() {
        return ba_reason;
    }

    public void setBa_reason(String ba_reason) {
        this.ba_reason = ba_reason;
    }

    public Date getBa_date() {
        return ba_date;
    }

    public void setBa_date(Date ba_date) {
        this.ba_date = ba_date;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCar_info() {
        return car_info;
    }

    public void setCar_info(String car_info) {
        this.car_info = car_info;
    }

    public String getLive_typ() {
        return live_typ;
    }

    public void setLive_typ(String live_typ) {
        this.live_typ = live_typ;
    }

    public String getBel_cun() {
        return bel_cun;
    }

    public void setBel_cun(String bel_cun) {
        this.bel_cun = bel_cun;
    }

    public String getBel_xj() {
        return bel_xj;
    }

    public void setBel_xj(String bel_xj) {
        this.bel_xj = bel_xj;
    }

    public String getBel_soc() {
        return bel_soc;
    }

    public void setBel_soc(String bel_soc) {
        this.bel_soc = bel_soc;
    }

    public String getBel_netw() {
        return bel_netw;
    }

    public void setBel_netw(String bel_netw) {
        this.bel_netw = bel_netw;
    }

    public String getBel_est() {
        return bel_est;
    }

    public void setBel_est(String bel_est) {
        this.bel_est = bel_est;
    }

    public String getDet_addr() {
        return det_addr;
    }

    public void setDet_addr(String det_addr) {
        this.det_addr = det_addr;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getArea_arr() {
        return area_arr;
    }

    public void setArea_arr(String area_arr) {
        this.area_arr = area_arr;
    }

    public String getFist_color() {
        return fist_color;
    }

    public void setFist_color(String fist_color) {
        this.fist_color = fist_color;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getEnt_time() {
        return ent_time;
    }

    public void setEnt_time(Date ent_time) {
        this.ent_time = ent_time;
    }

    public Date getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(Date upd_time) {
        this.upd_time = upd_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
