package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Luiz
 */
@Entity
public class Diretor {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
	
	
    public Diretor(){}
	
    public Diretor(String nome) {
    	super();
	this.nome = nome;
    }

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

}
