package Application;

import Model.Cliente;
import Model.Item;
import Model.Locacao;

/**
 * @author Luiz Venturote
 */
public class Apl_Locacao extends Apl_Default {
    
    public static int incluir(String dataLocacao, String dataDevolucaoPrevista, double valorCobrado, Cliente cliente, Item item){
		
	Locacao l = new Locacao(dataLocacao, dataDevolucaoPrevista, valorCobrado, cliente, item);
		
	salvar(l);
		
        return RESULT_OK;
    }
   
}
