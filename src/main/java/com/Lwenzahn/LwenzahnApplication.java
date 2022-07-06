package com.Lwenzahn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/Lwenzahn/mapper")
public class LwenzahnApplication {
    public static void main(String[] args) {
        SpringApplication.run(LwenzahnApplication.class, args);
    }
}
