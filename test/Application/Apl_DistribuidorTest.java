package Application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Luiz
 */
public class Apl_DistribuidorTest {

    /**
     * Test of incluirNovoDistribuidor method, of class Apl_Distribuidor.
     */
    @Test
    public void testIncluirNovoDistribuidor() {
        
        System.out.println("incluirNovoDistribuidor");
        
        int cnpj = 159;
        String razao = "PW";
        
        int expResult = 1;
        
        int result = Apl_Distribuidor.incluir(cnpj, razao);
        assertEquals(expResult, result);
    }
    
}
