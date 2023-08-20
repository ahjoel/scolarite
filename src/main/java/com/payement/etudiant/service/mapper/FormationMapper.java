package com.payement.etudiant.service.mapper;

import com.payement.etudiant.model.dto.AnneeAcademiqueDto;
import com.payement.etudiant.model.dto.FormationDto;
import com.payement.etudiant.model.entities.AnneeAcademique;
import com.payement.etudiant.model.entities.Formation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FormationMapper {
    Formation toEntity(FormationDto formationDto);
    FormationDto toDto(Formation formation);

    AnneeAcademique toAnneeAcademiqueEntity(AnneeAcademiqueDto anneeAcademiqueDto);

    void copy(FormationDto formationDto, @MappingTarget Formation formation);
}
