package Controller;

import Application.Apl_Default;
import Model.Cliente;
import Model.Item;
import Model.Locacao;
import Model.Titulo;
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
    
    private static String tabela = "Locacao";

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
        
        String url = "List.jsp?list_type="+tabela;
        
        // Verifica a ação do usuário informada na URL
        String acao = request.getParameter("acao");
        if (acao != null) {
            
            // Cadastrar
            if(acao.equals("cad")){
                
                int cliente             = Integer.parseInt( request.getParameter("cliente") );
                int item                = Integer.parseInt( request.getParameter("item") );
                String data_locacao     = request.getParameter("data_locacao");
                String data_devolucao   = request.getParameter("data_devolucao");
                double valor            = Double.parseDouble( request.getParameter("valor") );
                
                //Recupera registros
                Cliente cli = (Cliente) Apl_Default.getRegistro("Cliente", cliente);
                Item it     = (Item) Apl_Default.getRegistro("Item", item);
                
                 if(Application.Apl_Locacao.incluir(data_locacao, data_devolucao, valor, cli, it) == Application.Apl_Ator.RESULT_OK){
                    url = url + "&erro=0";
                } else {
                    url = url + "&erro=1";
                }
                
            }            
            
            // Update
            if(acao.equals("upd")){
                
                // Object data
                int id          = Integer.parseInt(request.getParameter("id"));
                int cliente             = Integer.parseInt( request.getParameter("cliente") );
                int item                = Integer.parseInt( request.getParameter("item") );
                String data_locacao     = request.getParameter("data_locacao");
                String data_devolucao   = request.getParameter("data_devolucao");
                double valor            = Double.parseDouble( request.getParameter("valor") );
                
                //Recupera registros
                Cliente cli = (Cliente) Apl_Default.getRegistro("Cliente", cliente);
                Item it  = (Item) Apl_Default.getRegistro("Item", item);
                
                // Main Object
                Locacao obj = (Locacao) Apl_Default.getRegistro(tabela, id);
                
                // Set object values
                obj.setCliente(cli);
                obj.setItem(it);
                obj.setDataDevolucao(data_devolucao);
                obj.setDataLocacao(data_locacao);
                obj.setValorCobrado(valor);
                
                try {
                    if(Application.Apl_Locacao.update(obj) == Application.Apl_Default.RESULT_OK){}
                } catch (Exception ex) {}
                
            }
            
            // Deletar
            if(acao.equals("del")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    if(Application.Apl_Locacao.deletar(tabela, id) == Application.Apl_Default.RESULT_OK){
                        url = url + "&erro=0";
                    } else {
                        url = url + "&erro=1";
                    }
                } catch (Exception ex) {}
                
            }

        }
        
        response.sendRedirect(url);
          
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
