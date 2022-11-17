package com.nttdata.projeto.mineducacao.domain.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name="DISCIPLINA")
@Entity(name="DISCIPLINA")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "INT")
    private int id;

    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String titulo;

    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String area;

    public DisciplinaEntity(String titulo, String area) {
        this.titulo = titulo;
        this.area = area;
    }
}
