package com.javatechie.controller;

import com.javatechie.dto.AntecedentsPersonnelDTO;
import com.javatechie.service.AntecedentsPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedentPersonnel")
public class AntecedentsPersonnelController {

    @Autowired
    private AntecedentsPersonnelService antecedentsPersonnelService;

    @PostMapping("/add/{ficheId}")
    public ResponseEntity<AntecedentsPersonnelDTO> saveAntecedentsPersonnel(@RequestBody AntecedentsPersonnelDTO antecedentsPersonnelDTO,@PathVariable Long ficheId) {
        AntecedentsPersonnelDTO savedAntecedentsPersonnel = antecedentsPersonnelService.saveAntecedentsPersonnel(antecedentsPersonnelDTO,ficheId);
        return new ResponseEntity<>(savedAntecedentsPersonnel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedentsPersonnelDTO> getAntecedentsPersonnelById(@PathVariable Long id) {
        return antecedentsPersonnelService.getAntecedentsPersonnelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<AntecedentsPersonnelDTO>> getAllAntecedentsPersonnel() {
        List<AntecedentsPersonnelDTO> antecedentsPersonnelDTOs = antecedentsPersonnelService.getAllAntecedentsPersonnelDTOs();
        return new ResponseEntity<>(antecedentsPersonnelDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntecedentsPersonnel(@PathVariable Long id) {
        antecedentsPersonnelService.deleteAntecedentsPersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
