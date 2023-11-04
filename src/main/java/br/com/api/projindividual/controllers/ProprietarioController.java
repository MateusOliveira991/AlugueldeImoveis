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
import br.com.api.projindividual.entities.Proprietario;
import br.com.api.projindividual.services.ProprietarioService;

@RestController  //marcar uma classe em um aplicativo Spring como um controlador.
@RequestMapping("/proprietario") //mapear métodos de um controlador 
public class ProprietarioController {
	
	@Autowired //fornece as instâncias de objetos necessárias,
	ProprietarioService proprietarioService;
	
	@GetMapping("/visualizar-proprietario/{id}")
	public Proprietario visualizarProprietario(@PathVariable Integer id) {
		
		return proprietarioService.visualizarProprietario(id);
	}
	
	@GetMapping("/visualizar-proprietarios")
	public List<Proprietario>visualizarProprietarios(){
		
		return proprietarioService.visualizarProprietarios();
	}
	
	@PostMapping //método deve ser invocado quando a URL especificada for acessada usando uma requisição HTTP do tipo POST.
	
	public Proprietario registrarProprietario (@RequestBody Proprietario proprietario) {
		
		return proprietarioService.registrarProprietario(proprietario);
	}
	
	@PutMapping("/atualizar-proprietario/{id}")
	public Proprietario atualizarProprietario(@PathVariable Integer id, @RequestBody Proprietario proprietario) {
		
		return proprietarioService.atualizarProprietario(id, proprietario);
	}
	@DeleteMapping ("/apagar-proprietario/{id}")
	public void apagarProprietario(@PathVariable Integer id) {
		
		proprietarioService.apagarProprietario(id);
	}
	
	

}
