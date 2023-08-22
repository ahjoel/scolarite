package com.etudiant.scolarite.model.dto;

import com.etudiant.scolarite.model.entities.Genre;
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
