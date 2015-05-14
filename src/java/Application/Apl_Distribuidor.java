package Application;

import Model.Distribuidor;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_Distribuidor extends Apl_Default {
    
    public static int incluir(int cnpj, String razao){
	
        if(razao.equals(""))
            return RESULT_ERRO;
		
	Distribuidor d = new Distribuidor(cnpj, razao);
        
	salvar(d);
		
	return RESULT_OK;
    }   
    
    
    /**
     * Deletar
     *
     * @param tabela
     * @param id
     * @param obj
     * @return 
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public static int deletar(String tabela, int id) throws Exception, SQLException, HibernateException {
        
        // Get object
        Distribuidor obj = (Distribuidor) getRegistro(tabela, id);
        
        // Open Session
        Session session = openSession();;

        try {

            // Delect object
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return RESULT_ERRO;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     *
     * @param tabela
     * @param id
     * @return 
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public static int update(Distribuidor obj) throws Exception, SQLException, HibernateException {
        
        // Open Session
        Session session = openSession();

        try {

            session.beginTransaction();
            
            System.out.println(obj.getCnpj());
            System.out.println(obj.getRazaoSocial());

            session.update(obj);
            
            System.out.println("=================================== ok ==================================");

            session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return RESULT_ERRO;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return RESULT_OK;
        
    }
    
}
