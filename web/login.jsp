<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
    <head>

        <meta charset="UTF-8">
        <title>Login</title>
        <meta name="description" content="Painel do sistema">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Icons -->
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="shortcut icon" href="img/favicon.ico">

        <!-- Style -->
        <link rel="stylesheet" href="css/login.css">

        <!-- Modernizr -->
        <script src="lib/js/modernizr.js"></script>

    </head>
    <body class="login-page">

        <div id="login-form">

            <h3>Login</h3>

            <fieldset>

                <form action="login" method="POST">

                    <input type="email" name="email" required value="admin@locadora.com" > 

                    <input type="password" name="password" required value="Password" > 
                    
                    <input type="hidden" name="acao" value="login">
                    
                    <input type="submit" value="Login">

                    <footer class="clearfix">

                        <p><span class="info">?</span><a href="#">Forgot Password</a></p>

                    </footer>

                </form>

            </fieldset>

        </div> <!-- end login-form -->

    </body>
</html>