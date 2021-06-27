package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String username;
    private String email;
    private String message;
    private int age;

    public Student(Long id,
                   String username,
                   int age,
                   String message,
                   String email) {

        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
        this.message = message;
    }

    public Student(String username,
                   int age,
                   String message,
                   String email) {

        this.username = username;
        this.age = age;
        this.email = email;
        this.message = message;
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.email = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", message=" + message +
                ", email='" + email + '\'' +
                '}';
    }
}
