package Controller;

import Application.Apl_Default;
import Model.Cliente;
import Model.Item;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Venturote
 */
@WebServlet(name = "Servlet_Locacao", urlPatterns = {"/Locacao"})
public class Servlet_Locacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        if(acao != null ) {
            
            if(acao.equals("cad")){
                
                int id_cliente = Integer.parseInt( request.getParameter("id_cliente") );
                int id_item = Integer.parseInt( request.getParameter("id_item") );
                String data_locacao = request.getParameter("data_locacao");
                String data_devolucao = request.getParameter("data_devolucao");
                double valor = Double.parseDouble( request.getParameter("valor") );
                
                /**
                 * Recupera registros
                 */
                Cliente cli = (Cliente) Apl_Default.getRegistro("Cliente", id_cliente);
                Item item = (Item) Apl_Default.getRegistro("Item", id_item);
                
                if(Application.Apl_Locacao.incluir(data_locacao, data_devolucao, valor, cli, item) == Application.Apl_Ator.RESULT_OK){}
            }
            
        }
        
        request.getRequestDispatcher("ListLocacao.jsp").forward(request,response);
        
    }
    
    
    /**
     * Recupera todos os registros do banco de dados relacionados a tabela do servlet.
     * @return List Lista de registros
     */
    public static List consultarTodosRegistros() {
        return Apl_Default.consultarTodosRegistros("Locacao");
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
