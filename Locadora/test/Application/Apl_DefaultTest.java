package Application;

import Model.Classe;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz
 */
public class Apl_DefaultTest {

    /**
     * Test of getRegistro method, of class Apl_Default.
     */
    @Test
    public void testGetRegistro() {
        
        System.out.println("getRegistro");
        String tabela = "Classe";
        int id = 1;
        
        Classe cla = (Classe) Apl_Default.getRegistro(tabela, id);
        
        System.out.println(cla.getNome());
        
    }
    
}
