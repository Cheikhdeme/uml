package com.javatechie.controller;

import com.javatechie.dto.BiologieDTO;
import com.javatechie.service.BiologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/biologie")
public class BiologieController {

    @Autowired
    private BiologieService biologieService;

    @PostMapping("/add/{id}/{evolutif}")
    public ResponseEntity<BiologieDTO> saveBiologie(@RequestBody BiologieDTO biologieDTO,@PathVariable Long id,@PathVariable String evolutif) {
        BiologieDTO savedBiologie = biologieService.saveBiologie(biologieDTO,id,evolutif);
        return new ResponseEntity<>(savedBiologie, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BiologieDTO> getBiologieById(@PathVariable Long id) {
        Optional<BiologieDTO> biologieDTOOptional = biologieService.getBiologieById(id);
        return biologieDTOOptional.map(biologieDTO -> new ResponseEntity<>(biologieDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BiologieDTO>> getAllBiologie() {
        List<BiologieDTO> biologieDTOs = biologieService.getAllBiologies();
        return new ResponseEntity<>(biologieDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BiologieDTO> updateBiologie(@PathVariable Long id, @RequestBody BiologieDTO biologieDTO) {
        BiologieDTO updatedBiologie = biologieService.updateBiologie(id, biologieDTO);
        return new ResponseEntity<>(updatedBiologie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiologie(@PathVariable Long id) {
        biologieService.deleteBiologie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
