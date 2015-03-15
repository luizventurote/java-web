<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Classes</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.php">Home</a></li>
                <li class="active">Data</li>
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
                            <th>Prazo de devolução</th>
                            <th>Título</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>5</td>
                            <td>Matrix</td>
                            <td><a href="#">View</a> | <a href="FormClasse.jsp">Edit</a> | <a href="#">Delete</a></td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Mark</td>
                            <td>5</td>
                            <td>Matrix</td>
                            <td><a href="#">View</a> | <a href="FormClasse.jsp">Edit</a> | <a href="#">Delete</a></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Mark</td>
                            <td>5</td>
                            <td>Matrix</td>
                            <td><a href="#">View</a> | <a href="FormClasse.jsp">Edit</a> | <a href="#">Delete</a></td>
                        </tr>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="col-sm-12">
            <a href="FormClasse.jsp" class="btn btn-primary">Add new</a>
        </div>

    </div>

<%@ include file="inc/footer.jsp" %>