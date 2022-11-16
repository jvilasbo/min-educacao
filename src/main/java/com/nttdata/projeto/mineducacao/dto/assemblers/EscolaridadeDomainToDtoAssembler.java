package com.nttdata.projeto.mineducacao.dto.assemblers;

import com.nttdata.projeto.mineducacao.domain.entities.EscolaridadeEntity;
import com.nttdata.projeto.mineducacao.dto.EscolaridadeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class EscolaridadeDomainToDtoAssembler {

    public EscolaridadeDomainToDtoAssembler() {
    }

    public EscolaridadeResponseDTO toDTO (EscolaridadeEntity escolaridade) {
        return new EscolaridadeResponseDTO(escolaridade.getIdade(), escolaridade.getAnoEscolar());
    }
}
