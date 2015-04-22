<%@page import="Application.Apl_Item"%>
<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>

<%@ page import="Controller.Servlet_Item"%>
<%@ page import="Model.Item"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%
    
    List registros = Servlet_Item.consultarTodosRegistros();
	
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Itens</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">Itens</li>
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
                            <th>Número de série</th>
                            <th>Título</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
			
                            Iterator<Item> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Item o = (Item)obj.next();
				out.println("<tr>"
                                                + "<th scope='row'>" + o.getId() + "</th>"
                                                + "<td>" + o.getNumeroSerie()+ "</td>"
                                                + "<td>" + o.getTitulo().getNome() + "</td>"
                                                + "<td><a href='#'>View</a> | <a href='FormCategoria.jsp'>Edit</a> | <a href='#'>Delete</a></td>"
				+ "</tr>");
									
                            }
                            
			%>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormItem.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>