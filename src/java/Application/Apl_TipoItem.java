package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.openSession;

import Model.TipoItem;
import Util.FormBuild;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_TipoItem extends Apl_Default {
    
    
    /**
    * Class main name base
    */
    private static String classMainName = "TipoItem";

    
    /**
    * Constructor
    */
    public Apl_TipoItem() {
        this.setMainName(classMainName);
    }

    
    /**
    * Incluir
    */
    public static int incluir(String nome) {
        
        if (nome.equals("")) {
            return RESULT_ERRO;
        }

        TipoItem t = new TipoItem(nome);

        salvar(t);

        return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     */
    public static int update(TipoItem obj) throws Exception, SQLException, HibernateException {
        
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
        TipoItem obj = (TipoItem) getRegistro(tabela, id);
        
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
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        TipoItem o = (TipoItem) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getNome() + "</td>"+
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
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        TipoItem o = (TipoItem) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Name
        form = form + buildForm.getInputText("Nome", "nome", o.getNome());
            
        return form;
        
    }

}
