package com.etudiant.scolarite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormationDto {
    private Long id;
    private String codeFor;
    private String libelleFor;
    private Double scolarite;
    private AnneeAcademiqueDto anneeAcademique;
}
