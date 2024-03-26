package com.javatechie.controller;

import com.javatechie.dto.AntecedentMedicalDTO;
import com.javatechie.service.AntecedentMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/antecedents")
public class AntecedentMedicalController {

    @Autowired
    private AntecedentMedicalService antecedentMedicalService;

    @PostMapping("/add/{id}")
    public ResponseEntity<AntecedentMedicalDTO> saveAntecedentMedical(@RequestBody AntecedentMedicalDTO antecedentMedicalDTO,@PathVariable Long id) {
        AntecedentMedicalDTO savedAntecedentMedicalDTO = antecedentMedicalService.saveAntecedentMedical(antecedentMedicalDTO,id);
        return new ResponseEntity<>(savedAntecedentMedicalDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AntecedentMedicalDTO>> getAllAntecedentMedicalDTOs() {
        List<AntecedentMedicalDTO> antecedentMedicalDTOs = antecedentMedicalService.getAllAntecedentMedicalDTOs();
        return new ResponseEntity<>(antecedentMedicalDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedentMedicalDTO> getAntecedentMedicalDTOById(@PathVariable("id") Long id) {
        Optional<AntecedentMedicalDTO> antecedentMedicalDTOOptional = antecedentMedicalService.getAntecedentMedicalDTOById(id);
        return antecedentMedicalDTOOptional.map(antecedentMedicalDTO -> new ResponseEntity<>(antecedentMedicalDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AntecedentMedicalDTO> updateAntecedentMedical(@PathVariable("id") Long id, @RequestBody AntecedentMedicalDTO antecedentMedicalDTO) {
        AntecedentMedicalDTO updatedAntecedentMedicalDTO = antecedentMedicalService.updateAntecedentMedical(id, antecedentMedicalDTO);
        return new ResponseEntity<>(updatedAntecedentMedicalDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAntecedentMedical(@PathVariable("id") Long id) {
        antecedentMedicalService.deleteAntecedentMedical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
