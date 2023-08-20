package com.payement.etudiant.model.dto;

import com.payement.etudiant.model.entities.Formation;
import com.payement.etudiant.model.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtudiantDto {
    private Long id;
    private String codeEt;
    private String nomEt;
    private String prenomEt;
    private Genre sexeEt;
    private LocalDate datenaissEt;
    private String mailEt;
    private String telEt;
    private String mailParent;
    private String telParent;
    private FormationDto formation;
}
