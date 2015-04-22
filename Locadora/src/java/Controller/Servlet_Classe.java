package Controller;

import Application.Apl_Default;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz
 */
@WebServlet(name = "Servlet_Classe", urlPatterns = {"/Classe"})
public class Servlet_Classe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        if(acao != null ) {
            
            if(acao.equals("cad")){
                
                String nome   = request.getParameter("nome");
                double valor  = Double.parseDouble( request.getParameter("valor") );
                int    prazo  = Integer.parseInt( request.getParameter("prazo") );
                        
                if(Application.Apl_Classe.incluir(nome, valor, prazo) == Application.Apl_Classe.RESULT_OK){}
            }
            
        }
        
        request.getRequestDispatcher("ListClasse.jsp").forward(request,response); 
    }
    
    
    /**
     * Recupera todos os registros do banco de dados relacionados a tabela do servlet.
     * @return List Lista de registros
     */
    public static List consultarTodosRegistros() {
        return Apl_Default.consultarTodosRegistros("Classe");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
