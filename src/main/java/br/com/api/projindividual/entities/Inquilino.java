package br.com.api.projindividual.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  //mostrar que vai vir uma tabela no banco de dados
@Table (name="inquilino") //pra configurar o nome da tabela
public class Inquilino {
	

	@Id //define chave primária
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="proprietario_id")
	private Proprietario proprietario;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	public Inquilino() {
		super(); //Pq aqui tem super e no outro não se ambos não tem uma super classe?
		
	}

	public Inquilino(Integer id, String nome, Proprietario proprietario, String telefone, Endereco endereco, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.proprietario= proprietario;
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

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	

}
