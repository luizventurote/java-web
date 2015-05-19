package Application;

import Model.Cliente;
import Model.Dependente;
import Model.Socio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import Util.FormBuild;

/**
 * @author Luiz Venturote
 */
public class Apl_Cliente extends Apl_Default {
    
    /**
    * Class main name base
    */
    private static String classMainName = "Cliente";
    
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
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Cliente o = (Cliente) obj;
        
        String form =   "<tr>"+
                            "<th scope='row'>" + o.getNumero_inscricao() + "</th>" + 
                            "<td>" + o.getNome() + "</td>"+
                            "<td>"+Apl_Default.getFormActions(classMainName, o.getNumero_inscricao())+"</td>"+
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
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Nome
        form = form + buildForm.getInputText("Nome", "nome");
        
        // Data de nascimento
        form = form + buildForm.getInputText("Data de nascimento", "data_nascimento");
        
        // Endereço
        form = form + buildForm.getInputText("Endereço", "endereco");
        
        // Telefone
        form = form + buildForm.getInputText("Telefone", "telefone");
        
        // CPF
        form = form + buildForm.getInputText("CPF", "cpf");
        
        // Sexo
        form = form +   "<div class='form-group'>\n" +
                            "<label for='exampleInput'>Sexo</label>\n" +
                            "<select class='form-control' name='sexo'>\n" +
                                "<option value='F'>Feminino</option>\n" +
                                "<option value='M'>Masculino</option>\n" +
                            "</select>\n" +
                        "</div>";
        
        // Estado
        form = form +   "<div class='form-group'>\n" +
                            "<label for='exampleInput'>Estado</label>\n" +
                            "<select class='form-control' name='estado'>\n" +
                                "<option value='ativado'>Ativado</option>\n" +
                                "<option value='desativado'>Desativado</option>\n" +
                            "</select>\n" +
                        "</div>";
        
        // Tipo de cadastro
        form = form + "<input type='hidden' name='tipo' value='socio'>";
               
        return form;
        
    }
    
    /**
    * Retorna O formulário de atualização da classe com os dados do objeto
    */
    public static String getFormToUpdate(int id) {
        
        // Main Object
        Cliente o = (Cliente) Apl_Default.getRegistro(classMainName, id);
        
        // Form
        String form = "";
        
        // Form builder
        FormBuild buildForm = new FormBuild();
        
        // Nome
        form = form + buildForm.getInputText("Nome", "nome", o.getNome());
        
        // Data de nascimento
        form = form + buildForm.getInputText("Data de nascimento", "data_nascimento", o.getData_nascimento());
        
        // Tipo de cadastro
        form = form + "<input type='hidden' name='tipo' value='socio'>";
                            
        return form;
        
    }
    
}
