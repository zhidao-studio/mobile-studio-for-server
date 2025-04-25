package io.github.zhidao.ms.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "io.github.zhidao.ms.*")
@MapperScan(basePackages = "io.github.zhidao.ms.*.mapper")
public class RunUmApp {

    public static void main(String[] args) {
        SpringApplication.run(RunUmApp.class, args);
    }

}

