package com.etudiant.scolarite.repository;

import com.etudiant.scolarite.model.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayementRepository extends JpaRepository<Payement, Long> {
    boolean existsByCodePayIgnoreCase(String reference);
    Optional<Payement> findPayementById(Long id);
}
