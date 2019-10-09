package cn.dnaizn.mall.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dnaizn.mall.mapper")
public class MallManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallManagerServiceApplication.class, args);
    }

}
