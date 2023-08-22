package com.etudiant.scolarite.service.mapper;

import com.etudiant.scolarite.model.dto.AnneeAcademiqueDto;
import com.etudiant.scolarite.model.dto.FormationDto;
import com.etudiant.scolarite.model.entities.AnneeAcademique;
import com.etudiant.scolarite.model.entities.Formation;
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
