package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Luiz Venturote
 */
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int numero_inscricao;
	@Column(nullable = false)
	private String nome;
	private String data_nascimento;
	private char sexo;
	private Boolean ativo;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Locacao> locacoes;
	
	
	public Cliente() {
		super();
	}
	
	
	
	public Cliente(String nome, String data_nascimento,
			char sexo, Boolean ativo) {
		super();
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.ativo = ativo;
		this.locacoes = new HashSet<Locacao>();
	}

	public void inserirLocacao(Locacao l){
		locacoes.add(l);
	}
		
	public Set<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(Set<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public int getNumero_inscricao() {
		return numero_inscricao;
	}
	
	public void setNumero_inscricao(int numero_inscricao) {
		this.numero_inscricao = numero_inscricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	

}