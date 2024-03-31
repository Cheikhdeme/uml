package com.javatechie.controller;

import com.javatechie.dto.TraitementMedicalDTO;
import com.javatechie.service.TraitementMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/traitementMedical")
public class TraitementMedicalController {

    @Autowired
    private TraitementMedicalService traitementMedicalService;

    @PostMapping("/add/{ficheId}")
    public ResponseEntity<TraitementMedicalDTO> saveTraitementMedical(@RequestBody TraitementMedicalDTO traitementMedicalDTO,@PathVariable Long ficheId) {
        TraitementMedicalDTO savedTraitementMedical = traitementMedicalService.saveTraitementMedical(traitementMedicalDTO,ficheId);
        return new ResponseEntity<>(savedTraitementMedical, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TraitementMedicalDTO>> getAllTraitementMedicals() {
        List<TraitementMedicalDTO> traitementMedicalDTOs = traitementMedicalService.getAllTraitementMedicalDTOs();
        return new ResponseEntity<>(traitementMedicalDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraitementMedicalDTO> getTraitementMedicalById(@PathVariable Long id) {
        Optional<TraitementMedicalDTO> traitementMedicalDTO = traitementMedicalService.getTraitementMedicalDTOById(id);
        return traitementMedicalDTO.map(traitementMedical -> new ResponseEntity<>(traitementMedical, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraitementMedicalDTO> updateTraitementMedical(@PathVariable Long id, @RequestBody TraitementMedicalDTO traitementMedicalDTO) {
        TraitementMedicalDTO updatedTraitementMedical = traitementMedicalService.updateTraitementMedical(id, traitementMedicalDTO);
        return new ResponseEntity<>(updatedTraitementMedical, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraitementMedical(@PathVariable Long id) {
        traitementMedicalService.deleteTraitementMedical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
