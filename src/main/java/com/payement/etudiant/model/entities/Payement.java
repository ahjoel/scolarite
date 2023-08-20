package com.payement.etudiant.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Payement")
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code")
    private String codePay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="etudiant_id", nullable=false)
    private Etudiant etudiant;

    @Column(name = "date_payement")
    private LocalDate datePay;

    @Column(name = "mt_reglement")
    private Double montantReg;

    @Column(name = "solde")
    private Double solde;
}
