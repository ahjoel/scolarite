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
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code")
    private String codeEt;
    @Column(name = "nom")
    private String nomEt;
    @Column(name = "prenom")
    private String prenomEt;
    @Column(name = "sexe")
    private Genre sexeEt;
    @Column(name = "date_naissance")
    private LocalDate datenaissEt;
    @Column(name = "mail_etudiant")
    private String mailEt;
    @Column(name = "tel_etudiant")
    private String telEt;
    @Column(name = "mail_parent")
    private String mailParent;
    @Column(name = "tel_parent")
    private String telParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="formation_id", nullable=false)
    private Formation formation;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY)
    private Collection<Payement> payements;

}
