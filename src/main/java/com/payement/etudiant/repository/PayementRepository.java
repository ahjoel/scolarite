package com.payement.etudiant.repository;

import com.payement.etudiant.model.entities.Etudiant;
import com.payement.etudiant.model.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayementRepository extends JpaRepository<Payement, Long> {
    boolean existsByCodePayIgnoreCase(String reference);
    Optional<Payement> findPayementById(Long id);
}
