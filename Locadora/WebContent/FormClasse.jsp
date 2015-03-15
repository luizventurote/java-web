<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Classe</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Classe">Classe</a></li>
                <li class="active">Cadastrar classe</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form>
                <div class="form-group">
                    <label for="exampleInput">Nome</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Valor de locação</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Prazo de devolução (dias)</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Título</label>
                    <select class="form-control">
					  <option>Matrix</option>
					  <option>Os Vingadores</option>
					  <option>Duro de matar</option>
					</select>
                </div>
                <a href="Classe" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>