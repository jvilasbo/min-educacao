package com.nttdata.projeto.mineducacao.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
public class DisciplinaResponseDTO {

    private String titulo;
    private String area;

    public DisciplinaResponseDTO() {
    }

    public DisciplinaResponseDTO(String titulo, String area) {
        this.titulo = titulo;
        this.area = area;
    }
}
