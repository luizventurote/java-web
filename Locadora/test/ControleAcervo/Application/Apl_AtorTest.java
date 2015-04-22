package ControleAcervo.Application;

import Application.Apl_Ator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz
 */
public class Apl_AtorTest {

    /**
     * Test of inscreverNovoAtor method, of class Apl_Ator.
     */
    @Test
    public void testInscreverNovoAtor() {
        
        System.out.println("inscreverNovoAtor");
        String nome = "Luiz Venturote";
        int expResult = 1;
        int result = Apl_Ator.incluir(nome);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }
    
}
