package com.javatechie.service;

import com.javatechie.dto.SignesParacliniqueDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.SignesParaclinique;
import com.javatechie.repository.FicheRepository;
import com.javatechie.repository.SignesParacliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignesParacliniqueService {

    @Autowired
    private SignesParacliniqueRepository signesParacliniqueRepository;
    @Autowired
    private FicheRepository ficheRepository;

    public SignesParacliniqueDTO saveSignesParaclinique(SignesParacliniqueDTO signesParacliniqueDTO,Long ficheId) {
        Optional<Fiche> ficheOptional = ficheRepository.findById(ficheId);
        if (ficheOptional.isPresent()) {
            Fiche fiche = ficheOptional.get();
            SignesParaclinique signesParaclinique = SignesParacliniqueDTO.convertToEntity(signesParacliniqueDTO);
            signesParaclinique.setFiche(fiche);
            return SignesParacliniqueDTO.convertToDTO(signesParacliniqueRepository.save(signesParaclinique));
        }
        else {
            throw new IllegalArgumentException("Fiche non trouvée avec l'ID : " + ficheId);
        }

    }

    public List<SignesParacliniqueDTO> getAllSignesParacliniqueDTOs() {
        List<SignesParaclinique> signesParacliniqueList = signesParacliniqueRepository.findAll();
        return signesParacliniqueList.stream()
                .map(SignesParacliniqueDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SignesParacliniqueDTO> getSignesParacliniqueDTOById(Long id) {
        return signesParacliniqueRepository.findById(id)
                .map(SignesParacliniqueDTO::convertToDTO);
    }

    public SignesParacliniqueDTO updateSignesParaclinique(Long id, SignesParacliniqueDTO signesParacliniqueDTO) {
        SignesParaclinique signesParaclinique = SignesParacliniqueDTO.convertToEntity(signesParacliniqueDTO);
        signesParaclinique.setId(id);
        return SignesParacliniqueDTO.convertToDTO(signesParacliniqueRepository.save(signesParaclinique));
    }

    public void deleteSignesParaclinique(Long id) {
        signesParacliniqueRepository.deleteById(id);
    }
}
