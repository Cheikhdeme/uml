package com.javatechie.controller;

import com.javatechie.dto.FicheDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.Patient;
import com.javatechie.repository.PatientRepository;
import com.javatechie.service.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fiches")
public class FicheController {

    @Autowired
    private FicheService ficheService;


    // Endpoint pour ajouter une fiche
    @PostMapping("/add/{patientId}")
    public ResponseEntity<FicheDTO> addFiche(@RequestBody FicheDTO fiche, @PathVariable Long patientId) {
        try {
            FicheDTO savedFiche = ficheService.saveFiche(fiche, patientId);
            return new ResponseEntity<>(savedFiche, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Gérer l'erreur autrement si nécessaire
        }
    }

    // Endpoint pour récupérer toutes les fiches
    @GetMapping("/all")
    public ResponseEntity<List<FicheDTO>> getAllFiches() {
        List<FicheDTO> fiches = ficheService.getAllFiches();
        return new ResponseEntity<>(fiches, HttpStatus.OK);
    }

    // Endpoint pour récupérer une fiche par son ID
    @GetMapping("/{id}")
    public ResponseEntity<FicheDTO> getFicheById(@PathVariable Long id) {
        return ficheService.getFicheById(id)
                .map(fiche -> new ResponseEntity<>(fiche, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour mettre à jour une fiche
    @PutMapping("/{id}")
    public ResponseEntity<FicheDTO> updateFiche(@PathVariable Long id, @RequestBody FicheDTO fiche) {
        FicheDTO updatedFiche = ficheService.updateFiche(id, fiche);
        return new ResponseEntity<>(updatedFiche, HttpStatus.OK);
    }

    // Endpoint pour supprimer une fiche
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiche(@PathVariable Long id) {
        ficheService.deleteFiche(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
