package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luiz
 */
@Entity
public class Locacao {
	
	@Id
	@GeneratedValue
	private long id;
	private String dataLocacao;
	private String dataDevolucaoPrevista;
	private String dataDevolucao;
	private double valorCobrado;
	private double multaCobrada;
	
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Item item;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>();

	
	public Locacao() {
		super();
	}

	public Locacao(String dataLocacao, String dataDevolucaoPrevista, double valorCobrado,
			Cliente cliente, Item item) {
		super();
		this.dataLocacao = dataLocacao;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.valorCobrado = valorCobrado;
		this.cliente = cliente;
		this.item = item;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDataLocacao() {
		return dataLocacao;
	}
	
	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	
	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public double getValorCobrado() {
		return valorCobrado;
	}
	
	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	public double getMultaCobrada() {
		return multaCobrada;
	}
	
	public void setMultaCobrada(double multaCobrada) {
		this.multaCobrada = multaCobrada;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

	public Set<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public void inserirPagamento(Pagamento p){
		pagamentos.add(p);
	}
	
}
