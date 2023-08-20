package com.payement.etudiant.rest.ressource;

import com.payement.etudiant.model.dto.AnneeAcademiqueDto;
import com.payement.etudiant.service.AnneeAcademiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anneeacademique")
public class AnneeAcademiqueControllerRest {
    @Autowired
    AnneeAcademiqueService anneeAcademiqueService;

    @RequestMapping(path="/getall", method = RequestMethod.GET)
    public ResponseEntity<List<AnneeAcademiqueDto>> listeAnneeAcademique() {
        return ResponseEntity.ok(anneeAcademiqueService.listAnneeAcademiques());
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Long> enregistrerAnneeAcademique(@RequestBody AnneeAcademiqueDto anneeAcademiqueDto){
        return ResponseEntity.ok(anneeAcademiqueService.ajouterAnneeAcademique(anneeAcademiqueDto));
    }

    private AnneeAcademiqueDto getAnneeAcademiqueDtoIdExist(Long id) {
        AnneeAcademiqueDto anneeAcademiqueDto = AnneeAcademiqueDto.builder().id(id).build();
        AnneeAcademiqueDto anneeAcademiqueDtoFound = anneeAcademiqueService.getAnneeAcademiqueById(anneeAcademiqueDto);

        if (anneeAcademiqueDtoFound == null) {
            throw new RuntimeException("Code 257 : l'id de l'annee academique que vous voulez modifier n'existe pas");
        }
        return anneeAcademiqueDtoFound;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnneeAcademiqueDto> afficherAnneeAcademique(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getAnneeAcademiqueDtoIdExist(id));
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> modifierAnneeAcademique(@RequestBody AnneeAcademiqueDto anneeAcademiqueDto) {
        return ResponseEntity.ok(anneeAcademiqueService.modifierAnneeAcademique(anneeAcademiqueDto));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public boolean deleteAnneeAcademique(@PathVariable("id") Long id) {
        return anneeAcademiqueService.supprimerAnneeAcademique(id);
    }
}
