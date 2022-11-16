package com.nttdata.projeto.mineducacao.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
@Getter
public class EscolaridadeResponseDTO {

    private int idade;
    private String anoEscolar;

    public EscolaridadeResponseDTO() {
    }

    public EscolaridadeResponseDTO(int idade, String anoEscolar) {
        this.idade = idade;
        this.anoEscolar = anoEscolar;
    }
}
