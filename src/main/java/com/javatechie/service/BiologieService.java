package com.javatechie.service;

import com.javatechie.dto.BiologieDTO;
import com.javatechie.entity.Biologie;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.SignesParaclinique;
import com.javatechie.repository.BiologieRepository;
import com.javatechie.repository.EvolutionApresSortieRepository;
import com.javatechie.repository.SignesParacliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BiologieService {

    @Autowired
    private BiologieRepository biologieRepository;
    @Autowired
    private EvolutionApresSortieRepository evolutionApresSortieRepository;
    @Autowired
    private SignesParacliniqueRepository signesParacliniqueRepository;



    public BiologieDTO saveBiologie(BiologieDTO biologieDTO, Long id, boolean isEvolutif) {
        Biologie biologie = BiologieDTO.convertToEntity(biologieDTO);
        if (isEvolutif) {
            Optional<EvolutionApresSortie> evolutionApresSortieOptional = evolutionApresSortieRepository.findById(id);
            if (evolutionApresSortieOptional.isPresent()) {
                EvolutionApresSortie evolutionApresSortie = evolutionApresSortieOptional.get();
                biologie.setEvolutionApresSortie(evolutionApresSortie);
            } else {
                throw new IllegalArgumentException("Evolution Apres Sortie non trouvé par " + id);
            }
        } else {
            Optional<SignesParaclinique> signesParacliniqueOptional = signesParacliniqueRepository.findById(id);
            if (signesParacliniqueOptional.isPresent()) {
                SignesParaclinique signesParaclinique = signesParacliniqueOptional.get();
                biologie.setSignesParaclinique(signesParaclinique);
            } else {
                throw new IllegalArgumentException("Signe paraClinique non trouvé par " + id);
            }
        }
        return BiologieDTO.convertToDTO(biologieRepository.save(biologie));
    }


    public List<BiologieDTO> getAllBiologies() {
        List<Biologie> biologies = biologieRepository.findAll();
        return biologies.stream()
                .map(BiologieDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<BiologieDTO> getBiologieById(Long id) {
        return biologieRepository.findById(id)
                .map(BiologieDTO::convertToDTO);
    }

    public BiologieDTO updateBiologie(Long id, BiologieDTO biologieDTO) {
        Biologie existingBiologie = biologieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Biologie not found with id: " + id));
        Biologie updatedBiologie = BiologieDTO.convertToEntity(biologieDTO);
        updatedBiologie.setId(existingBiologie.getId()); // Assurez-vous que l'ID est défini pour que la mise à jour soit correcte
        return BiologieDTO.convertToDTO(biologieRepository.save(updatedBiologie));
    }

    public void deleteBiologie(Long id) {
        biologieRepository.deleteById(id);
    }
}
