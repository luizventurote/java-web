package Util;

import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 *
 * @author Luiz Venturote
 */
public class HibernateUtilTest {

    /**
     * Test of getSessionFactory method, of class HibernateUtil.
     */
    @Test
    public void testGetSessionFactory() {
        
        System.out.println("-> Test: getSessionFactory\n");
        
        SessionFactory expResult = null;
        
        SessionFactory result = HibernateUtil.getSessionFactory();
        
        System.out.println("Result: Hibernate connection started ");
        
        System.out.println("\n------------------------------------------------------------------- \n");
        
    }
    
}
