package Application;

import Model.Classe;

/**
 * @author Luiz Venturote
 */
public class Apl_Classe extends Apl_Default {
    
    public static int incluir(String nome, double valor, int prazo){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
        Classe c = new Classe(nome, valor, prazo);
		
        salvar(c);
		
        return RESULT_OK;
    }
    
}
