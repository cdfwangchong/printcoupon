package com.cdfg.printcoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.cdfg.printcoupon.dao")
@SpringBootApplication
public class PrintcouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrintcouponApplication.class, args);
    }

}
