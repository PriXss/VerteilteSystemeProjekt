package com.example.demo.student2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Student2Repository extends JpaRepository<Student2 ,Long> {

    @Query("SELECT s FROM Student2 s WHERE s.email = ?1")
    Optional<Student2> findStudent2ByEmail(String email);
}
