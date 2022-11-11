package com.mandu.yamyam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mandu.yamyam.**.mapper")
public class YamyamApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamyamApplication.class, args);
	}

}
