package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
      return args -> {
          Student miriam = new Student(
                  "Miriam",
                  21,
                  "Blaue Lagune soll mega sein",
                  "Miriam.Pfeiffer@gmail.com"
          );
          Student sascha = new Student(
                  "Sascha",
                  21,
                  "Bravia in München, ooof wie gut.",
                  "Sascha.Huber@gmail.com"
          );
          Student alex = new Student(
                  "Alex",
                  22,
                  "Mano oh man, der beste ist der zu Hause :)",
                  "Alex.Augustiner@gmail.com"
          );
          repository.saveAll(List.of(miriam,alex,sascha));
      };
    }
}
