package com.etudiant.scolarite.service.mapper;

import com.etudiant.scolarite.model.dto.AnneeAcademiqueDto;
import com.etudiant.scolarite.model.entities.AnneeAcademique;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AnneeAcademiqueMapper {
    AnneeAcademique toEntity(AnneeAcademiqueDto anneeAcademiqueDto);
    AnneeAcademiqueDto toDto(AnneeAcademique anneeAcademique);

    void copy(AnneeAcademiqueDto anneeAcademiqueDto, @MappingTarget AnneeAcademique anneeAcademique);
}
