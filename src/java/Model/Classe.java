package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Luiz
 */
@Entity
public class Classe {
    
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private double valor;
    private int prazoDevolucao;
	
    public Classe() {
    	super();
    }

    public Classe(String nome, double valor, int prazoDevolucao) {
    	super();
    	this.nome = nome;
    	this.valor = valor;
    	this.prazoDevolucao = prazoDevolucao;
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

    public double getValor() {
	return valor;
    }

    public void setValor(double valor) {
	this.valor = valor;
    }

    public int getPrazoDevolucao() {
    	return prazoDevolucao;
    }

    public void setPrazoDevolucao(int prazoDevolucao) {
    	this.prazoDevolucao = prazoDevolucao;
    }
    
}
