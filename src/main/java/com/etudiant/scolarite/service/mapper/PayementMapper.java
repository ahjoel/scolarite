package com.etudiant.scolarite.service.mapper;

import com.etudiant.scolarite.model.dto.EtudiantDto;
import com.etudiant.scolarite.model.dto.PayementDto;
import com.etudiant.scolarite.model.entities.Etudiant;
import com.etudiant.scolarite.model.entities.Payement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PayementMapper {
    Payement toEntity(PayementDto payementDto);
    PayementDto toDto(Payement payement);

    Etudiant toEtudiantEntity(EtudiantDto etudiantDto);

    void copy(PayementDto payementDto, @MappingTarget Payement payement);
}
