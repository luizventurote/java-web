package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Luiz
 */
@Entity
public class TipoItem {
	
    @Id
    @GeneratedValue
    private int id;
    private String nome;
	
    public TipoItem() {
    	super();
    }

    public TipoItem(String nome) {
    	super();
	this.nome = nome;
    }

    public int getId() {
    	return id;
    }

    public void setId(int id) {
    	this.id = id;
    }

    public String getNome() {
    	return nome;
    }

    public void setNome(String nome) {
    	this.nome = nome;
    }
	
}