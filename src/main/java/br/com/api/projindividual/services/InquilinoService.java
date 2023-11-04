package br.com.api.projindividual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.projindividual.entities.Inquilino;
import br.com.api.projindividual.repositories.InquilinoRepository;

@Service
public class InquilinoService {
	
	@Autowired
	InquilinoRepository inquilinoRepository;
	
	private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
	
	public Inquilino visualizarInquilino(Integer id) {
		return inquilinoRepository.findById(id).get();
	}
	
	public List<Inquilino>visualizarInquilinos(){
		return inquilinoRepository.findAll();
	}
	public Inquilino registrarInquilino(Inquilino inquilino) {
		
		emailService.envioEmailCadastro(inquilino);
		return inquilinoRepository.save(inquilino);
	}
	
	public Inquilino atualizarInquilino (Integer id, Inquilino inquilino) {
		Inquilino registroAntigo=visualizarInquilino(id);
		if(inquilino.getNome()!=null) {
			registroAntigo.setNome(inquilino.getNome());
		}
		
		if(inquilino.getTelefone()!=null){
			registroAntigo.setTelefone(inquilino.getTelefone());	
		}
		
		if(inquilino.getCpf() != null) {
			registroAntigo.setCpf(inquilino.getCpf());
		}
		
		if(inquilino.getEndereco()!=null){
			registroAntigo.setEndereco(inquilino.getEndereco());	
			}
			
		
		registroAntigo.setId(id);
		return inquilinoRepository.save(registroAntigo);
		
	}
		
		public void apagarInquilino(Integer id) {
			Inquilino inquilinoDeletado = visualizarInquilino(id);
			inquilinoRepository.delete(inquilinoDeletado);
		}
	}


