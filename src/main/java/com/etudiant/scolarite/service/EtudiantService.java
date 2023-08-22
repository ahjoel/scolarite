package com.etudiant.scolarite.service;

import com.etudiant.scolarite.model.dto.EtudiantDto;
import com.etudiant.scolarite.model.entities.Formation;
import com.etudiant.scolarite.model.entities.Etudiant;
import com.etudiant.scolarite.repository.EtudiantRepository;
import com.etudiant.scolarite.repository.FormationRepository;
import com.etudiant.scolarite.service.mapper.EtudiantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    EtudiantMapper etudiantMapper;

    public List<EtudiantDto> listEtudiants(){
        return etudiantRepository.findAll().stream().map(etudiantMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterEtudiant(EtudiantDto etudiantDto){
        checkCodeEtAlreadyUsed(etudiantDto);
        return etudiantRepository.save(etudiantMapper.toEntity(etudiantDto)).getId();
    }

    private void checkCodeEtAlreadyUsed(EtudiantDto etudiantDto) {
        if (etudiantRepository.existsByCodeEtIgnoreCase(etudiantDto.getCodeEt())){
            throw new RuntimeException("Code 5268 : Il existe déjà un(e) etudiant(e) avec ce code");
        }
    }

    public EtudiantDto getEtudiantById(EtudiantDto etudiantDto) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDto);

        Etudiant etudiantFound = etudiantRepository.findById(etudiant.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return etudiantMapper.toDto(etudiantFound);
    }

    public boolean modifierEtudiant(EtudiantDto etudiantDto){
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDto);

        Etudiant etudiantFound = etudiantRepository.findEtudiantById(etudiant.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de l'étudiant que vous voulez modifier n'existe pas"));

        // Récupération de la formation associée à partir de la base de données
        Formation formation = formationRepository.findById(etudiantDto.getFormation().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Formation introuvable"));

        etudiantMapper.copy(etudiantDto, etudiantFound);

        etudiantRepository.save(etudiantFound);

        return true;
    }

    public boolean supprimerEtudiant(Long id){
        Etudiant etudiant = etudiantRepository.findEtudiantById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : l'etudiant que vous voulez supprimer n'existe pas"));

        etudiantRepository.deleteById(etudiant.getId());

        return true;
    }
}
