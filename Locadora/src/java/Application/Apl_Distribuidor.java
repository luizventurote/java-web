package Application;

import Model.Distribuidor;

/**
 * @author Luiz Venturote
 */
public class Apl_Distribuidor extends Apl_Default {
    
    public static int incluir(int cnpj, String razao){
	
        if(razao.equals(""))
            return RESULT_ERRO;
		
	Distribuidor d = new Distribuidor(cnpj, razao);
        
	salvar(d);
		
	return RESULT_OK;
    }
    
}
