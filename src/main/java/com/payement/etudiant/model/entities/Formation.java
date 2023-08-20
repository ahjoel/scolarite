package com.payement.etudiant.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code")
    private String codeFor;
    @Column(name = "libelleFor")
    private String libelleFor;
    @Column(name = "scolarite")
    private Double scolarite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="anneeacamedique_id", nullable=false)
    private AnneeAcademique anneeAcademique;

    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
    private Collection<Etudiant> etudiants;

}
