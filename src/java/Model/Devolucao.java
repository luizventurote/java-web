package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Luiz Venturote
 */
@Entity
public class Devolucao {
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Titulo titulo;

    public Devolucao() {}
    
    public Devolucao(Cliente cli, Titulo tit) {
	super();
	this.cliente = cli;
	this.titulo = tit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

}
