package com.huaian.portablecode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@MapperScan("com.huaian.portablecode.mapper")
public class PortableCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortableCodeApplication.class, args);
    }
}
