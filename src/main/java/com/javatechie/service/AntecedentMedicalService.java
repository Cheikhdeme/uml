package com.javatechie.service;

import com.javatechie.dto.AntecedentMedicalDTO;
import com.javatechie.entity.AntecedentMedical;
import com.javatechie.entity.AntecedentsPersonnel;
import com.javatechie.repository.AntecedentMedicalRepository;
import com.javatechie.repository.AntecedentsPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AntecedentMedicalService {

    @Autowired
    private AntecedentMedicalRepository antecedentMedicalRepository;
    @Autowired
    private AntecedentsPersonnelRepository antecedentsPersonnelRepository;

    public AntecedentMedicalDTO saveAntecedentMedical(AntecedentMedicalDTO antecedentMedicalDTO,Long id) {
        Optional<AntecedentsPersonnel> antecedentsPersonnelOptional= antecedentsPersonnelRepository.findById(id);
        if (antecedentsPersonnelOptional.isPresent()){
            AntecedentsPersonnel antecedentsPersonnel=antecedentsPersonnelOptional.get();
            AntecedentMedical antecedentMedical = AntecedentMedicalDTO.convertToEntity(antecedentMedicalDTO);
            antecedentMedical.setAntecedentsPersonnel(antecedentsPersonnel);
            return AntecedentMedicalDTO.convertToDTO(antecedentMedicalRepository.save(antecedentMedical));
        }
        else {
            throw  new IllegalArgumentException("antécédents personnels non trouvé avec id  "+id);
        }

    }

    public List<AntecedentMedicalDTO> getAllAntecedentMedicalDTOs() {
        List<AntecedentMedical> antecedentMedicalList = antecedentMedicalRepository.findAll();
        return antecedentMedicalList.stream()
                .map(AntecedentMedicalDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AntecedentMedicalDTO> getAntecedentMedicalDTOById(Long id) {
        return antecedentMedicalRepository.findById(id)
                .map(AntecedentMedicalDTO::convertToDTO);
    }

    public AntecedentMedicalDTO updateAntecedentMedical(Long id, AntecedentMedicalDTO antecedentMedicalDTO) {
        AntecedentMedical antecedentMedical = AntecedentMedicalDTO.convertToEntity(antecedentMedicalDTO);
        antecedentMedical.setId(id);
        antecedentMedical.setAntecedentsPersonnel(antecedentsPersonnelRepository.findAntecedentsPersonnelByAntecedentMedical(antecedentMedical));
        return AntecedentMedicalDTO.convertToDTO(antecedentMedicalRepository.save(antecedentMedical));
    }

    public void deleteAntecedentMedical(Long id) {
        antecedentMedicalRepository.deleteById(id);
    }
}
