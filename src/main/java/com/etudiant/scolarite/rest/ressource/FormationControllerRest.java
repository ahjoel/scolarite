package com.etudiant.scolarite.rest.ressource;

import com.etudiant.scolarite.model.dto.FormationDto;
import com.etudiant.scolarite.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formation")
public class FormationControllerRest {
    @Autowired
    FormationService formationService;

    @RequestMapping(path="/getall", method = RequestMethod.GET)
    public ResponseEntity<List<FormationDto>> listeFormation() {
        return ResponseEntity.ok(formationService.listFormations());
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Long> enregistrerFormation(@RequestBody FormationDto formationDto){
        return ResponseEntity.ok(formationService.ajouterFormation(formationDto));
    }

    private FormationDto getFormationDtoIdExist(Long id) {
        FormationDto formationDto = FormationDto.builder().id(id).build();
        FormationDto formationDtoFound = formationService.getFormationById(formationDto);

        if (formationDtoFound == null) {
            throw new RuntimeException("Code 257 : l'id de la formation que vous voulez modifier n'existe pas");
        }
        return formationDtoFound;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<FormationDto> afficherFormation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getFormationDtoIdExist(id));
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> modifierFormation(@RequestBody FormationDto formationDto) {
        return ResponseEntity.ok(formationService.modifierFormation(formationDto));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public boolean deleteFormation(@PathVariable("id") Long id) {
        return formationService.supprimerFormation(id);
    }
}
