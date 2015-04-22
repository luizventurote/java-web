package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Luiz
 */
@Entity
public class Distribuidor {
    
    @Id
    private int cnpj;
    private String razaoSocial;
	
    public Distribuidor() {
    	super();
    }

    public Distribuidor(int cnpj, String razaoSocial) {
    	super();
    	this.cnpj = cnpj;
    	this.razaoSocial = razaoSocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
}
