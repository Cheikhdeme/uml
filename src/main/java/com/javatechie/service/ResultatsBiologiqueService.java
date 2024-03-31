package com.javatechie.service;

import com.javatechie.dto.ResultatsBiologiqueDTO;
import com.javatechie.entity.ResultatsBiologique;
import com.javatechie.entity.SignesParaclinique;
import com.javatechie.repository.ResultatsBiologiqueRepository;
import com.javatechie.repository.SignesParacliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultatsBiologiqueService {

    @Autowired
    private ResultatsBiologiqueRepository resultatsBiologiqueRepository;
    @Autowired
    private SignesParacliniqueRepository signesParacliniqueRepository;

    public ResultatsBiologiqueDTO saveResultatsBiologique(ResultatsBiologiqueDTO resultatsBiologiqueDTO,Long id) {
        Optional<SignesParaclinique> signesParacliniqueOptional=signesParacliniqueRepository.findById(id);
        if (signesParacliniqueOptional.isPresent()){
            SignesParaclinique signesParaclinique=signesParacliniqueOptional.get();
            ResultatsBiologique resultatsBiologique = ResultatsBiologiqueDTO.convertToEntity(resultatsBiologiqueDTO);
            resultatsBiologique.setSignesParaclinique(signesParaclinique);
            return ResultatsBiologiqueDTO.convertToDTO(resultatsBiologiqueRepository.save(resultatsBiologique));
        }
        else {
            throw  new IllegalArgumentException("signe paraclinique non trouvé par "+id);
        }

    }

    public List<ResultatsBiologiqueDTO> getAllResultatsBiologiqueDTOs() {
        List<ResultatsBiologique> resultatsBiologiqueList = resultatsBiologiqueRepository.findAll();
        return resultatsBiologiqueList.stream()
                .map(ResultatsBiologiqueDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ResultatsBiologiqueDTO> getResultatsBiologiqueDTOById(Long id) {
        return resultatsBiologiqueRepository.findById(id)
                .map(ResultatsBiologiqueDTO::convertToDTO);
    }

    public ResultatsBiologiqueDTO updateResultatsBiologique(Long id, ResultatsBiologiqueDTO resultatsBiologiqueDTO) {
        ResultatsBiologique resultatsBiologique = ResultatsBiologiqueDTO.convertToEntity(resultatsBiologiqueDTO);
        resultatsBiologique.setId(id);
        SignesParaclinique signesParaclinique=signesParacliniqueRepository.findSignesParacliniqueByResultatsBiologique(resultatsBiologique);
        resultatsBiologique.setSignesParaclinique(signesParaclinique);
        return ResultatsBiologiqueDTO.convertToDTO(resultatsBiologiqueRepository.save(resultatsBiologique));
    }

    public void deleteResultatsBiologique(Long id) {
        resultatsBiologiqueRepository.deleteById(id);
    }
}
