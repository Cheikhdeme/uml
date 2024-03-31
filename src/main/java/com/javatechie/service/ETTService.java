package com.javatechie.service;

import com.javatechie.dto.EttDTO;
import com.javatechie.entity.ETT;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.SignesParaclinique;
import com.javatechie.repository.ETTRepository;
import com.javatechie.repository.EvolutionApresSortieRepository;
import com.javatechie.repository.SignesParacliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ETTService {

    @Autowired
    private ETTRepository ettRepository;
    @Autowired
    private EvolutionApresSortieRepository evolutionApresSortieRepository;
    @Autowired
    private SignesParacliniqueRepository signesParacliniqueRepository;

    public EttDTO saveETT(EttDTO ettDTO,Long id,String isEvolutif) {
        ETT ett = EttDTO.convertToEntity(ettDTO);
        if (isEvolutif.equals("evolutif")){
            Optional<EvolutionApresSortie> evolutionApresSortieOptional=evolutionApresSortieRepository.findById(id);
            if (evolutionApresSortieOptional.isPresent()){
                EvolutionApresSortie evolutionApresSortie=evolutionApresSortieOptional.get();
                ett.setEvolutionApresSortie(evolutionApresSortie);
            }
            else {
                throw  new IllegalArgumentException("Evolution Apres Sortie non trouvé par "+id);
            }
        }
        else {
            Optional<SignesParaclinique> signesParacliniqueOptional=signesParacliniqueRepository.findById(id);
            if (signesParacliniqueOptional.isPresent()){
                SignesParaclinique signesParaclinique=signesParacliniqueOptional.get();
                ett.setSignesParaclinique(signesParaclinique);
            }
            else {
                throw  new IllegalArgumentException("Signe paraClinique non trouvé par "+id);
            }
        }

        return EttDTO.convertToDTO(ettRepository.save(ett));
    }

    public List<EttDTO> getAllEttDTOs() {
        List<ETT> etts = ettRepository.findAll();
        return etts.stream()
                .map(EttDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EttDTO> getEttDTOById(Long id) {
        return ettRepository.findById(id)
                .map(EttDTO::convertToDTO);
    }

    public EttDTO updateETT(Long id, EttDTO ettDTO) {
        ETT ett = EttDTO.convertToEntity(ettDTO);
        ett.setId(id);
        EvolutionApresSortie evolutionApresSortie=evolutionApresSortieRepository.findEvolutionApresSortieByEtt(ett);
        SignesParaclinique signesParaclinique=signesParacliniqueRepository.findSignesParacliniqueByEtt(ett);
        if (evolutionApresSortie!=null){
            ett.setEvolutionApresSortie(evolutionApresSortie);
        }
        else if (signesParaclinique!=null){
            ett.setSignesParaclinique(signesParaclinique);
        }
        else return null;
        return EttDTO.convertToDTO(ettRepository.save(ett));
    }

    public void deleteETT(Long id) {
        ettRepository.deleteById(id);
    }
}
