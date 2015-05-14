package Application;

import Model.Diretor;

/**
 * @author Luiz Venturote
 */
public class Apl_Diretor extends Apl_Default {
    
    public static int incluir(String nome){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Diretor d = new Diretor(nome);
		
	salvar(d);
		
	return RESULT_OK;
    }
    
}
