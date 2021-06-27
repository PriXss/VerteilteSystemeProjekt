package com.example.demo.student2;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student2 {
    @Id
    @SequenceGenerator(
            name = "student2_sequence",
            sequenceName = "student2_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student2_sequence"
    )

    private Long id;
    private String username;
    private String email;
    private String message;
    private int age;

    public Student2 (Long id, String username, int age, String message, String email) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
        this.message = message;
    }

    public Student2(String username, int age,String message, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.message = message;
    }

    public Student2() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Student2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", message=" + message +
                ", email='" + email + '\'' +
                '}';
    }
}