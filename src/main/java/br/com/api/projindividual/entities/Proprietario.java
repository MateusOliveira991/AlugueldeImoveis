package br.com.api.projindividual.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  //mostrar que vai vir uma tabela no banco de dados
@Table (name="proprietario") //pra configurar o nome da tabela
public class Proprietario {

	
	@Id //define chave primária
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	
	@OneToMany(mappedBy="proprietario")
	private List<Inquilino> inquilinos;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	public Proprietario() {
		
	}

	public Proprietario(Integer id, String nome, String telefone, String cpf, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(String cpf, Endereco endereco) {
		this.endereco = endereco;
	}

	
}
