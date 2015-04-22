<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Reserva</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Reserva">Reserva</a></li>
                <li class="active">Cadastrar Reserva</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form>
                <div class="form-group">
                    <label for="exampleInput">Número do Cliente</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <div class="form-group">
                    <label for="exampleInput">Número do título</label>
                    <input type="text" class="form-control" id="exampleInput">
                </div>
                <a href="Reserva" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Registrar reserva</button>
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>