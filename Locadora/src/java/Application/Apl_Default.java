package Application;

import Model.Ator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Luiz
 */
public class Apl_Default {

    public static final int RESULT_OK = 1;
    public static final int RESULT_ERRO = 0;

    public static Session openSession() {

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        return session;

    }

    public static void salvar(Object o) {

        Session s = openSession();

        s.beginTransaction();
        s.save(o);
        s.getTransaction().commit();
        s.close();

    }

    /**
     * Recupera todos os registros do banco de dados relacionados a tabela do
     * servlet.
     *
     * @param tabela
     * @return
     */
    public static List consultarTodosRegistros(String tabela) {

        Session s = openSession();

        String strQuery = "from " + tabela;

        s.beginTransaction();
        Query qr = s.createQuery(strQuery);

        return qr.list();

    }
    
    
    /**
     * Recupera um registro através do ID
     * servlet.
     *
     * @param tabela
     * @return
     */
    public static Object getRegistro(String tabela, int id) {

        Session s = openSession();

        String strQuery = "FROM "+tabela+" WHERE id =" + id;

        s.beginTransaction();
        
        Query qr = s.createQuery(strQuery);
        
        Object obj = qr.uniqueResult();
        
        s.close();

        return obj;

    }
    

    /**
     * Recupera registros
     *
     * @param tabela
     * @return
     */
    public static Set getRegistros(String tabela, String itens[]) {

        Session s;
        
        Set<Object> registros = new HashSet<Object>();

        for (String str : itens) {

            s = openSession();

            int id = Integer.parseInt(str.toString());

            String strQuery = "FROM " + tabela + " WHERE id = " + id;

            s.beginTransaction();

            Query qr = s.createQuery(strQuery);

            Ator a = (Ator) qr.uniqueResult();

            System.out.println("=============" + a.getNome());

            registros.add(a);
            s.close();
        }

        return registros;

    }

}
