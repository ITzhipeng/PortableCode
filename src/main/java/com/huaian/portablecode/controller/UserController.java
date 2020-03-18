package com.huaian.portablecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.entity.UserHealthInfo;
import com.huaian.portablecode.entity.UserRegister;
import com.huaian.portablecode.service.UserService;
import com.huaian.portablecode.utils.AESUtil;
import com.huaian.portablecode.utils.RedisUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.huaian.portablecode.vo.ResultVo;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("register")
    public Object register(@RequestBody JSONObject object) {
        String name = AESUtil.encryptStr(object.get("name").toString());
        ;
        String zjhm = AESUtil.encryptStr(object.get("zjhm").toString());
        if (ObjectUtils.isEmpty(name)) {
            return ResultVo.getFailed("姓名不可为空");
        } else if (ObjectUtils.isEmpty(zjhm)) {
            return ResultVo.getFailed("身份证号码不可为空");
        } else {
//            UUID uuid = UUID.randomUUID();
            String id = "111";
            System.out.println(id);
            //用户注册信息表
            UserRegister userRegister = new UserRegister();
//            String openid = redisUtil.get("openid").toString();
            String openid = "12321234";
            String phone = object.get("phone").toString();
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date regis_time = new Date(System.currentTimeMillis());
            String type = "1";
            String source = "1";
            Date ent_time = new Date(System.currentTimeMillis());
            Date upd_time = new Date(System.currentTimeMillis());
            userRegister.setId(id);
            userRegister.setOpenid(openid);
            userRegister.setRegis_time(regis_time);
            userRegister.setType(type);
            userRegister.setSource(source);
            userRegister.setEnt_time(ent_time);
            userRegister.setUpd_time(upd_time);
            userRegister.setPhone(object.get("phone").toString());
            userRegister.setZjhm(zjhm);
            userService.getUserRegis(userRegister);
            logger.info("用户注册信息表数据插入成功");


//            userService.addUser(object.get("name").toString(), object.get("sfzhm").toString());
            return ResultVo.getSuccess("注册成功");
        }
    }

    @PostMapping("getUserInfo")
    public Object getUserInfo(@RequestBody JSONObject object) {
        //用户信息表
        JSONObject jsonObject = new JSONObject();

        String sfzhm = userService.getZjhm(AESUtil.encryptStr(object.get("zjhm").toString()));
        if (!ObjectUtils.isEmpty(sfzhm)) {
            jsonObject.put("flag", "1");
            return ResultVo.getSuccess("Success", jsonObject);
        } else {
            UserDetail userDetail = new UserDetail();
            String name = AESUtil.encryptStr(object.get("name").toString());
            String zjhm = AESUtil.encryptStr(object.get("zjhm").toString());
            String openid = "12321234";
            String phone = object.get("phone").toString();
            String id = "111";
            Date ent_time = new Date(System.currentTimeMillis());

            userDetail.setId(id);
            userDetail.setPid(openid);
            userDetail.setUser_name(name);
            userDetail.setUser_id("11");
            //国籍
            userDetail.setNati(object.get("nati").toString());

            //证件类型(1身份证 2其他)
            userDetail.setCart_typ(String.valueOf(object.get("cart_typ")));
            userDetail.setCart_num(zjhm);
            userDetail.setIs_regis(String.valueOf(object.get("is_regis")));
            userDetail.setRegis_rela(String.valueOf(object.get("regis_rela")));
            userDetail.setCart_dir("");
            userDetail.setUser_dir("");
            userDetail.setUser_addr("");
            //人员类型
            userDetail.setUser_typ(String.valueOf(object.get("user_typ")));
            userDetail.setBa_reason("11");
            userDetail.setBa_date(ent_time);
            //工作单位
            userDetail.setUnit(object.get("unit").toString());
            //车辆信息
            userDetail.setCar_info(object.get("car_info").toString());
            //居住处所类型type_id=6
            userDetail.setLive_typ("11");
            userDetail.setBel_cun("");
            userDetail.setBel_xj("");
            //所属社区
            userDetail.setBel_soc(object.get("bel_soc").toString());
            userDetail.setBel_netw("");
            //所属小区
            userDetail.setBel_est(object.get("bel_est").toString());
            //详细地址
            userDetail.setDet_addr(object.get("det_addr").toString());
            userDetail.setLongitude("11");
            userDetail.setLatitude("11");
            userDetail.setIdentity("");
            userDetail.setUser_role("11");
            userDetail.setArea_arr("");
            userDetail.setFist_color("11");
            userDetail.setSource("1");
            userDetail.setEnt_time(ent_time);
            userDetail.setUpd_time(ent_time);
            userDetail.setPhone(phone);
            userService.getUserInfo(userDetail);
            logger.info("用户详情数据插入成功");

            //用户健康信息表
            UserHealthInfo userHealthInfo = new UserHealthInfo();
            userHealthInfo.setId(Long.valueOf(id));
            userHealthInfo.setUser_id(openid);
            userHealthInfo.setIs_ft_one(Integer.valueOf(String.valueOf(object.get("is_ft_one"))));
            userHealthInfo.setIs_ft_two(Integer.valueOf(String.valueOf(object.get("is_ft_two"))));
            userHealthInfo.setIs_ft_three(Integer.valueOf(String.valueOf(object.get("is_ft_three"))));
            userHealthInfo.setIs_ft_four(Integer.valueOf(String.valueOf(object.get("is_ft_four"))));
            userHealthInfo.setIs_ft_five(Integer.valueOf(String.valueOf(object.get("is_ft_five"))));
            userHealthInfo.setIs_sep_stay(Integer.valueOf(String.valueOf(object.get("is_sep_stay"))));
            userHealthInfo.setIs_out_ts(Integer.valueOf(String.valueOf(object.get("is_out_ts"))));
            userHealthInfo.setTt_is_abr(Integer.valueOf(String.valueOf(object.get("tt_is_abr"))));
            userHealthInfo.setFrom_count("1");
            userHealthInfo.setSource("1");
            userHealthInfo.setEnt_time(ent_time);
            userHealthInfo.setUpd_time(ent_time);
            userService.user_health_info(userHealthInfo);
            logger.info("用户健康信息表数据插入成功");
            jsonObject.put("flag", "0");
            return ResultVo.getSuccess("Success", jsonObject);

        }
    }

    @PostMapping("login")
    public Object wxLogin(@RequestParam(defaultValue = "") String js_code) throws Exception {
        logger.info("登录code:", js_code);
        if (!ObjectUtils.isEmpty(js_code)) {
            JSONObject jsonResult = userService.login(js_code);
            if (jsonResult.toString().contains("errcode")) {
                // 登陆凭证校验错误 code been used
                return ResultVo.getFailed("登录失败！");
            }

            String md5Key = DigestUtils.md5Hex(jsonResult + "HSA_WX_LOGIN");
            String redisKey = "HSA_" + md5Key;
            // 保存至Redis
            redisUtil.set(redisKey, jsonResult, Duration.ofDays(7).toMillis());
            return ResultVo.getSuccess("数据返回成功", redisKey);
        } else {
            return ResultVo.getFailed("js_code不可为空");
        }

    }

    @PostMapping("getPhone")
    public Object getUserPhone(@RequestParam(defaultValue = "") String encrypdata,
                               @RequestParam(defaultValue = "") String ticket,
                               @RequestParam(defaultValue = "") String ivdata) {
        if (ObjectUtils.isEmpty(ticket)) {
            return ResultVo.getFailed("ticket为空！");
        }
        JSONObject json = (JSONObject) redisUtil.get(ticket);
        if (ObjectUtils.isEmpty(json)) {
            return ResultVo.getFailed("获取用户session_key失败，请检查联系后端 ");
        }
        String sessionKey = (String) json.get("session_key");
        String userPhone = userService.getUserPhone(sessionKey, encrypdata, ivdata);

        return ResultVo.getSuccess("获取用户电话成功！", userPhone);
    }
}
