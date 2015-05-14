package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Luiz
 */
@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	private long numeroSerie;
	private String data;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Titulo titulo;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TipoItem tipoItem;
	
	public Item() {
		super();
	}

	public Item(long numeroSerie, String data, Titulo titulo, TipoItem tipoItem) {
		super();
		this.numeroSerie = numeroSerie;
		this.data = data;
		this.titulo = titulo;
		this.tipoItem = tipoItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}
	
}