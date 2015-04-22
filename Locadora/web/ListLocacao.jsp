<%@ include file="inc/header.jsp" %>

<%@ page import="Controller.Servlet_Locacao"%>
<%@ page import="Model.Locacao"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Locação</h1>

        </div> 

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">Locação</li>
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
                            <th>Cliente</th>
                            <th>Título</th>
                            <th>Data de locação</th>
                            <th>Data de devolução</th>
                            <th>Valor</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            List registros = Servlet_Locacao.consultarTodosRegistros();
			
                            Iterator<Locacao> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Locacao o = (Locacao)obj.next();
				out.println("<tr>"
                                                + "<th scope='row'>" + o.getId() + "</th>"
                                                + "<td>" + o.getCliente().getNome() + "</td>"
                                                + "<td>" + o.getItem().getTitulo().getNome() + "</td>"
                                                + "<td>" + o.getDataLocacao()+ "</td>"
                                                + "<td>" + o.getDataDevolucao() + "</td>"
                                                + "<td>" + o.getValorCobrado() + "</td>"
                                                + "<td><a href='#'>View</a> | <a href='FormCategoria.jsp'>Edit</a> | <a href='#'>Delete</a></td>"
				+ "</tr>");
									
                            }
                            
			%>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormLocacao.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>