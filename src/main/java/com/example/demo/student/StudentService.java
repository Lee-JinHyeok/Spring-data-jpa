package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudent(){
        return List.of(
                new Student(
                ),
                new Student(
                        1L,
                        "JH",
                        "myredfox1@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        25
                ),
                new Student(
                        "JH",
                        "myredfox1@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        25
                )
        );
    }
}
