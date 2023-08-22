package com.etudiant.scolarite.service;

import com.etudiant.scolarite.model.dto.PayementDto;
import com.etudiant.scolarite.model.entities.Payement;
import com.etudiant.scolarite.model.entities.Etudiant;
import com.etudiant.scolarite.repository.EtudiantRepository;
import com.etudiant.scolarite.repository.PayementRepository;
import com.etudiant.scolarite.service.mapper.PayementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayementService {
    @Autowired
    PayementRepository payementRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    PayementMapper payementMapper;

    public List<PayementDto> listPayements(){
        return payementRepository.findAll().stream().map(payementMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterPayement(PayementDto payementDto){
        checkCodePayAlreadyUsed(payementDto);
        return payementRepository.save(payementMapper.toEntity(payementDto)).getId();
    }

    private void checkCodePayAlreadyUsed(PayementDto payementDto) {
        if (payementRepository.existsByCodePayIgnoreCase(payementDto.getCodePay())){
            throw new RuntimeException("Code 5268 : Il existe déjà un payement avec ce code");
        }
    }

    public PayementDto getPayementById(PayementDto payementDto) {
        Payement payement = payementMapper.toEntity(payementDto);

        Payement payementFound = payementRepository.findById(payement.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return payementMapper.toDto(payementFound);
    }

    public boolean modifierPayement(PayementDto payementDto){
        Payement payement = payementMapper.toEntity(payementDto);

        Payement payementFound = payementRepository.findPayementById(payement.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id du payement que vous voulez modifier n'existe pas"));

        // Récupération de l'étudiant associée à partir de la base de données
        Etudiant etudiant = etudiantRepository.findById(payementDto.getEtudiant().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Etudiant introuvable"));

        payementMapper.copy(payementDto, payementFound);

        payementRepository.save(payementFound);

        return true;
    }

    public boolean supprimerPayement(Long id){
        Payement payement = payementRepository.findPayementById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : le payement que vous voulez supprimer n'existe pas"));

        payementRepository.deleteById(payement.getId());

        return true;
    }
}
