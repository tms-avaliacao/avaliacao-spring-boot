package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Entidade que representa um estudante 
 * @author Danilo Portela
 */
@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	@NotNull(message = "O nome é obrigatório.")
	private String nome;
	
	@Column(nullable = false)
	@NotNull(message = "O email é obrigatório.")
	private String email;
	
	@Column(nullable = false)
	@NotNull(message = "A matrícula é obrigatória.")
	private String matricula;
	
	private String curso;
	
	private String telefone;

	
	
	@Id
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}
