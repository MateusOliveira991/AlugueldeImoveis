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

import br.com.api.projindividual.entities.Inquilino;
import br.com.api.projindividual.services.InquilinoService;

@RestController
@RequestMapping ("/inquilino")
public class InquilinoController {
		
		@Autowired //fornece as instâncias de objetos necessárias,
		InquilinoService inquilinoService;
		
		@GetMapping("/visualizar-inquilino/{id}")
		public Inquilino visualizarInquilino(@PathVariable Integer id) {
			
			return inquilinoService.visualizarInquilino(id);
		}
		
		@GetMapping("/visualizar-inquilinos")
		public List<Inquilino>visualizarInquilinos(){
			return inquilinoService.visualizarInquilinos();
		}

		@PostMapping ("/registrar-inquilino")//método deve ser invocado quando a URL especificada for acessada usando uma requisição HTTP do tipo POST.
		public Inquilino registrarInquilino (@RequestBody Inquilino inquilino) {
			return inquilinoService.registrarInquilino(inquilino);
}

		@PutMapping("/atualizar-inquilino/{id}")
		public Inquilino atualizarInquilino(@PathVariable Integer id, @RequestBody Inquilino inquilino) {
			return inquilinoService.atualizarInquilino(id, inquilino);
}
		@DeleteMapping ("/apagar-inquilino/{id}")
		public void apagarInquilino(@PathVariable Integer id) {
			inquilinoService.apagarInquilino(id);
}



}
