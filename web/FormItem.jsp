<%@ include file="inc/header.jsp" %>

<%@ page import="Model.TipoItem"%>
<%@ page import="Controller.Servlet_TipoItem"%>

<%@ page import="Model.Titulo"%>
<%@ page import="Controller.Servlet_Titulo"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Item</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Titulo">Titulo</a></li>
                <li class="active">Cadastrar título</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form method="POST" action="Item">
                
                <div class="form-group">
                    <label for="exampleInput">Número de série</label>
                    <input type="text" class="form-control" name="numero">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Data de aquisição</label>
                    <input type="text" class="form-control" name="aquisicao">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Título</label>
                    <select class="form-control" name="titulo">
			
                        <%
                            List registros = Servlet_Titulo.consultarTodosRegistros();
                            Iterator<Titulo> titulo = registros.iterator();
                            
                            while (titulo.hasNext()){
								
                                Titulo o = (Titulo)titulo.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                        
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Tipo</label>
                    <select class="form-control" name="tipo">
		
                        <%
                            registros = Servlet_TipoItem.consultarTodosRegistros();
                            Iterator<TipoItem> cat = registros.iterator();
                            
                            while (cat.hasNext()){
								
                                TipoItem o = (TipoItem)cat.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                        
                    </select>
                </div>
                        
                <input type="hidden" name="acao" value="cad">
                
                <a href="Item" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>