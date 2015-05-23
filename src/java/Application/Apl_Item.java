package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.getRegistro;
import static Application.Apl_Default.openSession;
import Controller.Servlet_Categoria;
import Controller.Servlet_TipoItem;
import Controller.Servlet_Titulo;

import Model.Item;
import Model.TipoItem;
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
public class Apl_Item extends Apl_Default {
    
    
    /**
    * Class main name base
    */
    private static String classMainName = "Item";

    
    /**
    * Constructor
    */
    public Apl_Item() {
        this.setMainName(classMainName);
    }
    
    
    /**
    * Incluir
    */
    public static int incluir(long numeroSerie, String data, Titulo titulo, TipoItem tipoItem){
	
        if(numeroSerie == 0)
            return RESULT_ERRO;
		
        Item i = new Item(numeroSerie, data, titulo, tipoItem);
		
	salvar(i);
		
	return RESULT_OK;
    }
    
    
    /**
     * Atualizar
     */
    public static int update(Item obj) throws Exception, SQLException, HibernateException {
        
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
        Item obj = (Item) getRegistro(tabela, id);
        
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
                            "<th>Número de série</th>\n" +
                            "<th>Título</th>\n" +
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Item o = (Item) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getNumeroSerie() + "</td>"+
                            "<td>" + o.getTitulo().getNome() + "</td>"+
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
        
        // Número de série
        form = form + buildForm.getInputText("Número de série", "numero");
        
        // Data de aquisição
        form = form + buildForm.getInputText("Data de aquisição", "aquisicao");
        
        // Select Título
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Título</label>\n" +
                        "<select class='form-control' name='titulo'>";
        
        registros = Servlet_Titulo.consultarTodosRegistros();
        Iterator<Titulo> title = registros.iterator();
                            
        while (title.hasNext()){			
            Titulo o = (Titulo)title.next();
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";								
        }
        
        form = form +"</select></div>";
        
        // Select Tipo
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Tipo</label>\n" +
                        "<select class='form-control' name='tipo'>";
        
        registros = Servlet_TipoItem.consultarTodosRegistros();
        Iterator<TipoItem> tipo = registros.iterator();
                            
        while (tipo.hasNext()){			
            TipoItem o = (TipoItem)tipo.next();
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";								
        }
        
        form = form +"</select></div>";
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Item o = (Item) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Registros
        List registros;
        
        // Número de série
        form = form + buildForm.getInputText("Número de série", "numero", Long.toString(o.getNumeroSerie()));
        
        // Data de aquisição
        form = form + buildForm.getInputText("Data de aquisição", "aquisicao", o.getData());
            
        // Select Título
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Título</label>\n" +
                        "<select class='form-control' name='titulo'>";
        
        registros = Servlet_Titulo.consultarTodosRegistros();
        Iterator<Titulo> title = registros.iterator();
                            
        while (title.hasNext()){			
            Titulo obj = (Titulo)title.next();
            
            if(o.getTitulo().getId() == obj.getId()) {
                form = form + "<option value='"+obj.getId()+"' selected>"+obj.getNome()+"</option>";
            } else {
                form = form + "<option value='"+obj.getId()+"'>"+obj.getNome()+"</option>";
            }
           							
        }
        
        form = form +"</select></div>";
        
        // Select Tipo
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Tipo</label>\n" +
                        "<select class='form-control' name='tipo'>";
        
        registros = Servlet_TipoItem.consultarTodosRegistros();
        Iterator<TipoItem> tipo = registros.iterator();
                            
        while (tipo.hasNext()){			
            TipoItem obj = (TipoItem)tipo.next();
            
            if(o.getTipoItem().getId() == obj.getId()) {
                form = form + "<option value='"+obj.getId()+"' selected>"+obj.getNome()+"</option>";
            } else {
                form = form + "<option value='"+obj.getId()+"'>"+obj.getNome()+"</option>";
            }								
        }
        
        form = form +"</select></div>";
        
        return form;
        
    }
    
}
