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
public class AnneeAcademiqueDto {
    private Long id;
    private String codeAn;
    private String libelleAn;
    private LocalDate debutAn;
    private LocalDate finAn;
}
