package Controller;

import Application.Apl_Default;
import Model.TipoItem;
import Model.Item;
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
 * @author Luiz
 */
@WebServlet(name = "Servlet_Item", urlPatterns = {"/Item"})
public class Servlet_Item extends HttpServlet {
    
    private static String tabela = "Item";

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
        if(acao != null ) {
            
            if(acao.equals("cad")){
                
                long numero = Long.parseLong( request.getParameter("numero") );
                String data_aquisicao = request.getParameter("aquisicao");
                int titulo_id = Integer.parseInt( request.getParameter("titulo") );
                int tipo_item_id = Integer.parseInt( request.getParameter("tipo") );
                
                // Recupera registros
                Titulo titulo = (Titulo) Apl_Default.getRegistro("Titulo", titulo_id);
                TipoItem tipo = (TipoItem) Apl_Default.getRegistro("TipoItem", tipo_item_id);
                
                if(Application.Apl_Item.incluir(numero, data_aquisicao, titulo, tipo) == Application.Apl_Item.RESULT_OK){}
            }
        
            // Update
            if(acao.equals("upd")){
                
                // Object data
                int id      = Integer.parseInt(request.getParameter("id"));
                long numero = Long.parseLong( request.getParameter("numero") );
                String data_aquisicao = request.getParameter("aquisicao");
                int titulo_id = Integer.parseInt( request.getParameter("titulo") );
                int tipo_item_id = Integer.parseInt( request.getParameter("tipo") );
                
                // Recupera registros
                Titulo titulo = (Titulo) Apl_Default.getRegistro("Titulo", titulo_id);
                TipoItem tipo = (TipoItem) Apl_Default.getRegistro("TipoItem", tipo_item_id);
                
                // Main Object
                Item obj = (Item) Apl_Default.getRegistro(tabela, id);
                
                // Set object values
                obj.setNumeroSerie(numero);
                obj.setData(data_aquisicao);
                obj.setTitulo(titulo);
                obj.setTipoItem(tipo);
                
                try {
                    if(Application.Apl_Item.update(obj) == Application.Apl_Default.RESULT_OK){}
                } catch (Exception ex) {}
                
            }
            
            // Deletar
            if(acao.equals("del")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    if(Application.Apl_Item.deletar(tabela, id) == Application.Apl_Default.RESULT_OK){
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
