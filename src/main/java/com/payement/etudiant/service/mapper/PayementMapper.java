package com.payement.etudiant.service.mapper;

import com.payement.etudiant.model.dto.EtudiantDto;
import com.payement.etudiant.model.dto.PayementDto;
import com.payement.etudiant.model.entities.Etudiant;
import com.payement.etudiant.model.entities.Formation;
import com.payement.etudiant.model.entities.Payement;
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
