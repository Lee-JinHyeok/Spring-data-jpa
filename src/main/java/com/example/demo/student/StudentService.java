package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        /*return List.of(
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
        );*/
        return studentRepository.findAll();
    }
}
