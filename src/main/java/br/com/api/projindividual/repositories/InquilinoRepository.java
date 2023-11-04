package br.com.api.projindividual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projindividual.entities.Inquilino;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Integer>{

}
