<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

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

            <form>
                <div class="form-group">
                    <label for="exampleInput">Número de série</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Data de aquisição</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Título</label>
                    <select class="form-control">
					  <option>Matrix</option>
					  <option>Homem de Ferro</option>
					  <option>Os Vingadores</option>
					  <option>Jogos Vorazes</option>
					</select>
                </div>
                <div class="form-group">
                    <label for="exampleInput">Tipo</label>
                    <select class="form-control">
					  <option>DVD</option>
					  <option>Blu-Ray</option>
					  <option>Fita</option> 
					</select>
                </div>
                <a href="Item" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>