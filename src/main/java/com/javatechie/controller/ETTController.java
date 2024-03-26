package com.javatechie.controller;

import com.javatechie.dto.EttDTO;
import com.javatechie.service.ETTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ett")
public class ETTController {

    @Autowired
    private ETTService ettService;

    @PostMapping("/add/{id}/{evolutif}")
    public ResponseEntity<EttDTO> saveETT(@RequestBody EttDTO ettDTO,@PathVariable Long id,@PathVariable boolean evolutif) {
        EttDTO savedETT = ettService.saveETT(ettDTO,id,evolutif);
        return new ResponseEntity<>(savedETT, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<EttDTO>> getAllETTs() {
        List<EttDTO> etts = ettService.getAllEttDTOs();
        return new ResponseEntity<>(etts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EttDTO> getETTById(@PathVariable Long id) {
        return ettService.getEttDTOById(id)
                .map(ettDTO -> new ResponseEntity<>(ettDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EttDTO> updateETT(@PathVariable Long id, @RequestBody EttDTO ettDTO) {
        EttDTO updatedETT = ettService.updateETT(id, ettDTO);
        return new ResponseEntity<>(updatedETT, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteETT(@PathVariable Long id) {
        ettService.deleteETT(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
