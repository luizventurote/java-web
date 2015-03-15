<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

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

            <form>
                <div class="form-group">
                    <label for="exampleInput">Nome</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Ano</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Categoria</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Atores</label>
                    <select multiple class="form-control">
					  <option>Angelina Jolie</option>
					  <option>Vin Diesel</option>
					  <option>Brad Pitt</option>
					  <option>Johnny Depp</option>
					  <option>Natalie Portman</option>
					</select>
                </div>
                <div class="form-group">
                    <label for="exampleInput">Diretor</label>
                    <select class="form-control">
					  <option>Steven Spielberg</option>
					  <option>Andy Wachowski</option>
					  <option>Lana Wachowski</option> 
					</select>
                </div>
                <div class="form-group">
                    <label for="exampleInput">Sinopse</label>
                    <textarea class="form-control" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleInput">Distribuidor</label>
                    <select class="form-control">
					  <option>Distribuidor 1</option>
					  <option>Distribuidor 2</option>
					  <option>Distribuidor 3</option>
					</select>
                </div>
                <a href="Titulo" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>