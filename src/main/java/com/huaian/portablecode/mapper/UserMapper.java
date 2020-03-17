package com.huaian.portablecode.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    @Insert("insert into user(name,sfzhm) values(#{name},#{sfzhm})")
    void addUser(@Param("name")String name ,@Param("sfzhm")String sfzhm);
}
