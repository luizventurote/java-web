package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Luiz
 */
@Entity
public class Socio extends Cliente {
	
	@Column(nullable = false, columnDefinition = "varchar(255) default '0'")
	private String cpf;
	private String endereco;
	private String telefone;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Dependente> dependentes = new HashSet<Dependente>();

	public Socio() {
		super();
	}
	
	public Socio(String nome, String data_nascimento,
			char sexo, Boolean ativo, String cpf, String endereco, String telefone) {
		super(nome, data_nascimento, sexo, ativo);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Set<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	public void inserirDependente(Dependente d){
		dependentes.add(d);
	}
	
}