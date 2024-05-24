<%
    session.setAttribute("idioma", request.getParameter("idioma"));
    
    response.sendRedirect("index.jsp");
%>