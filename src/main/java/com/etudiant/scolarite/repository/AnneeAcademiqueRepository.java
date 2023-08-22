package com.etudiant.scolarite.repository;

import com.etudiant.scolarite.model.entities.AnneeAcademique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnneeAcademiqueRepository extends JpaRepository<AnneeAcademique, Long> {
    boolean existsByCodeAnIgnoreCase(String reference);
    Optional<AnneeAcademique> findAnneeAcademiqueByCodeAn(String nom);
    Optional<AnneeAcademique> findAnneeAcademiqueById(Long id);
}
