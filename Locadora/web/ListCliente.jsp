<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@ page import="Controller.Servlet_Cliente"%>
<%@ page import="Model.Cliente"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cliente</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">Cliente</li>
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
                            <th>Tipo</th>
                            <th>Nome</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            List registros = Servlet_Cliente.consultarTodosRegistros();
			
                            Iterator<Cliente> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Cliente o = (Cliente)obj.next();
				out.println("<tr>"
                                                + "<th scope='row'>" + o.getNumero_inscricao() + "</th>"
                                                + "<td>" + o.getClass().getSimpleName() + "</td>"
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
            <a href="FormCliente.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>