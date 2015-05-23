package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.getRegistro;
import static Application.Apl_Default.openSession;
import static Application.Apl_Default.salvar;

import Controller.Servlet_Cliente;
import Controller.Servlet_Titulo;
import Model.Cliente;
import Model.Reserva;
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
public class Apl_Reserva extends Apl_Default {

    /**
    * Class main name base
    */
    private static String classMainName = "Reserva";

    
    /**
    * Constructor
    */
    public Apl_Reserva() {
        this.setMainName(classMainName);
    }
    
    
    /**
    * Incluir
    */
    public static int incluir(Cliente cli, Titulo tit){
		
        Reserva a =  new Reserva(cli, tit);
	
        salvar(a);
                
        return RESULT_OK;
    }
    
    
    
    /**
     * Atualizar
     */
    public static int update(Reserva obj) throws Exception, SQLException, HibernateException {
        
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
        Reserva obj = (Reserva) getRegistro(tabela, id);
        
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
                            "<th>Título</th>\n" +
                            "<th>Ações</th>"+
                        "</tr>";
        
        return form;
        
    }
    
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Reserva o = (Reserva) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getCliente().getNome() + "</td>"+
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
            
        return form;
        
    }
    
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Reserva main_obj = (Reserva) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Registros
        List registros;
        
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
        
        // Select Titulo
        form = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Titulo</label>\n" +
                        "<select class='form-control' name='titulo'>";
        
        registros = Servlet_Titulo.consultarTodosRegistros();
        Iterator<Titulo> tit = registros.iterator();
                            
        while (tit.hasNext()){			
            Titulo o = (Titulo)tit.next();
            
            if(main_obj.getTitulo().getId() == o.getId()) {
                form = form + "<option value='"+o.getId()+"' selected>"+o.getNome()+"</option>";
            } else {
                form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";
            }
            								
        }
        
        form = form +"</select></div>";
            
        return form;
        
    }
}
