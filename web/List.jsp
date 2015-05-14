<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.reflect.*"%>

<%
    
    // List type
    String list_type = request.getParameter("list_type");  
    
    // Main class
    String mainClass = "Model."+list_type;
    String mainApplication = "Application.Apl_"+list_type;
    String mainServlet = "Controller.Servlet_"+list_type;
    
    // Object from main class
    Object objMainClass = Class.forName(mainClass).newInstance(); 
    
    // Main Application
    Object objMainApplication = Class.forName(mainApplication).newInstance(); 
    
    // Get Form List Method application 
    Method  objMainApplication_getFormList = Class.forName(mainApplication).getMethod("getFormList", Object.class );
    
    // Get Form List Header Method application 
    Method  objMainApplication_getFormListHeader = Class.forName(mainApplication).getMethod("getFormListHeader");
    
    // Main List
    Object  mainList = Class.forName(mainServlet);
    
    // Main List Method
    Method  mainListMethod = Class.forName(mainServlet).getMethod("consultarTodosRegistros");
    
    // Invoke method    
    List registros = (List) mainListMethod.invoke(null);
    
    // Errors
    String error = request.getParameter("erro");  
  	
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title"><% out.println( list_type ); %></h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active"><% out.println( list_type ); %></li>
            </ol>

        </div>

    </div>

    <div class="row">

        <div class="col-sm-12">
            
            <%
    
                if( error != null) {
                    if(error.equals("0")) {
                        out.println("<div class='alert alert-success'>Ação realizada com sucesso!</div>");
                    } else {
                        out.println("<div class='alert alert-danger'>Erro!</div>");
                    }
                }
                
            %>

            <div class="table-responsive">

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <% out.println(objMainApplication_getFormListHeader.invoke(null)); %>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                			
                            Iterator obj = registros.iterator();
                            
                            while (obj.hasNext()){
                                
                                Object objListItem = Class.forName(mainClass).newInstance(); 
								
                                Object o = (Object)obj.next();
				out.println(objMainApplication_getFormList.invoke(obj, o));
									
                            }
                            
			%>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="Form.jsp?list_type=<% out.println(list_type); %>&acao=cad" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>