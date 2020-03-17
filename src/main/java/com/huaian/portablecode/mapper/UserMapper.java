package com.huaian.portablecode.mapper;

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
}
