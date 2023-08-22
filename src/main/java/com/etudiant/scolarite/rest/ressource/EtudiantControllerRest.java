package com.etudiant.scolarite.rest.ressource;

import com.etudiant.scolarite.model.dto.EtudiantDto;
import com.etudiant.scolarite.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantControllerRest {
    @Autowired
    EtudiantService etudiantService;

    @RequestMapping(path="/getall", method = RequestMethod.GET)
    public ResponseEntity<List<EtudiantDto>> listeEtudiant() {
        return ResponseEntity.ok(etudiantService.listEtudiants());
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Long> enregistrerEtudiant(@RequestBody EtudiantDto etudiantDto){
        return ResponseEntity.ok(etudiantService.ajouterEtudiant(etudiantDto));
    }

    private EtudiantDto getEtudiantDtoIdExist(Long id) {
        EtudiantDto etudiantDto = EtudiantDto.builder().id(id).build();
        EtudiantDto etudiantDtoFound = etudiantService.getEtudiantById(etudiantDto);

        if (etudiantDtoFound == null) {
            throw new RuntimeException("Code 257 : l'id de l'etudiant que vous voulez modifier n'existe pas");
        }
        return etudiantDtoFound;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<EtudiantDto> afficherEtudiant(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getEtudiantDtoIdExist(id));
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> modifierEtudiant(@RequestBody EtudiantDto etudiantDto) {
        return ResponseEntity.ok(etudiantService.modifierEtudiant(etudiantDto));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public boolean deleteEtudiant(@PathVariable("id") Long id) {
        return etudiantService.supprimerEtudiant(id);
    }
}
