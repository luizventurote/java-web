package Application;

import Model.Categoria;

/**
 * @author Luiz Venturote
 */
public class Apl_Categoria extends Apl_Default {
    
    /**
    * Incluir um objeto no banco de dados
    */
    public static int incluir(String nome){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Categoria c = new Categoria(nome);
		
	salvar(c);
		
	return RESULT_OK;
    }
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormListHeader() {
        
        String form = "<th>id</th>\n" +
                      "<th>Nome</th>\n" +
                      "<th>Ações</th>";
        
        return form;
        
    }
    
    /**
    * Retorna a linha de exibição do list
    */
    public static String getFormList(Object obj) {
        
        Categoria o = (Categoria) obj;
        
        String form = "<th scope='row'>" + o.getId() + "</th>" + "<td>" + o.getNome() + "</td>";
        
        return form;
        
    }
    
}
