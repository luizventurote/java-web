package Controller;

import Application.Apl_Default;
import Model.Distribuidor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz
 */
@WebServlet(name = "Servlet_Distribuidor", urlPatterns = {"/Distribuidor"})
public class Servlet_Distribuidor extends HttpServlet {
    
    private static String tabela = "Distribuidor";

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
                int cnpj     = Integer.parseInt(request.getParameter("cnpj"));
                String razao = request.getParameter("razao");
                if(Application.Apl_Distribuidor.incluir(cnpj, razao) == Application.Apl_Distribuidor.RESULT_OK){}
            }
            
            if(acao.equals("upd")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                int cnpj     = Integer.parseInt(request.getParameter("cnpj"));
                String razao = request.getParameter("razao");
                
                Distribuidor obj = (Distribuidor) Apl_Default.getRegistro(tabela, id);
                
                obj.setRazaoSocial(razao);
                
                try {
                    if(Application.Apl_Distribuidor.update(obj) == Application.Apl_Distribuidor.RESULT_OK){}
                } catch (Exception ex) {
                    Logger.getLogger(Servlet_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if(acao.equals("del")){
                int id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    if(Application.Apl_Distribuidor.deletar(tabela, id) == Application.Apl_Distribuidor.RESULT_OK){}
                } catch (Exception ex) {
                    Logger.getLogger(Servlet_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
		
        request.getRequestDispatcher("ListDistribuidor.jsp").forward(request,response); 
        
    }
    
    /**
     * Recupera todos os registros do banco de dados relacionados a tabela do servlet.
     * @return List Lista de registros
     */
    public static List consultarTodosRegistros() {
        return Apl_Default.consultarTodosRegistros(tabela);
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
