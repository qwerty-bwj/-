package com.example.student_command;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xiaobao
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.example.student_command.mapper")
public class StudentCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCommandApplication.class, args);
    }

}
