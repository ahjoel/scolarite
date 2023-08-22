package com.etudiant.scolarite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayementDto {
    private Long id;
    private String codePay;
    private EtudiantDto etudiant;
    private LocalDate datePay;
    private Double montantReg;
    private Double solde;
}
