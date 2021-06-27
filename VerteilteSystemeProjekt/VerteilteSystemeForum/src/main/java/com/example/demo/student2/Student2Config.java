package com.example.demo.student2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Student2Config {
    @Bean
    CommandLineRunner commandLineRunner2 (Student2Repository repository){
        return args -> {
            Student2 peter = new Student2(
                    "Peter",
                    21,
                    "Fische soll man nicht mit Vogelfutter füttern!",
                    "Peter.Petersen@gmail.com"
            );
            Student2 hans = new Student2(
                    "Hans",
                    21,
                    "Hä, ich dachte das geht locker klar.",
                    "Hans.hansel@gmail.com"
            );
            Student2 alex = new Student2(
                    "Alex",
                    22,
                    "Man ey, was man hier alles lesen muss ^^",
                    "Alex.alexandribus@gmail.com"
            );

            repository.saveAll(
                    List.of(peter,hans,alex)
            );


        };

    }
}
