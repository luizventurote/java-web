<%@ include file="inc/header.jsp" %>

<%@ page import="Model.Ator"%>
<%@ page import="Controller.Servlet_Ator"%>

<%@ page import="Model.Distribuidor"%>
<%@ page import="Controller.Servlet_Distribuidor"%>

<%@ page import="Model.Diretor"%>
<%@ page import="Controller.Servlet_Diretor"%>

<%@ page import="Model.Categoria"%>
<%@ page import="Controller.Servlet_Categoria"%>

<%@ page import="Model.Classe"%>
<%@ page import="Controller.Servlet_Classe"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Título</h1>

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

            <form action="Titulo" method="POST">
                
                <div class="form-group">
                    <label for="exampleInput">Nome</label>
                    <input type="text" class="form-control" name="nome">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Ano</label>
                    <input type="text" class="form-control" name="ano">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Categoria</label>
                    <select class="form-control" name="categoria">
			<%
                            List registros = Servlet_Categoria.consultarTodosRegistros();
                            Iterator<Categoria> cat = registros.iterator();
                            
                            while (cat.hasNext()){
								
                                Categoria o = (Categoria)cat.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Classe</label>
                    <select class="form-control" name="classe">
			<%
                            registros = Servlet_Classe.consultarTodosRegistros();
                            Iterator<Classe> cla = registros.iterator();
                            
                            while (cla.hasNext()){
								
                                Classe o = (Classe)cla.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Atores</label>
                    <select multiple class="form-control" name="atores">
                        
                        <%
                            registros = Servlet_Ator.consultarTodosRegistros();
                            Iterator<Ator> obj = registros.iterator();
                            
                            while (obj.hasNext()){
								
                                Ator o = (Ator)obj.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                        
                        </select>
                </div>
                
                <div class="form-group">
                    
                    <label for="exampleInput">Diretor</label>
                    
                    <select class="form-control" name="diretor">
			<%
                            registros = Servlet_Diretor.consultarTodosRegistros();
                            Iterator<Diretor> dir = registros.iterator();
                            
                            while (dir.hasNext()){
								
                                Diretor o = (Diretor)dir.next();
				out.println("<option value='"+o.getId()+"'>"+o.getNome()+"</option>");
									
                            }
                            
			%>
                    </select>
                    
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Sinopse</label>
                    <textarea class="form-control" rows="3" name="sinopse"></textarea>
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Distribuidor</label>
                    <select class="form-control" name="distribuidor">
                        
                        <%
                            registros = Servlet_Distribuidor.consultarTodosRegistros();
                            Iterator<Distribuidor> dis = registros.iterator();
                            
                            while (dis.hasNext()){
								
                                Distribuidor o = (Distribuidor)dis.next();
				out.println("<option value='"+o.getCnpj()+"'>"+o.getRazaoSocial()+"</option>");
									
                            }
                            
			%>    
                        
                    </select>
                </div>
                
                <input type="hidden" name="acao" value="cad">
                
                <a href="Titulo" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>