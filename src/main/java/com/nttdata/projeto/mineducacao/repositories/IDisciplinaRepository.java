package com.nttdata.projeto.mineducacao.repositories;

import com.nttdata.projeto.mineducacao.domain.entities.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {

    @Query("select distinct d.area from DISCIPLINA d")
    List<String> findAllDistinct();

    Optional<DisciplinaEntity> getReferenceByTitulo(String titulo);
}
