package Controller;

import Application.Apl_Default;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Luiz Venturote
 */
@WebServlet(name = "Servlet_Cliente", urlPatterns = {"/Cliente"})
public class Servlet_Cliente extends HttpServlet {
    
    private static String tabela = "Cliente";

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
        String tipo = request.getParameter("tipo");        
        if( (acao!=null) && (tipo!=null) ) {
            
            // Cadastrar
            if(acao.equals("cad")){
                
                String nome = request.getParameter("nome");
                String data_nascimento = request.getParameter("data_nascimento");
                String endereco = request.getParameter("endereco");
                String telefone = request.getParameter("telefone");
                String cpf = request.getParameter("cpf");
                char sexo = request.getParameter("sexo").charAt(0);
                String estado = request.getParameter("estado");
                
                if(tipo.equals("socio")) {
                    if(Application.Apl_Cliente.incluirSocio(nome, endereco, telefone, sexo, cpf, data_nascimento) == Application.Apl_Default.RESULT_OK){}
                }
                
            }
            
            // Deletar
            if(acao.equals("del")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                try {
                    if(Application.Apl_Ator.deletar(tabela, id) == Application.Apl_Default.RESULT_OK){
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
