package com.example.hospitalProject;

import com.example.hospitalProject.entities.Patient;
import com.example.hospitalProject.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SpringbootPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPatientApplication.class, args);
    }

    //@Bean
    public CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            Patient p1 = new Patient();
            p1.setNom("Massaadi");
            p1.setPrenom("Ayoub");
            p1.setScore(235);
            p1.setDateNaissance(new Date());
            p1.setMalade(false);

            Patient p2 = new Patient(null,"damin","ahmed",new Date(),true,123);

            Patient p3 = Patient.builder()
                    .nom("yassine")
                    .prenom("daher")
                    .malade(true)
                    .score(456)
                    .dateNaissance(new Date())
                    .build();

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
