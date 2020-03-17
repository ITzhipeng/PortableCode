package com.huaian.portablecode.entity;

import java.io.Serializable;
import java.util.Date;

public class UserHealthInfo implements Serializable {
    private Long	id ; // ID
    private String	user_id; // 用户id
    private Integer	is_ft_one; // 14天内是否有湖北等疫区旅居史(0否，1是)
    private Integer	is_ft_two; // 14天内是否与来自疫区人员接触(0否，1是)
    private Integer	is_ft_three; // 14天内是否与确诊疑似病人接触(0否，1是)
    private Integer	is_ft_four; // 14天内是否与发热门诊人员接触(0否，1是)
    private Integer	is_ft_five; // 14天内是否有发热、乏力、干咳(0否，1是)
    private Integer	is_sep_stay; // 是否在集中隔离场所停留过(0否，1是)
    private Integer	is_out_ts; // 当前体温是否超过37.2摄氏度(0否，1是)
    private Integer	tt_is_abr; // 30日内是否从国外回淮(0否，1是)
    private String	from_count; // 来淮国家
    private String	source; // 数据来源
    private Date ent_time; // 数据入库时间
    private Date	upd_time; // 数据更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getIs_ft_one() {
        return is_ft_one;
    }

    public void setIs_ft_one(Integer is_ft_one) {
        this.is_ft_one = is_ft_one;
    }

    public Integer getIs_ft_two() {
        return is_ft_two;
    }

    public void setIs_ft_two(Integer is_ft_two) {
        this.is_ft_two = is_ft_two;
    }

    public Integer getIs_ft_three() {
        return is_ft_three;
    }

    public void setIs_ft_three(Integer is_ft_three) {
        this.is_ft_three = is_ft_three;
    }

    public Integer getIs_ft_four() {
        return is_ft_four;
    }

    public void setIs_ft_four(Integer is_ft_four) {
        this.is_ft_four = is_ft_four;
    }

    public Integer getIs_ft_five() {
        return is_ft_five;
    }

    public void setIs_ft_five(Integer is_ft_five) {
        this.is_ft_five = is_ft_five;
    }

    public Integer getIs_sep_stay() {
        return is_sep_stay;
    }

    public void setIs_sep_stay(Integer is_sep_stay) {
        this.is_sep_stay = is_sep_stay;
    }

    public Integer getIs_out_ts() {
        return is_out_ts;
    }

    public void setIs_out_ts(Integer is_out_ts) {
        this.is_out_ts = is_out_ts;
    }

    public Integer getTt_is_abr() {
        return tt_is_abr;
    }

    public void setTt_is_abr(Integer tt_is_abr) {
        this.tt_is_abr = tt_is_abr;
    }

    public String getFrom_count() {
        return from_count;
    }

    public void setFrom_count(String from_count) {
        this.from_count = from_count;
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
