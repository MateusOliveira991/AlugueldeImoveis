package br.com.api.projindividual.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.projindividual.dto.EnderecoDTO;
import br.com.api.projindividual.entities.Endereco;
import br.com.api.projindividual.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco visualizarEndereco(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	public List<Endereco> visualizarEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco registrarEndereco(EnderecoDTO endereco) {
		Endereco viaCep=pesquisarEndereco(endereco.getCep());
		Endereco enderecoNovo=new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(endereco.getCep());
		enderecoNovo.setComplemento(endereco.getComplemento());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setUf(viaCep.getUf());
		return enderecoRepository.save(enderecoNovo);
	}

	public Endereco atualizarEndereco(Integer id, Endereco endereco) {
		Endereco registroAntigo = visualizarEndereco(id);
		if(endereco.getCep() != null) {
			registroAntigo.setCep(endereco.getCep());
		}
		if(endereco.getLogradouro() != null) {
			registroAntigo.setLogradouro(endereco.getLogradouro());
		}
		if(endereco.getComplemento() != null) {
			registroAntigo.setComplemento(endereco.getComplemento());
		}
		if(endereco.getBairro() != null) {
			registroAntigo.setBairro(endereco.getBairro());
		}
		if(endereco.getLocalidade() != null) {
			registroAntigo.setLocalidade(endereco.getLocalidade());
		}
		if(endereco.getUf() != null) {
			registroAntigo.setUf(endereco.getUf());
		}
		
		registroAntigo.setId(id);
		return enderecoRepository.save(registroAntigo);
	}

	public void apagarEndereco(Integer id) {
		Endereco enderecoDeletado = visualizarEndereco(id);
		enderecoRepository.delete(enderecoDeletado);
	}
	
	public Endereco pesquisarEndereco(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/{cep}/json/";
		Map<String, String> params = new HashMap<>();
		params.put("cep", cep);
		return restTemplate.getForObject(uri, Endereco.class, params);
	}	
	
}