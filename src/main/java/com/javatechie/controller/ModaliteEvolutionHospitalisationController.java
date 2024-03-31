package com.javatechie.controller;

import com.javatechie.dto.ModaliteEvolutionHospitalisationDTO;
import com.javatechie.service.ModaliteEvolutionHospitalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modaliteEvolutionHospitalisation")
public class ModaliteEvolutionHospitalisationController {

    @Autowired
    private ModaliteEvolutionHospitalisationService modaliteEvolutionHospitalisationService;

    @PostMapping("/add/{id}")
    public ResponseEntity<ModaliteEvolutionHospitalisationDTO> saveModaliteEvolutionHospitalisation(@RequestBody ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO,@PathVariable Long id) {
        ModaliteEvolutionHospitalisationDTO savedModalite = modaliteEvolutionHospitalisationService.saveModaliteEvolutionHospitalisation(modaliteEvolutionHospitalisationDTO,id);
        return new ResponseEntity<>(savedModalite, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ModaliteEvolutionHospitalisationDTO>> getAllModaliteEvolutionHospitalisationDTOs() {
        List<ModaliteEvolutionHospitalisationDTO> modalites = modaliteEvolutionHospitalisationService.getAllModaliteEvolutionHospitalisationDTOs();
        return new ResponseEntity<>(modalites, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModaliteEvolutionHospitalisationDTO> getModaliteEvolutionHospitalisationDTOById(@PathVariable Long id) {
        return modaliteEvolutionHospitalisationService.getModaliteEvolutionHospitalisationDTOById(id)
                .map(modalite -> new ResponseEntity<>(modalite, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModaliteEvolutionHospitalisationDTO> updateModaliteEvolutionHospitalisation(@PathVariable Long id, @RequestBody ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO) {
        ModaliteEvolutionHospitalisationDTO updatedModalite = modaliteEvolutionHospitalisationService.updateModaliteEvolutionHospitalisation(id, modaliteEvolutionHospitalisationDTO);
        return new ResponseEntity<>(updatedModalite, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModaliteEvolutionHospitalisation(@PathVariable Long id) {
        modaliteEvolutionHospitalisationService.deleteModaliteEvolutionHospitalisation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
