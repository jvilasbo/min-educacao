package com.nttdata.projeto.mineducacao.repositories;

import com.nttdata.projeto.mineducacao.domain.entities.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
}
