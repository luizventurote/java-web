<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
    <head>
        
        <%
            String nomeUsuario = (String) session.getAttribute("usuarioautenticado");
            if(nomeUsuario == null)
                response.sendRedirect("login.jsp");
        %>
        

        <meta charset="UTF-8">
        <title>Locadora</title>
        <meta name="description" content="Painel do sistema">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Icons -->
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="shortcut icon" href="img/favicon.ico">

        <!-- Style -->
        <link rel="stylesheet" href="css/style.css"> 

        <!-- Modernizr -->
        <script src="lib/js/modernizr.js"></script>

    </head> 
    <body>

        <header class="wrapper top-bar">

            <div class="top-bar-brand">

                <div class="menu-icon" id="menu-toggle"></div>
                
                <div class="top-bar-item">
                	<%@ include file="../ui/logo.jsp" %>
                </div>

            </div>

            <div class="top-bar-nav">

                <%@ include file="../ui/dropdown.jsp" %>

            </div>

        </header>

        <main>

            <div class="wrapper page" id="page">
            
                <%@ include file="../ui/menu.jsp" %>

                <div class="content" id="content">