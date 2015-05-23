package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.getRegistro;
import static Application.Apl_Default.openSession;

import Controller.Servlet_Cliente;
import Controller.Servlet_Item;
import Controller.Servlet_Titulo;
import Model.Cliente;
import Model.Item;
import Model.Locacao;
import Model.Titulo;
import Util.FormBuild;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_Locacao extends Apl_Default {
    
    
    /**
    * Class main name base
    */
    private static String classMainName = "Locacao";

    
    /**
    * Constructor
    */
    public Apl_Locacao() {
        this.setMainName(classMainName);
    }
    
    
    /**
    * Incluir
    */
    public static int incluir(String dataLocacao, String dataDevolucaoPrevista, double valorCobrado, Cliente cliente, Item item){
		
	Locacao l = new Locacao(dataLocacao, dataDevolucaoPrevista, valorCobrado, cliente, item);
		
	salvar(l);
		
        return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     */
    public static int update(Locacao obj) throws Exception, SQLException, HibernateException {
        
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
        Locacao obj = (Locacao) getRegistro(tabela, id);
        
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
                            "<th>Cliente</th>\n" +
                            "<th>Item / Título</th>\n" +
                            "<th>Data de locação</th>\n" +
                            "<th>Data de devolução</th>\n" +
                            "<th>Valor</th>\n" +
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Locacao o = (Locacao) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getCliente().getNome() + "</td>"+
                            "<td>" + o.getItem().getTitulo().getNome() + "</td>"+
                            "<td>" + o.getDataLocacao() + "</td>"+
                            "<td>" + o.getDataDevolucao() + "</td>"+
                            "<td>" + o.getValorCobrado() + "</td>"+
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
        
        // Registros
        List registros;
        
        // Data de locação
        form = form + buildForm.getInputText("Data de locação", "data_locacao");
        
        // Data
        form = form + buildForm.getInputText("Data de devolução", "data_devolucao");
        
        // Data
        form = form + buildForm.getInputText("Valor", "valor");  
        
        // Select Cliente
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Cliente</label>\n" +
                        "<select class='form-control' name='cliente'>";
        
        registros = Servlet_Cliente.consultarTodosRegistros();
        Iterator<Cliente> cli = registros.iterator();
                            
        while (cli.hasNext()){			
            Cliente o = (Cliente)cli.next();
            form = form + "<option value='"+o.getNumero_inscricao()+"'>"+o.getNome()+"</option>";								
        }
        
        form = form +"</select></div>";
        
        // Select Item
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Item / Título</label>\n" +
                        "<select class='form-control' name='item'>";
        
        registros = Servlet_Item.consultarTodosRegistros();
        Iterator<Item> item = registros.iterator();
                            
        while (item.hasNext()){			
            Item o = (Item)item.next();
            form = form + "<option value='"+o.getId()+"'>"+o.getTitulo().getNome()+"</option>";								
        }
        
        form = form +"</select></div>";
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Locacao main_obj = (Locacao) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Registros
        List registros;
        
        // Data de locação
        form = form + buildForm.getInputText("Data de locação", "data_locacao", main_obj.getDataLocacao());
        
        // Data
        form = form + buildForm.getInputText("Data de devolução", "data_devolucao", main_obj.getDataDevolucao());
        
        // Data
        form = form + buildForm.getInputText("Valor", "valor", Double.toString(main_obj.getValorCobrado()));  
        
        // Select Cliente
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Cliente</label>\n" +
                        "<select class='form-control' name='cliente'>";
        
        registros = Servlet_Cliente.consultarTodosRegistros();
        Iterator<Cliente> cli = registros.iterator();
                            
        while (cli.hasNext()){			
            Cliente o = (Cliente)cli.next();
            
            if(main_obj.getCliente().getNumero_inscricao() == o.getNumero_inscricao()) {
                form = form + "<option value='"+o.getNumero_inscricao()+"' selected>"+o.getNome()+"</option>";
            } else {
                form = form + "<option value='"+o.getNumero_inscricao()+"'>"+o.getNome()+"</option>";
            }
            								
        }
        
        form = form +"</select></div>";
        
        // Select Item
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Item / Titulo</label>\n" +
                        "<select class='form-control' name='item'>";
        
        registros = Servlet_Item.consultarTodosRegistros();
        Iterator<Item> item = registros.iterator();
                            
        while (item.hasNext()){			
            Item o = (Item)item.next();
            
            if(main_obj.getItem().getId() == o.getId()) {
                form = form + "<option value='"+o.getId()+"' selected>"+o.getTitulo().getNome()+"</option>";
            } else {
                form = form + "<option value='"+o.getId()+"'>"+o.getTitulo().getNome()+"</option>";
            }
            								
        }
        
        form = form +"</select></div>";
            
        return form;
        
    }
   
}
