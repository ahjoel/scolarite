package com.etudiant.scolarite.rest.ressource;

import com.etudiant.scolarite.model.dto.PayementDto;
import com.etudiant.scolarite.service.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payement")
public class PayementControllerRest {
    @Autowired
    PayementService payementService;

    @RequestMapping(path="/getall", method = RequestMethod.GET)
    public ResponseEntity<List<PayementDto>> listePayement() {
        return ResponseEntity.ok(payementService.listPayements());
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Long> enregistrerPayement(@RequestBody PayementDto payementDto){
        return ResponseEntity.ok(payementService.ajouterPayement(payementDto));
    }

    private PayementDto getPayementDtoIdExist(Long id) {
        PayementDto payementDto = PayementDto.builder().id(id).build();
        PayementDto payementDtoFound = payementService.getPayementById(payementDto);

        if (payementDtoFound == null) {
            throw new RuntimeException("Code 257 : l'id du payement que vous voulez modifier n'existe pas");
        }
        return payementDtoFound;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<PayementDto> afficherPayement(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getPayementDtoIdExist(id));
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> modifierPayement(@RequestBody PayementDto payementDto) {
        return ResponseEntity.ok(payementService.modifierPayement(payementDto));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public boolean deletePayement(@PathVariable("id") Long id) {
        return payementService.supprimerPayement(id);
    }
}
