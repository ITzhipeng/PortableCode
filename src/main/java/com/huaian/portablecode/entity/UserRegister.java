package com.huaian.portablecode.entity;

import java.io.Serializable;
import java.util.Date;

public class UserRegister implements Serializable {
    private String id;//	ID
    private String openid;//微信识别码
    private String phone;//电话号码(加密)
    private Date regis_time;//注册时间
    private String type;//用户状态(0注销、1有效)
    private String source;//数据来源
    private Date ent_time;//数据入库时间
    private Date upd_time;//数据更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegis_time() {
        return regis_time;
    }

    public void setRegis_time(Date regis_time) {
        this.regis_time = regis_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
