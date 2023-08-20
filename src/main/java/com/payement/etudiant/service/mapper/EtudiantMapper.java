package com.payement.etudiant.service.mapper;

import com.payement.etudiant.model.dto.AnneeAcademiqueDto;
import com.payement.etudiant.model.dto.EtudiantDto;
import com.payement.etudiant.model.dto.FormationDto;
import com.payement.etudiant.model.entities.AnneeAcademique;
import com.payement.etudiant.model.entities.Etudiant;
import com.payement.etudiant.model.entities.Formation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    Etudiant toEntity(EtudiantDto etudiantDto);
    EtudiantDto toDto(Etudiant etudiant);

    Formation toFormationEntity(EtudiantDto etudiantDto);

    void copy(EtudiantDto etudiantDto, @MappingTarget Etudiant etudiant);
}
