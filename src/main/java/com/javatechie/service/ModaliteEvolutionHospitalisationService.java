package com.javatechie.service;

import com.javatechie.dto.ModaliteEvolutionHospitalisationDTO;
import com.javatechie.entity.ModaliteEvolutionHospitalisation;
import com.javatechie.entity.TraitementMedical;
import com.javatechie.repository.ModaliteEvolutionHospitalisationRepository;
import com.javatechie.repository.TraitementMedicalRepository;
import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModaliteEvolutionHospitalisationService {

    @Autowired
    private ModaliteEvolutionHospitalisationRepository modaliteEvolutionHospitalisationRepository;
    @Autowired
    private TraitementMedicalRepository traitementMedicalRepository;

    public ModaliteEvolutionHospitalisationDTO saveModaliteEvolutionHospitalisation(ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO,Long id) {
        Optional<TraitementMedical> traitementMedicalOptional=traitementMedicalRepository.findById(id);
        if(traitementMedicalOptional.isPresent()){
            TraitementMedical traitementMedical=traitementMedicalOptional.get();
            ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation = ModaliteEvolutionHospitalisationDTO.convertToEntity(modaliteEvolutionHospitalisationDTO);
            modaliteEvolutionHospitalisation.setTraitementMedical(traitementMedical);
            return ModaliteEvolutionHospitalisationDTO.convertToDTO(modaliteEvolutionHospitalisationRepository.save(modaliteEvolutionHospitalisation));
        }
        else{
            throw new IllegalArgumentException("Traitement médicale non trouvée avec l'ID : " + id);
        }

    }

    public List<ModaliteEvolutionHospitalisationDTO> getAllModaliteEvolutionHospitalisationDTOs() {
        List<ModaliteEvolutionHospitalisation> modaliteEvolutionHospitalisationList = modaliteEvolutionHospitalisationRepository.findAll();
        return modaliteEvolutionHospitalisationList.stream()
                .map(ModaliteEvolutionHospitalisationDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ModaliteEvolutionHospitalisationDTO> getModaliteEvolutionHospitalisationDTOById(Long id) {
        return modaliteEvolutionHospitalisationRepository.findById(id)
                .map(ModaliteEvolutionHospitalisationDTO::convertToDTO);
    }

    public ModaliteEvolutionHospitalisationDTO updateModaliteEvolutionHospitalisation(Long id, ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO) {
        ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation = ModaliteEvolutionHospitalisationDTO.convertToEntity(modaliteEvolutionHospitalisationDTO);
        modaliteEvolutionHospitalisation.setId(id);
        TraitementMedical traitementMedical=traitementMedicalRepository.findTraitementMedicalByModaliteEvolutionHospitalisation(modaliteEvolutionHospitalisation);
        modaliteEvolutionHospitalisation.setTraitementMedical(traitementMedical);
        return ModaliteEvolutionHospitalisationDTO.convertToDTO(modaliteEvolutionHospitalisationRepository.save(modaliteEvolutionHospitalisation));
    }

    public void deleteModaliteEvolutionHospitalisation(Long id) {
        modaliteEvolutionHospitalisationRepository.deleteById(id);
    }
}
