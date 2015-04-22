package Application;

import Model.Ator;

/**
 * @author Luiz Venturote
 */
public class Apl_Ator extends Apl_Default {
    
    public static int incluir(String nome){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
        Ator a =  new Ator(nome);
	
        salvar(a);
                
        return RESULT_OK;
    }
    
}
