package br.com.projeto.faculdade.repository;

import br.com.projeto.faculdade.model.PacoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PacoteRepository extends JpaRepository<PacoteEntity, Long> {

    Optional<PacoteEntity> findByCodRastreamento(String codRastreamento);
}
