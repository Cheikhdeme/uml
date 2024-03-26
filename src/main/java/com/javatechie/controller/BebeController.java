package com.javatechie.controller;

import com.javatechie.dto.BebeDTO;
import com.javatechie.service.BebeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/bebes")
public class BebeController {

    @Autowired
    private BebeService bebeService;

    @PostMapping("/add/{id}")
    public ResponseEntity<BebeDTO> saveBebe(@RequestBody BebeDTO bebeDTO,@PathVariable Long id) {
        BebeDTO savedBebe = bebeService.saveBebe(bebeDTO,id);
        return new ResponseEntity<>(savedBebe, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BebeDTO>> getAllBebe() {
        List<BebeDTO> bebes = bebeService.getBebes();
        return new ResponseEntity<>(bebes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebeDTO> getBebeById(@PathVariable Long id) {
        Optional<BebeDTO> bebeOptional = bebeService.getBebeById(id);
        return bebeOptional
                .map(bebe -> new ResponseEntity<>(bebe, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BebeDTO> updateBebe(@PathVariable Long id, @RequestBody BebeDTO bebeDTO) {
        BebeDTO updatedBebe = bebeService.updateBebe(id, bebeDTO);
        return new ResponseEntity<>(updatedBebe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBebe(@PathVariable Long id) {
        bebeService.deleteBebe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
