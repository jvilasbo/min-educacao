package com.nttdata.projeto.mineducacao.services;

import com.nttdata.projeto.mineducacao.domain.entities.DisciplinaEntity;
import com.nttdata.projeto.mineducacao.domain.entities.EscolaridadeEntity;
import com.nttdata.projeto.mineducacao.dto.DisciplinaResponseDTO;
import com.nttdata.projeto.mineducacao.dto.EscolaridadeResponseDTO;
import com.nttdata.projeto.mineducacao.dto.assemblers.EscolaridadeDomainToDtoAssembler;
import com.nttdata.projeto.mineducacao.repositories.IEscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EscolaridadeService {

    @Autowired
    private IEscolaridadeRepository escolaridadeRepository;

    @Autowired
    private EscolaridadeDomainToDtoAssembler escolaridadeAssembler;

    public EscolaridadeResponseDTO getByIdade(int idade) {
        EscolaridadeEntity escolaridade = escolaridadeRepository.getReferenceByIdade(idade);
        EscolaridadeResponseDTO escolaridadeResponseDTO = escolaridadeAssembler.toDTO(escolaridade);
        return escolaridadeResponseDTO;
    }

    public List<EscolaridadeResponseDTO> getAllEscolaridades() {
        List<EscolaridadeEntity> listEscolaridades = escolaridadeRepository.findAll();
        List<EscolaridadeResponseDTO> listEscolaridadeResponseDTO = new ArrayList<>();
        for(EscolaridadeEntity d : listEscolaridades){
            EscolaridadeResponseDTO escolaridadeResponseDTO = escolaridadeAssembler.toDTO(d);
            listEscolaridadeResponseDTO.add(escolaridadeResponseDTO);
        }
        return listEscolaridadeResponseDTO;
    }

}
