package br.com.api.projindividual.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.projindividual.entities.Proprietario;
import br.com.api.projindividual.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	@Autowired
	ProprietarioRepository proprietarioRepository;

	public Proprietario visualizarProprietario(Integer id) {
		return proprietarioRepository.findById(id).get();
	}
	
	public List<Proprietario> visualizarProprietarios(){
		return proprietarioRepository.findAll();
	}
	
	public Proprietario registrarProprietario(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
}

	public Proprietario atualizarProprietario (Integer id, Proprietario proprietario) {
		Proprietario registroAntigo=visualizarProprietario(id);
		if(proprietario.getNome()!=null) {
			registroAntigo.setNome(proprietario.getNome());
		}
		
		if(proprietario.getTelefone() != null) {
			registroAntigo.setTelefone(proprietario.getTelefone());
		}
		
		if(proprietario.getCpf() != null) {
			registroAntigo.setCpf(proprietario.getCpf());
		}
		if(proprietario.getEndereco()!=null){
			registroAntigo.setEndereco(null, proprietario.getEndereco());	
			}
		
		registroAntigo.setId(id);
		return proprietarioRepository.save(registroAntigo);
	}

	public void apagarProprietario(Integer id) {
		Proprietario proprietarioDeletado = visualizarProprietario(id);
		proprietarioRepository.delete(proprietarioDeletado);
	}
	
}
		
		
	
