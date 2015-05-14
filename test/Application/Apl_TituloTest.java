package Application;

import Model.Titulo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Luiz
 */
public class Apl_TituloTest {
    /**
     * Test of getFormToUpdate method, of class Apl_Titulo.
     */
    @Test
    public void testGetList() {
        
        
        
        List reg = Apl_Default.consultarTodosRegistros("Titulo");
        
        Iterator<Titulo> models = reg.iterator();
        
        HashMap<String, String> mapa =  new HashMap();
        
        
        while (models.hasNext()){
								
            Titulo o = (Titulo)models.next();
            
            mapa.put(Long.toString(o.getId()), o.getNome());
									
        }
        
        System.out.println("------------------");
             
         System.out.println("\t" + mapa);
         
         System.out.println("\t" + mapa.get("1"));
         
         System.out.println("------------------");
        
        
    }
    
}
