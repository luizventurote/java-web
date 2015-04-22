<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>

<%@ page import="Controller.Servlet_Titulo"%>
<%@ page import="Model.Titulo"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%
    
    List registros = Servlet_Titulo.consultarTodosRegistros();
	
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Títulos</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index">Home</a></li>
                <li class="active">Data</li>
            </ol>

        </div>

    </div>

    <div class="row">

        <div class="col-sm-12">

            <div class="table-responsive">

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Título</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
			
                            Iterator<Titulo> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Titulo o = (Titulo)obj.next();
				out.println("<tr>"
                                                + "<th scope='row'>" + o.getId() + "</th>"
                                                + "<td>" + o.getNome() + "</td>"
                                                + "<td><a href='#'>View</a> | <a href='FormCategoria.jsp'>Edit</a> | <a href='#'>Delete</a></td>"
				+ "</tr>");
									
                            }
                            
			%>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormTitulo.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>