<%@ include file="inc/header.jsp" %>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@ page import="Model.Categoria"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%

    SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
    Session s = sessions.openSession();
		
    String strQuery = "from Categoria";
		
    s.beginTransaction();
    Query qr = s.createQuery(strQuery);
    List registros = qr.list();
		
		
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Categoria</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">Categoria</li>
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
                            <th>Nome</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <%
			
                            Iterator<Categoria> i = registros.iterator();
                            
                            while (i.hasNext()){
								
                                Categoria so = (Categoria)i.next();
				out.println("<tr>"
                                                + "<th scope='row'>" + so.getId() + "</th>"
                                                + "<td>" + so.getNome() + "</td>"
                                                + "<td><a href='#'>View</a> | <a href='FormCategoria.jsp'>Edit</a> | <a href='#'>Delete</a></td>"
				+ "</tr>");
									
                            }
			
                            s.close();
			%>
                        
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormCategoria.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>