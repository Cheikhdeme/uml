package com.javatechie.controller;

import com.javatechie.dto.SignesCliniqueDTO;
import com.javatechie.service.SignesCliniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signesclinique")
public class SignesCliniqueController {

    @Autowired
    private SignesCliniqueService signesCliniqueService;

    @PostMapping("/add/{ficheId}")
    public ResponseEntity<SignesCliniqueDTO> saveSignesClinique(@RequestBody SignesCliniqueDTO signesCliniqueDTO,@PathVariable Long ficheId) {
        SignesCliniqueDTO savedSignesClinique = signesCliniqueService.saveSignesClinique(signesCliniqueDTO,ficheId);
        return new ResponseEntity<>(savedSignesClinique, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SignesCliniqueDTO>> getAllSignesClinique() {
        List<SignesCliniqueDTO> signesCliniqueList = signesCliniqueService.getAllSignesCliniqueDTOs();
        return new ResponseEntity<>(signesCliniqueList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignesCliniqueDTO> getSignesCliniqueById(@PathVariable Long id) {
        return signesCliniqueService.getSignesCliniqueDTOById(id)
                .map(signesCliniqueDTO -> new ResponseEntity<>(signesCliniqueDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignesCliniqueDTO> updateSignesClinique(@PathVariable Long id, @RequestBody SignesCliniqueDTO signesCliniqueDTO) {
        SignesCliniqueDTO updatedSignesClinique = signesCliniqueService.updateSignesClinique(id, signesCliniqueDTO);
        return new ResponseEntity<>(updatedSignesClinique, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignesClinique(@PathVariable Long id) {
        signesCliniqueService.deleteSignesClinique(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
