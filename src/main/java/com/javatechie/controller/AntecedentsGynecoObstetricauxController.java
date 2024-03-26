package com.javatechie.controller;

import com.javatechie.dto.AntecedentsGynecoObstetricauxDTO;
import com.javatechie.service.AntecedentsGynecoObstetricauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedents-gyneco-obstetricaux")
public class AntecedentsGynecoObstetricauxController {

    @Autowired
    private AntecedentsGynecoObstetricauxService antecedentsGynecoObstetricauxService;

    @PostMapping("/add/{id}")
    public ResponseEntity<AntecedentsGynecoObstetricauxDTO> saveAntecedentsGynecoObstetricaux(@RequestBody AntecedentsGynecoObstetricauxDTO dto,@PathVariable Long id) {
        AntecedentsGynecoObstetricauxDTO savedDto = antecedentsGynecoObstetricauxService.saveAntecedentsGynecoObstetricaux(dto,id);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AntecedentsGynecoObstetricauxDTO>> getAllAntecedentsGynecoObstetricaux() {
        List<AntecedentsGynecoObstetricauxDTO> antecedents = antecedentsGynecoObstetricauxService.getAllAntecedentsGynecoObstetricaux();
        return new ResponseEntity<>(antecedents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedentsGynecoObstetricauxDTO> getAntecedentsGynecoObstetricauxById(@PathVariable Long id) {
        return antecedentsGynecoObstetricauxService.getAntecedentsGynecoObstetricauxById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentsGynecoObstetricauxDTO> updateAntecedentsGynecoObstetricaux(@PathVariable Long id, @RequestBody AntecedentsGynecoObstetricauxDTO dto) {
        AntecedentsGynecoObstetricauxDTO updatedDto = antecedentsGynecoObstetricauxService.updateAntecedentsGynecoObstetricaux(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntecedentsGynecoObstetricaux(@PathVariable Long id) {
        antecedentsGynecoObstetricauxService.deleteAntecedentsGynecoObstetricaux(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
