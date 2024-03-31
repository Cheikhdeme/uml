package com.javatechie.controller;

import com.javatechie.dto.EvolutionApresSortieDTO;
import com.javatechie.service.EvolutionApresSortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evolutionApresSortie")
public class EvolutionApresSortieController {

    @Autowired
    private EvolutionApresSortieService evolutionApresSortieService;

    @PostMapping("/add/{id}")
    public ResponseEntity<EvolutionApresSortieDTO> saveEvolutionApresSortie(@RequestBody EvolutionApresSortieDTO evolutionApresSortieDTO,@PathVariable Long id) {
        EvolutionApresSortieDTO savedEvolution = evolutionApresSortieService.saveEvolutionApresSortie(evolutionApresSortieDTO,id);
        return new ResponseEntity<>(savedEvolution, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EvolutionApresSortieDTO>> getAllEvolutionApresSortieDTOs() {
        List<EvolutionApresSortieDTO> evolutionList = evolutionApresSortieService.getAllEvolutionApresSortieDTOs();
        return new ResponseEntity<>(evolutionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvolutionApresSortieDTO> getEvolutionApresSortieDTOById(@PathVariable Long id) {
        return evolutionApresSortieService.getEvolutionApresSortieDTOById(id)
                .map(evolution -> new ResponseEntity<>(evolution, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvolutionApresSortieDTO> updateEvolutionApresSortie(@PathVariable Long id, @RequestBody EvolutionApresSortieDTO evolutionApresSortieDTO) {
        EvolutionApresSortieDTO updatedEvolution = evolutionApresSortieService.updateEvolutionApresSortie(id, evolutionApresSortieDTO);
        return new ResponseEntity<>(updatedEvolution, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvolutionApresSortie(@PathVariable Long id) {
        evolutionApresSortieService.deleteEvolutionApresSortie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
