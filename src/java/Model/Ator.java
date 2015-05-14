package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Luiz Venturote
 */
@Entity
public class Ator {
    
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String nome;
    
    public Ator(){}
    
    public Ator(String nome) {
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
