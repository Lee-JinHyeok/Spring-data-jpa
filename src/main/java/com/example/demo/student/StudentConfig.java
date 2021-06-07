package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student jh = new Student(
                    "JH",
                    "myredfox1@gmail.com",
                    LocalDate.of(2000, JANUARY, 5),
                    25
            );

            Student ysj = new Student(
                    "YSJ",
                    "ysj@gmail.com",
                    LocalDate.of(2004, JANUARY, 5),
                    25
            );
            repository.saveAll(
                    List.of(jh, ysj)
            );
        };
    }
}
