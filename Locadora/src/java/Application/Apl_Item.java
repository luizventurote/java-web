package Application;

import Model.Item;
import Model.TipoItem;
import Model.Titulo;

/**
 * @author Luiz Venturote
 */
public class Apl_Item extends Apl_Default {
    
    public static int incluir(long numeroSerie, String data, Titulo titulo, TipoItem tipoItem){
	
        if(numeroSerie == 0)
            return RESULT_ERRO;
		
        Item i = new Item(numeroSerie, data, titulo, tipoItem);
		
	salvar(i);
		
	return RESULT_OK;
    }
    
}
