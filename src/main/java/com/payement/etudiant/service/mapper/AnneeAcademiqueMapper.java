package com.payement.etudiant.service.mapper;

import com.payement.etudiant.model.dto.AnneeAcademiqueDto;
import com.payement.etudiant.model.entities.AnneeAcademique;
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
