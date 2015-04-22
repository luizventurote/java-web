package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Luiz
 */
@Entity
public class Pagamento {
	@Id
	@GeneratedValue
	private long id;
	private String data;
	private double valor;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Locacao> locacoes = new HashSet<Locacao>();

	public Pagamento() {
		super();
	}

	public Pagamento(String data, double valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Set<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(Set<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	public void inserirLocacao(Locacao l){
		locacoes.add(l);
	}
	
}