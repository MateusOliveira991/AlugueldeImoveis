package br.com.api.projindividual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projindividual.dto.EnderecoDTO;
import br.com.api.projindividual.entities.Endereco;
import br.com.api.projindividual.services.EnderecoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/endereco")
public class EnderecoController {
	
	@Autowired //fornece as instâncias de objetos necessárias,
	EnderecoService enderecoService;
	
	@ApiOperation("Seleciona um endereço a partir do id")
	@GetMapping("/visualizar-endereco/{id}")
	public Endereco visualizarProprietario(@PathVariable Integer id) {
		
		return enderecoService.visualizarEndereco(id);
	}
	
	@ApiOperation("Retorna uma lista com todos os endereços registrados")
	@GetMapping("/visualizar-enderecos")
	public List<Endereco>visualizarEnderecos(){
		
		return enderecoService.visualizarEnderecos();
	}
	
	@ApiOperation("Registra um endereço a partir de cep e complemento")
	@PostMapping ("/registrar-endereco")
	
	public Endereco registrarEndereco (@RequestBody EnderecoDTO endereco) {
		
		return enderecoService.registrarEndereco(endereco);
	}
	
	@ApiOperation("Atualiza um endereço selecionado por id")
	@PutMapping("/atualizar-endereco/{id}")
	public Endereco atualizarProprietario(@PathVariable Integer id, @RequestBody Endereco endereco) {
		return enderecoService.atualizarEndereco(id, endereco);
	}
	
	@ApiOperation("Deleta um endereço selecionado por id")
	@DeleteMapping ("/apagar-endereco/{id}")
	public void apagarProprietario(@PathVariable Integer id) {
		
		enderecoService.apagarEndereco(id);
	}
	
	

}


