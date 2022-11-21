package com.nttdata.projeto.mineducacao.services;

import com.nttdata.projeto.mineducacao.domain.entities.DisciplinaEntity;
import com.nttdata.projeto.mineducacao.domain.entities.EscolaridadeEntity;
import com.nttdata.projeto.mineducacao.dto.DisciplinaResponseDTO;
import com.nttdata.projeto.mineducacao.dto.EscolaridadeResponseDTO;
import com.nttdata.projeto.mineducacao.repositories.IDisciplinaRepository;
import com.nttdata.projeto.mineducacao.dto.assemblers.DisciplinaDomainToDtoAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaDomainToDtoAssembler disciplinaAssembler;

    public List<DisciplinaResponseDTO> getAllDisciplinas() {
        List<DisciplinaEntity> listDisciplinas = disciplinaRepository.findAll();

        List<DisciplinaResponseDTO> listDisciplinasResponseDTO = new ArrayList<>();
        for (DisciplinaEntity d : listDisciplinas) {
            DisciplinaResponseDTO disciplinaResponseDTO = disciplinaAssembler.toDTO(d);
            listDisciplinasResponseDTO.add(disciplinaResponseDTO);
        }
        return listDisciplinasResponseDTO;
    }

    public List<String> getAllDistinctAreas() {
        List<String> listAreas = disciplinaRepository.findAllDistinct();
        return listAreas;
    }

    public Optional<DisciplinaResponseDTO> getByTitulo(String titulo) {
        Optional<DisciplinaEntity> disciplinaOptional = disciplinaRepository.getReferenceByTitulo(titulo);
        if (disciplinaOptional.isPresent()) {
            DisciplinaResponseDTO distinctResponseDTO = disciplinaAssembler.toDTO(disciplinaOptional.get());
            return Optional.of(distinctResponseDTO);
        } else return Optional.empty();
    }
}
