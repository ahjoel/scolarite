package com.etudiant.scolarite.repository;

import com.etudiant.scolarite.model.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    boolean existsByCodeEtIgnoreCase(String reference);
    Optional<Etudiant> findEtudiantById(Long id);
}
