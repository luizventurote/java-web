<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Distribuidor</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Distribuidor">Distribuidor</a></li>
                <li class="active">Cadastrar Distribuidor</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form method="POST" action="Distribuidor">
                
                <div class="form-group">
                    <label for="exampleInput">Razão social</label>
                    <input type="text" class="form-control" name="razao">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">CNPJ</label>
                    <input type="text" class="form-control" name="cnpj">
                </div>
                
                <input type="hidden" name="acao" value="cad">
                
                <a href="Distribuidor" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>