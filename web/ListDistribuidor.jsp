<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>

<%@ page import="Controller.Servlet_Distribuidor"%>
<%@ page import="Model.Distribuidor"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%
    
    List registros = Servlet_Distribuidor.consultarTodosRegistros();
	
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Distribuidores</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.php">Home</a></li>
                <li class="active">Distribuidor</li>
            </ol>

        </div>

    </div>

    <div class="row">

        <div class="col-sm-12">

            <div class="table-responsive"> 

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CNPJ</th>
                            <th>Razão social</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
			
                            Iterator<Distribuidor> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Distribuidor o = (Distribuidor)obj.next();
                                
                                int o_id = (int) o.getCnpj(); 
                                
				out.println("<tr>"
                                                + "<th scope='row'>" + o_id + "</th>"
                                                + "<td>" + o.getRazaoSocial()+ "</td>"
                                                + "<td><a href='#'>View</a> | <a href='FormDistribuidor.jsp?acao=con&id="+ o_id +"'>Edit</a> | <a href='Distribuidor?acao=del&id="+ o_id +"'>Delete</a></td>"
				+ "</tr>");
									
                            }
                            
			%>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormDistribuidor.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>