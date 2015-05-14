<%@ include file="inc/header.jsp" %>

<%@ page import="java.lang.reflect.*"%>

<%
    
    // List type
    String list_type = request.getParameter("list_type");  
  	
    // Main class
    String mainClass = "Model."+list_type;
    String mainApplication = "Application.Apl_"+list_type;
    
    // Object from main class
    Object objMainClass = Class.forName(mainClass).newInstance(); 
    
    // Main Application
    Object objMainApplication = Class.forName(mainApplication).newInstance(); 
    
    // Get Form List Method application 
    Method  objMainApplication_getForm = Class.forName(mainApplication).getMethod("getForm");
    
    // Get Form List Method application 
    Method  objMainApplication_getFormToUpdate = Class.forName(mainApplication).getMethod("getFormToUpdate", int.class); 
    
    // Form
    String mainForm = "";
    
    // Submit button name
    String submitName = "Cadastrar";
    
    // Variável que informa que a requisição é de consulta
    boolean con = false;
    
    // Check the action
    String acao = request.getParameter("acao");
    if(acao != null ) {
        
        // Consultar
        if( acao.equals("con") ) {
            
            // Habilita a consulta
            con = true;
            
            // Change submit button name
            submitName = "Salvar";
            
            // Get object ID
            int obj_id = Integer.parseInt(request.getParameter("id"));
            
            // Chama o form de update passando o ID
            mainForm = (String) objMainApplication_getFormToUpdate.invoke(null, obj_id);
        }
        
        // Cadastrar
        if( acao.equals("cad") ) {
            
            // Chama o form de update passando o ID
            mainForm = (String) objMainApplication_getForm.invoke(null);
        }
        
    }
    
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title"><% out.println( list_type ); %></h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.php">Home</a></li>
                <li><a href="list.php"><% out.println( list_type ); %></a></li>
                <li class="active">Form <% out.println( list_type ); %></li>
            </ol>

        </div>

    </div>

    <div class="row">

        <div class="col-sm-6">
            
            <form action="<% out.println( list_type ); %>" method="POST">
                
                <% out.println(mainForm); %>
                                                
                <input type="hidden" name="acao" value="cad">
                
                <a href="<% out.println( list_type ); %>" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right"><% out.print(submitName); %></button>
            </form> 

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>