package com.example.demo.student2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Student2Service {

    private final Student2Repository student2Repository;

    @Autowired
    public Student2Service(Student2Repository student2Repository) {
        this.student2Repository = student2Repository;
    }

    public List<Student2> getStudents() {

        return student2Repository.findAll();
    }


    public void addNewStudent(Student2 student2) {
        Optional<Student2> student2Optional = student2Repository.findStudent2ByEmail(student2.getEmail());

        if(student2Optional.isPresent()){
            throw new IllegalStateException("email taken");

        }
        student2Repository.save(student2);
        System.out.println(student2);
    }

    public void deleteStudent(Long student2Id) {

        boolean exists = student2Repository.existsById(student2Id);
        if(!exists){
            throw new IllegalStateException("student with id" +student2Id + "does not exists");
        }
        student2Repository.deleteById(student2Id);
    }
    @Transactional
    public void updateStudent(Long student2Id, String username, String email) {
        Student2 student2 = student2Repository.findById(student2Id).orElseThrow(()-> new IllegalStateException("student with id" +student2Id+ "does not exist"));
        if(username != null && username.length() > 0 && !Objects.equals(student2.getUsername(),username)){
            student2.setUsername(username);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student2.getEmail(),email)){
            Optional<Student2> student2Optional = student2Repository.findStudent2ByEmail(email);
            if(student2Optional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student2.setEmail(email);
        }
    }
}
