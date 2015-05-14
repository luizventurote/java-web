<%@page import="Application.Apl_Distribuidor"%>
<%@ include file="inc/header.jsp" %>

<%@page import="Model.Distribuidor"%>

<%
    
    String tabela = "Distribuidor";
    
    //String acao = request.getParameter("acao");
    //int id = Integer.parseInt(request.getParameter("id"));
    
    //boolean con = true;
    
    //acao = "upd";
			
    //int id = 159; 
    //Distribuidor o = (Distribuidor) Apl_Distribuidor.getRegistro("Distribuidor", id);
    
%>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar <% out.print(tabela); %></h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Distribuidor"><% out.print(tabela); %></a></li>
                <li class="active">Cadastrar <% out.print(tabela); %></li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form method="GET" action="Distribuidor">
                
                <div class="form-group">
                    <label for="exampleInput">Razão social</label>
                    <input type="text" class="form-control" name="razao" <% //if(con){out.print("value='"+o.getRazaoSocial()+"'");} %>>
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">CNPJ</label>
                    <input type="text" class="form-control" name="cnpj" <% //if(con){out.print("value='"+o.getCnpj()+"'");} %>>
                </div>
                
                <input type="hidden" name="acao" value="<% //if(con){ out.print( acao ); } %>">
                
                <input type="hidden" name="id" value="<% //if(con){ out.print( o.getCnpj() ); } %>">
                               
                <a href="Distribuidor" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Salvar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>