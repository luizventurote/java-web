package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.getRegistro;
import static Application.Apl_Default.openSession;

import Util.FormBuild;
import Model.Classe;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_Classe extends Apl_Default {
    
    
    /**
    * Class main name base
    */
    private static String classMainName = "Classe";

    
    /**
    * Constructor
    */
    public Apl_Classe() {
        this.setMainName(classMainName);
    }
    
    
    /**
    * Incluir
    */
    public static int incluir(String nome, double valor, int prazo){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
        Classe c = new Classe(nome, valor, prazo);
		
        salvar(c);
		
        return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     */
    public static int update(Classe obj) throws Exception, SQLException, HibernateException {
        
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
        Classe obj = (Classe) getRegistro(tabela, id);
        
        // Open Session
        Session session = openSession();

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
                            "<th>id</th>\n" +
                            "<th>Nome</th>\n" +
                            "<th>Valor</th>\n" +
                            "<th>Prazo de devolução</th>\n" +
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Classe o = (Classe) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getNome() + "</td>"+
                            "<td>" + o.getValor()+ "</td>"+
                            "<td>" + o.getPrazoDevolucao()+ "</td>"+
                            "<td>"+Apl_Default.getFormActions(classMainName, o.getId())+"</td>"+
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
        
        // Name
        form = form + buildForm.getInputText("Nome", "nome");
        
        // Valor de locação
        form = form + buildForm.getInputText("Valor de locação", "valor");
        
        // Prazo de devolução
        form = form + buildForm.getInputText("Prazo de devolução (dias)", "prazo");
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Classe o = (Classe) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Name
        form = form + buildForm.getInputText("Nome", "nome", o.getNome());
        
        // Valor de locação
        form = form + buildForm.getInputText("Valor de locação", "valor", Double.toString( o.getValor() ));
        
        // Prazo de devolução
        form = form + buildForm.getInputText("Prazo de devolução (dias)", "prazo", Integer.toString( o.getPrazoDevolucao() ));
                        
        return form;
        
    }
    
}
