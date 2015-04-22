package Application;

import Model.Categoria;

/**
 * @author Luiz Venturote
 */
public class Apl_Categoria extends Apl_Default {
    
    public static int incluir(String nome){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Categoria c = new Categoria(nome);
		
	salvar(c);
		
	return RESULT_OK;
    }
    
}
