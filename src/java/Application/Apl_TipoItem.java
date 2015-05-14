package Application;

import Model.TipoItem;

/**
 * @author Luiz Venturote
 */
public class Apl_TipoItem extends Apl_Default {

    public static int incluir(String nome) {
        
        if (nome.equals("")) {
            return RESULT_ERRO;
        }

        TipoItem t = new TipoItem(nome);

        salvar(t);

        return RESULT_OK;
    }

}
