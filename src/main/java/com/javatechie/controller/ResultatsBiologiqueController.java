package com.javatechie.controller;

import com.javatechie.dto.ResultatsBiologiqueDTO;
import com.javatechie.service.ResultatsBiologiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultats-biologiques")
public class ResultatsBiologiqueController {

    @Autowired
    private ResultatsBiologiqueService resultatsBiologiqueService;

    @PostMapping("/add/{id}")
    public ResponseEntity<ResultatsBiologiqueDTO> saveResultatsBiologique(@RequestBody ResultatsBiologiqueDTO resultatsBiologiqueDTO,@PathVariable Long id) {
        ResultatsBiologiqueDTO savedResultatsBiologique = resultatsBiologiqueService.saveResultatsBiologique(resultatsBiologiqueDTO,id);
        return new ResponseEntity<>(savedResultatsBiologique, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResultatsBiologiqueDTO>> getAllResultatsBiologiqueDTOs() {
        List<ResultatsBiologiqueDTO> resultatsBiologiqueDTOs = resultatsBiologiqueService.getAllResultatsBiologiqueDTOs();
        return new ResponseEntity<>(resultatsBiologiqueDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultatsBiologiqueDTO> getResultatsBiologiqueDTOById(@PathVariable Long id) {
        Optional<ResultatsBiologiqueDTO> resultatsBiologiqueDTO = resultatsBiologiqueService.getResultatsBiologiqueDTOById(id);
        return resultatsBiologiqueDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultatsBiologiqueDTO> updateResultatsBiologique(@PathVariable Long id, @RequestBody ResultatsBiologiqueDTO resultatsBiologiqueDTO) {
        ResultatsBiologiqueDTO updatedResultatsBiologique = resultatsBiologiqueService.updateResultatsBiologique(id, resultatsBiologiqueDTO);
        return new ResponseEntity<>(updatedResultatsBiologique, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultatsBiologique(@PathVariable Long id) {
        resultatsBiologiqueService.deleteResultatsBiologique(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
