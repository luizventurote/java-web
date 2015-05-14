package Application;

import static Application.Apl_Default.RESULT_ERRO;
import static Application.Apl_Default.RESULT_OK;
import static Application.Apl_Default.getRegistro;
import static Application.Apl_Default.openSession;
import Controller.Servlet_Ator;
import Controller.Servlet_Categoria;
import Controller.Servlet_Classe;
import Controller.Servlet_Diretor;
import Controller.Servlet_Distribuidor;
import Model.Ator;

import Model.Categoria;
import Model.Classe;
import Model.Diretor;
import Model.Distribuidor;
import Model.Titulo;
import Util.FormBuild;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Luiz Venturote
 */
public class Apl_Titulo extends Apl_Default {
    
    /**
    * Class main name base
    */
    private static String classMainName = "Titulo";

    /**
    * Constructor
    */
    public Apl_Titulo() {
        this.setMainName(classMainName);
    }
    
    /**
    * Incluir
    */
    public static int incluir(String nome, String ano, String sinopse, Set<Ator> atores,
	Classe classe, Categoria categoria, Diretor diretor, Distribuidor distribuidor){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Titulo t = new Titulo(nome, ano, sinopse, atores, classe, categoria, diretor, distribuidor);
		
	salvar(t);
	
    	return RESULT_OK;
    }
    
    /**
     * Deletar
     */
    public static int deletar(String tabela, int id) throws Exception, SQLException, HibernateException {
        
        // Get object
        Titulo obj = (Titulo) getRegistro(tabela, id);
        
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
    * Retorna um HashMap com os objetos em key = value
    */
    public static HashMap getAllObjectsInHashMap() {
        
        List reg = Apl_Default.consultarTodosRegistros(classMainName);
        
        Iterator<Titulo> models = reg.iterator();
        
        HashMap<String, String> hash =  new HashMap();
        
        
        while (models.hasNext()){
								
            Titulo o = (Titulo)models.next();
            
            hash.put(Long.toString(o.getId()), o.getNome());
									
        }
        
        return hash;
        
    }
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Titulo o = (Titulo) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getId() + "</th>" + 
                            "<td>" + o.getNome() + "</td>"+
                            "<td>"+Apl_Diretor.getFormActions(classMainName, o.getId())+"</td>"+
                        "</tr>";
        
        return form;
        
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
    * Retorna O formulário da classe
    */
    public static String getForm() {
        
        // Form
        String form;
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Registros
        List registros;
        
        // Form Nome
        form = buildForm.getInputText("Nome", "nome");
        
        // Form Ano
        form = form + buildForm.getInputText("Ano", "ano");
        
        
        // Select Categoria
        form        = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Categoria</label>\n" +
                        "<select class='form-control' name='categoria'>";
        
        registros = Servlet_Categoria.consultarTodosRegistros();
        Iterator<Categoria> cat = registros.iterator();
                            
        while (cat.hasNext()){
								
            Categoria o = (Categoria)cat.next();
                                
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";
									
        }
        
        form = form +"</select></div>";
        
        
        // Select Classe
        form        = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Classe</label>\n" +
                        "<select class='form-control' name='classe'>";
        
        registros = Servlet_Classe.consultarTodosRegistros();
        Iterator<Classe> cla = registros.iterator();
                            
        while (cla.hasNext()){
								
            Classe o = (Classe)cla.next();
                                
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";
									
        }
        
        form = form +"</select></div>";
        
        
        // Select Ator
        form        = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Atores</label>\n" +
                        "<select multiple class='form-control' name='atores'>";
        
        registros = Servlet_Ator.consultarTodosRegistros();
        Iterator<Ator> obj = registros.iterator();
                            
        while (obj.hasNext()){
								
            Ator o = (Ator)obj.next();
                                
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";
									
        }
        
        form = form +"</select></div>";
        
        
        // Select Diretor
        form        = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Diretor</label>\n" +
                        "<select class='form-control' name='diretor'>";
        
        registros = Servlet_Diretor.consultarTodosRegistros();
        Iterator<Diretor> dir = registros.iterator();
                            
        while (dir.hasNext()){
								
            Diretor o = (Diretor)dir.next();
            
            form = form + "<option value='"+o.getId()+"'>"+o.getNome()+"</option>";
									
        }
        
        form = form + "</select></div>";
        
        
        // Sinopse
        form = form + "<div class='form-group'>\n" +
                        "<label for='exampleInput'>Sinopse</label>\n" +
                        "<textarea class='form-control' rows='3' name='sinopse'></textarea>\n" +
                      "</div>";
        
        
        // Select Distribuidor
        form        = form +"<div class='form-group'>\n" +
                        "<label for='exampleInput'>Distribuidor</label>\n" +
                        "<select class='form-control' name='distribuidor'>";
        
        registros = Servlet_Distribuidor.consultarTodosRegistros();
        Iterator<Distribuidor> dis = registros.iterator();
                            
        while (dis.hasNext()){
								
            Distribuidor o = (Distribuidor)dis.next();
            form = form + "<option value='"+o.getCnpj()+"'>"+o.getRazaoSocial()+"</option>";
									
        }
        
        form = form + "</select></div>";
                       
            
        return form;
        
    }
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        Classe o = (Classe) Apl_Default.getRegistro(classMainName, id);
        
        String form = "<div class='form-group'>\n" +
                        "<label for='exampleInput'>Nome</label>\n" +
                        "<input type='text' class='form-control' name='nome' value='"+o.getNome()+"' >\n" +
                      "</div>";
            
        return form;
        
    }
    
}
