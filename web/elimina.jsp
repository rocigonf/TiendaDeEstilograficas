<%@page import="clases.Carrito"%>
<%@page import="jakarta.servlet.http.Cookie"%>
<%
    // Recupera el código del producto.
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    
    Cookie cookie = Carrito.dameCookie(request, "carrito");
    Carrito carrito;
    
    // Si no existe la cookie, se crea una nueva. En caso contrario carga la cookie ya existente.
    if (cookie == null) {
        carrito = new Carrito();
    } else {
        carrito = new Carrito(cookie.getValue());
    }
    
    // Elimina el producto de el carrito.
    carrito.eliminaProductoConCodigo(codigo);
    
    // Crea una nueva cookie carrito y la actualiza.
    cookie = new Cookie("carrito", carrito.toString());
    cookie.setPath("/");
    cookie.setMaxAge(365 * 24 * 60 * 60);
    response.addCookie(cookie);
    
    // Redirige a index.jsp
    response.sendRedirect("index.jsp");
%>

