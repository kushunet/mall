package cn.dnaizn.mall.address;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dnaizn.mall.mapper")
public class MallAddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAddressServiceApplication.class, args);
    }

}
