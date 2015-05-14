<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Diretor</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Diretor">Diretor</a></li>
                <li class="active">Cadastrar Diretor</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form method="POST" action="Diretor">
                
                <div class="form-group">
                    <label for="exampleInput">Nome</label>
                    <input type="text" class="form-control" name="nome">
                </div>
                
                <input type="hidden" name="acao" value="cad">
                
                <a href="Diretor" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>