package com.etudiant.scolarite.service;

import com.etudiant.scolarite.model.dto.FormationDto;
import com.etudiant.scolarite.model.entities.AnneeAcademique;
import com.etudiant.scolarite.model.entities.Formation;
import com.etudiant.scolarite.repository.AnneeAcademiqueRepository;
import com.etudiant.scolarite.repository.FormationRepository;
import com.etudiant.scolarite.service.mapper.FormationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormationService {
    @Autowired
    FormationRepository formationRepository;

    @Autowired
    AnneeAcademiqueRepository anneeAcademiqueRepository;

    @Autowired
    FormationMapper formationMapper;

    public List<FormationDto> listFormations(){
        return formationRepository.findAll().stream().map(formationMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterFormation(FormationDto formationDto){
        checkCodeForAlreadyUsed(formationDto);
        return formationRepository.save(formationMapper.toEntity(formationDto)).getId();
    }

    private void checkCodeForAlreadyUsed(FormationDto formationDto) {
        if (formationRepository.existsByCodeForIgnoreCase(formationDto.getCodeFor())){
            throw new RuntimeException("Code 5268 : Il existe déjà une formation avec ce code");
        }
    }

    public FormationDto getFormationById(FormationDto formationDto) {
        Formation formation = formationMapper.toEntity(formationDto);

        Formation formationFound = formationRepository.findById(formation.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return formationMapper.toDto(formationFound);
    }

    public boolean modifierFormation(FormationDto formationDto){
        Formation formation = formationMapper.toEntity(formationDto);

        Formation formationFound = formationRepository.findFormationById(formation.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de la formation que vous voulez modifier n'existe pas"));

        // Récupération de l'annee academique associée à partir de la base de données
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findById(formationDto.getAnneeAcademique().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Année academique introuvable"));

        formationMapper.copy(formationDto, formationFound);

        formationRepository.save(formationFound);

        return true;
    }

    public boolean supprimerFormation(Long id){
        Formation formation = formationRepository.findFormationById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la formation que vous voulez supprimer n'existe pas"));

        formationRepository.deleteById(formation.getId());

        return true;
    }
}
