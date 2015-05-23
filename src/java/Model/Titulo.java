package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luiz
 */
@Entity
public class Titulo {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String nome;
    private String ano;
    private String sinopse;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ator> atores = new HashSet<Ator>();
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Diretor diretor;
    @ManyToOne
    private Distribuidor distribuidor;
	
    public Titulo(){}
	
    public Titulo(String nome, String ano, String sinopse, Set<Ator> atores, 
            Classe classe, Categoria categoria, Diretor diretor, Distribuidor 
            distribuidor) {
        
	super();
	this.nome = nome;
	this.ano = ano;
	this.sinopse = sinopse;
	this.atores = atores;
	this.classe = classe;
	this.categoria = categoria;
	this.diretor = diretor;
    	this.distribuidor = distribuidor;
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

    public String getAno() {
    	return ano;
    }

    public void setAno(String ano) {
    	this.ano = ano;
    }

    public String getSinopse() {
    	return sinopse;
    }

    public void setSinopse(String sinopse) {
    	this.sinopse = sinopse;
    }

    public Set<Ator> getAtores() {
    	return atores;
    }

    public void setAtores(Set<Ator> atores) {
    	this.atores = atores;
    }

    public Classe getClasse() {
	return classe;
    }

    public void setClasse(Classe classe) {
	this.classe = classe;
    }
	
    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public Diretor getDiretor() {
	return diretor;
    }

    public void setDiretor(Diretor diretor) {
    	this.diretor = diretor;
    }

    public Distribuidor getDistribuidor() {
    	return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
    	this.distribuidor = distribuidor;
    }

}
