package com.payement.etudiant.repository;

import com.payement.etudiant.model.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    boolean existsByCodeEtIgnoreCase(String reference);
    Optional<Etudiant> findEtudiantById(Long id);
}
