package com.etudiant.scolarite.service.mapper;

import com.etudiant.scolarite.model.dto.EtudiantDto;
import com.etudiant.scolarite.model.entities.Etudiant;
import com.etudiant.scolarite.model.entities.Formation;
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
