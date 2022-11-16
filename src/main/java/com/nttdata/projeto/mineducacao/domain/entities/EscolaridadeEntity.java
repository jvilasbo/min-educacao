package com.nttdata.projeto.mineducacao.domain.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name="ESCOLARIDADE")
@Entity
public class EscolaridadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "INT")
    private int id;

    @Column(nullable = false, unique = true, columnDefinition = "INT")
    private int idade;

    @Column(name="ano_escolar", nullable = false, columnDefinition = "VARCHAR")
    private String anoEscolar;
}
