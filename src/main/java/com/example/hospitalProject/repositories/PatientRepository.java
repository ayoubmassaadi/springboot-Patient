package com.example.hospitalProject.repositories;

import com.example.hospitalProject.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
