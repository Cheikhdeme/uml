package com.javatechie.service;

import com.javatechie.dto.SignesCliniqueDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.SignesClinique;
import com.javatechie.repository.FicheRepository;
import com.javatechie.repository.SignesCliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignesCliniqueService {

    @Autowired
    private SignesCliniqueRepository signesCliniqueRepository;
    @Autowired
    private FicheRepository ficheRepository;

    public SignesCliniqueDTO saveSignesClinique(SignesCliniqueDTO signesCliniqueDTO,Long ficheId) {
        Optional<Fiche> ficheOptional = ficheRepository.findById(ficheId);
        if (ficheOptional.isPresent()) {
            Fiche fiche = ficheOptional.get();
            SignesClinique signesClinique = SignesCliniqueDTO.convertToEntity(signesCliniqueDTO);
            signesClinique.setFiche(fiche);
            return SignesCliniqueDTO.convertToDTO(signesCliniqueRepository.save(signesClinique));
        }else {
            throw new IllegalArgumentException("Fiche non trouvée avec l'ID : " + ficheId);
        }

    }

    public List<SignesCliniqueDTO> getAllSignesCliniqueDTOs() {
        List<SignesClinique> signesCliniqueList = signesCliniqueRepository.findAll();
        return signesCliniqueList.stream()
                .map(SignesCliniqueDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SignesCliniqueDTO> getSignesCliniqueDTOById(Long id) {
        return signesCliniqueRepository.findById(id)
                .map(SignesCliniqueDTO::convertToDTO);
    }

    public SignesCliniqueDTO updateSignesClinique(Long id, SignesCliniqueDTO signesCliniqueDTO) {
        SignesClinique signesClinique = SignesCliniqueDTO.convertToEntity(signesCliniqueDTO);
        signesClinique.setId(id);
        Fiche fiche=ficheRepository.findFichesBySignesClinique(signesClinique);
        signesClinique.setFiche(fiche);
        return SignesCliniqueDTO.convertToDTO(signesCliniqueRepository.save(signesClinique));
    }

    public void deleteSignesClinique(Long id) {
        signesCliniqueRepository.deleteById(id);
    }
}
