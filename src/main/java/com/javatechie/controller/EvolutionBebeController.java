package com.javatechie.controller;

import com.javatechie.dto.EvolutionBebeDTO;
import com.javatechie.service.EvolutionBebeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evolutionBebe")
public class EvolutionBebeController {

    @Autowired
    private EvolutionBebeService evolutionBebeService;

    @PostMapping("/add/{id}")
    public ResponseEntity<EvolutionBebeDTO> saveEvolutionBebe(@RequestBody EvolutionBebeDTO evolutionBebeDTO,@PathVariable Long id) {
        EvolutionBebeDTO savedEvolutionBebe = evolutionBebeService.saveEvolutionBebe(evolutionBebeDTO,id);
        return new ResponseEntity<>(savedEvolutionBebe, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EvolutionBebeDTO>> getAllEvolutionBebeDTOs() {
        List<EvolutionBebeDTO> evolutionBebeDTOs = evolutionBebeService.getAllEvolutionBebeDTOs();
        return new ResponseEntity<>(evolutionBebeDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvolutionBebeDTO> getEvolutionBebeDTOById(@PathVariable Long id) {
        Optional<EvolutionBebeDTO> evolutionBebeDTO = evolutionBebeService.getEvolutionBebeDTOById(id);
        return evolutionBebeDTO.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvolutionBebeDTO> updateEvolutionBebe(@PathVariable Long id, @RequestBody EvolutionBebeDTO evolutionBebeDTO) {
        EvolutionBebeDTO updatedEvolutionBebe = evolutionBebeService.updateEvolutionBebe(id, evolutionBebeDTO);
        return new ResponseEntity<>(updatedEvolutionBebe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvolutionBebe(@PathVariable Long id) {
        evolutionBebeService.deleteEvolutionBebe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
