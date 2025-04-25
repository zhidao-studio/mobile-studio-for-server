package io.github.zhidao.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leshun Ls Zhan
 */
@SpringBootApplication
@MapperScan("io.github.zhidao.code.dao")
public class RunApp {

	public static void main(String[] args) {
		SpringApplication.run(RunApp.class, args);
	}
}
