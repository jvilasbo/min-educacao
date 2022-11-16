package com.nttdata.projeto.mineducacao.dto.assemblers;

import com.nttdata.projeto.mineducacao.domain.entities.DisciplinaEntity;
import com.nttdata.projeto.mineducacao.dto.DisciplinaResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaDomainToDtoAssembler {

    public DisciplinaDomainToDtoAssembler() {
    }

    public DisciplinaResponseDTO toDTO (DisciplinaEntity disciplina) {
        return new DisciplinaResponseDTO(disciplina.getTitulo(), disciplina.getArea());
    }
}
