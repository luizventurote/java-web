package Application;

import Model.Dependente;
import Model.Socio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Luiz Venturote
 */
public class Apl_Cliente extends Apl_Default {
    
    public static int incluirSocio(String nome, String endereco, String telefone, char sexo, String cpf, String data){
		
	if(nome.equals("") || cpf.equals(""))
            return RESULT_ERRO;
		
	Socio s =  new Socio( nome, data, sexo, true, cpf, endereco, telefone);
		
	salvar(s);
	
	return RESULT_OK;
    }
	
    public static int incluirDependente(Socio socio, String nome, char sexo, String data){
		
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Dependente d = new Dependente();
	d.setNome(nome);
	d.setSexo(sexo);
	d.setData_nascimento(data);
	d.setAtivo(true);
				
	SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessions.openSession();
	session.beginTransaction();
	session.save(d);
	socio.inserirDependente(d);
	session.update(socio);
	session.getTransaction().commit();
	session.close();
		
	return RESULT_OK;
    }
    
}
