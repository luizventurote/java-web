package Application;

import Util.FormBuild;
import Model.Distribuidor;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_Distribuidor extends Apl_Default {
    
    
    /**
    * Class main name base
    */
    private static String classMainName = "Distribuidor";

    
    /**
    * Constructor
    */
    public Apl_Distribuidor() {
        this.setMainName(classMainName);
    }
    
    
    /**
    * Incluir
    */
    public static int incluir(int cnpj, String razao){
	
        if(razao.equals(""))
            return RESULT_ERRO;
		
	Distribuidor d = new Distribuidor(cnpj, razao);
        
	salvar(d);
		
	return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     */
    public static int update(Distribuidor obj) throws Exception, SQLException, HibernateException {
        
        // Open Session
        Session session = openSession();

        try {

            session.beginTransaction();
            session.update(obj);
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
     * Deletar
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
    * Retorna a linha de exibição do list
    */
    public static String getFormListHeader() {
        
        String form =   "<tr>"+
                            "<th>CNPJ</th>\n" +
                            "<th>Razão social</th>\n" +
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Distribuidor o = (Distribuidor) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getCnpj() + "</th>" + 
                            "<td>" + o.getRazaoSocial() + "</td>"+
                            "<td>"+Apl_Default.getFormActions(classMainName, o.getCnpj())+"</td>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna O formulário da classe
    */
    public static String getForm() {
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Valor de locação
        form = form + buildForm.getInputText("CNPJ", "cnpj");
        
        // Name
        form = form + buildForm.getInputText("Razão social", "razao");
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Distribuidor o = (Distribuidor) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Name
        form = form + buildForm.getInputText("CNPJ", "cnpj", Long.toString(o.getCnpj()));
        
        // Valor de locação
        form = form + buildForm.getInputText("Razão social", "razao", o.getRazaoSocial());
                        
        return form;
        
    }
    
   
    
    
    
    
}
