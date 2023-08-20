package com.payement.etudiant.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "AnneeAcademique")
public class AnneeAcademique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code")
    private String codeAn;
    @Column(name = "libelle")
    private String libelleAn;
    @Column(name = "annee_debut")
    private LocalDate debutAn;
    @Column(name = "fin_debut")
    private LocalDate finAn;

    @OneToMany(mappedBy = "anneeAcademique", fetch = FetchType.LAZY)
    private Collection<Formation> formations;
}
