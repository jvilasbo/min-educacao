package com.nttdata.projeto.mineducacao.repositories;

import com.nttdata.projeto.mineducacao.domain.entities.EscolaridadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEscolaridadeRepository  extends JpaRepository<EscolaridadeEntity, Integer> {

    EscolaridadeEntity getReferenceByIdade(int idade);

}
