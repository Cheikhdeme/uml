package com.javatechie.controller;

import com.javatechie.dto.SignesParacliniqueDTO;
import com.javatechie.service.SignesParacliniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signeParaclinique")
public class SignesParacliniqueController {

    @Autowired
    private SignesParacliniqueService signesParacliniqueService;

    @PostMapping("/add/{ficheId}")
    public ResponseEntity<SignesParacliniqueDTO> saveSignesParaclinique(@RequestBody SignesParacliniqueDTO signesParacliniqueDTO,@PathVariable Long ficheId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(signesParacliniqueService.saveSignesParaclinique(signesParacliniqueDTO,ficheId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SignesParacliniqueDTO>> getAllSignesParacliniqueDTOs() {
        return ResponseEntity.ok().body(signesParacliniqueService.getAllSignesParacliniqueDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignesParacliniqueDTO> getSignesParacliniqueDTOById(@PathVariable Long id) {
        Optional<SignesParacliniqueDTO> signesParacliniqueDTO = signesParacliniqueService.getSignesParacliniqueDTOById(id);
        return signesParacliniqueDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignesParacliniqueDTO> updateSignesParaclinique(@PathVariable Long id, @RequestBody SignesParacliniqueDTO signesParacliniqueDTO) {
        return ResponseEntity.ok().body(signesParacliniqueService.updateSignesParaclinique(id, signesParacliniqueDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignesParaclinique(@PathVariable Long id) {
        signesParacliniqueService.deleteSignesParaclinique(id);
        return ResponseEntity.noContent().build();
    }
}
