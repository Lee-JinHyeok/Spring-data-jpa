package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email token");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id " + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    //트랜잭션 처리를 위한 어노테이션
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "stdent with id" + studentId + "does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)
        ) {
            student.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)
        ) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
