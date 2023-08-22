package com.etudiant.scolarite.repository;

import com.etudiant.scolarite.model.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    boolean existsByCodeForIgnoreCase(String reference);
    Optional<Formation> findFormationById(Long id);
}
