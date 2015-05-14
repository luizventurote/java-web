package Application;

import Model.Ator;
import Model.Categoria;
import Model.Classe;
import Model.Diretor;
import Model.Distribuidor;
import Model.Titulo;
import java.util.Set;

/**
 * @author Luiz Venturote
 */
public class Apl_Titulo extends Apl_Default {
    
    public static int incluir(String nome, String ano, String sinopse, Set<Ator> atores,
			Classe classe, Categoria categoria, Diretor diretor, Distribuidor distribuidor){
	
        if(nome.equals(""))
            return RESULT_ERRO;
		
	Titulo t = new Titulo(nome, ano, sinopse, atores, classe, categoria, diretor, distribuidor);
		
	salvar(t);
	
    	return RESULT_OK;
    }
    
}
