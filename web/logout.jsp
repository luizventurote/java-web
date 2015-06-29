<%
    session.removeAttribute("usuarioautenticado");
    response.sendRedirect("login.jsp");
%>