package br.com.api.projindividual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projindividual.entities.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
