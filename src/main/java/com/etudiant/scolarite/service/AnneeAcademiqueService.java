package com.etudiant.scolarite.service;

import com.etudiant.scolarite.model.dto.AnneeAcademiqueDto;
import com.etudiant.scolarite.model.entities.AnneeAcademique;
import com.etudiant.scolarite.repository.AnneeAcademiqueRepository;
import com.etudiant.scolarite.service.mapper.AnneeAcademiqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnneeAcademiqueService {
    @Autowired
    AnneeAcademiqueRepository anneeAcademiqueRepository;

    @Autowired
    AnneeAcademiqueMapper anneeAcademiqueMapper;

    public List<AnneeAcademiqueDto> listAnneeAcademiques(){
        return anneeAcademiqueRepository.findAll().stream().map(anneeAcademiqueMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterAnneeAcademique(AnneeAcademiqueDto anneeAcademiqueDto){
        checkCodeAnAlreadyUsed(anneeAcademiqueDto);
        return anneeAcademiqueRepository.save(anneeAcademiqueMapper.toEntity(anneeAcademiqueDto)).getId();
    }

    private void checkCodeAnAlreadyUsed(AnneeAcademiqueDto anneeAcademiqueDto) {
        if (anneeAcademiqueRepository.existsByCodeAnIgnoreCase(anneeAcademiqueDto.getCodeAn())){
            throw new RuntimeException("Code 5268 : Il existe déjà une annee academique avec ce code");
        }
    }

    public AnneeAcademiqueDto getAnneeAcademiqueById(AnneeAcademiqueDto anneeAcademiqueDto) {
        AnneeAcademique anneeAcademique = anneeAcademiqueMapper.toEntity(anneeAcademiqueDto);

        AnneeAcademique anneeAcademiqueFound = anneeAcademiqueRepository.findById(anneeAcademique.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return anneeAcademiqueMapper.toDto(anneeAcademiqueFound);
    }

    public boolean modifierAnneeAcademique(AnneeAcademiqueDto anneeAcademiqueDto){
        AnneeAcademique anneeAcademique = anneeAcademiqueMapper.toEntity(anneeAcademiqueDto);

        AnneeAcademique anneeAcademiqueFound = anneeAcademiqueRepository.findAnneeAcademiqueById(anneeAcademique.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de l'annee academique que vous voulez modifier n'existe pas"));

        anneeAcademiqueMapper.copy(anneeAcademiqueDto, anneeAcademiqueFound);

        anneeAcademiqueRepository.save(anneeAcademiqueFound);

        return true;
    }

    public boolean supprimerAnneeAcademique(Long id){
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findAnneeAcademiqueById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : l'annee academique que vous voulez supprimer n'existe pas"));

        anneeAcademiqueRepository.deleteById(anneeAcademique.getId());

        return true;
    }
}
