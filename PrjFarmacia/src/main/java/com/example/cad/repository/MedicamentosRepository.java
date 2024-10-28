package com.example.cad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cad.entity.Medicamentos;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
}

