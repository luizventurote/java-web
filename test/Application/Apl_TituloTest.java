package Application;

import Model.Ator;
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
        
        Titulo obj_titulo = (Titulo) Apl_Default.getRegistro("Titulo", 3);
        
        List reg = Apl_Default.consultarTodosRegistros("Titulo");
        
        Iterator<Titulo> models = reg.iterator();
        
        HashMap<String, String> mapa =  new HashMap();
        
        
        System.out.println("------------------");
        
        Iterator<Ator> at = obj_titulo.getAtores().iterator();
             
        
//        while (models.hasNext()){;
//								
//            Titulo o = (Titulo)models.next();
//            
//            o.getAtores().iterator();
//            
//            Iterator<Ator> at = o.getAtores().iterator();
//                            
//            while (at.hasNext()){			
//                Ator obj = (Ator)at.next();
//                System.out.println(obj.getId() + " - " + obj.getNome());							
//            }
//            
//            //mapa.put(Long.toString(o.getId()), o.getNome());
//									
//        }
        
        
        
         //System.out.println("\t" + mapa);
         
         //System.out.println("\t" + mapa.get("1"));
         
         System.out.println("------------------");
        
        
    }
    
}
