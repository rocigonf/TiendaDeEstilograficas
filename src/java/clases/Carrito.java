package clases;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class Carrito {

    private ArrayList<ElementoDeCarrito> elementos = new ArrayList<ElementoDeCarrito>();

    public Carrito() {
    }
    
    /**
     * Constructor para deserializar los elementos del carrito.
     * @param carritoSerializado - Carrito serializado en el toString()
     */
    public Carrito(String carritoSerializado){
        // Se almacena la cadena en un array que se divide en lineas (cada elemento del carrito) divididas por ";".
        String[] lineas = carritoSerializado.split("/");
        if (!carritoSerializado.equals("")) {
            // Recorre cada línea(elemento del carrito) y la divide en partes divididas por ">" (cada atributo del elemento).
            for (String linea : lineas){
                String[] partes = linea.split(">");
                // Si la longitud de cada elemento es de 5 partes, ordena los atributos dentro del array y los añade a elemento.
                if (partes.length == 5){
                    try{
                        int cantidad = Integer.parseInt(partes[0]);
                        int codigo = Integer.parseInt(partes[1]);
                        String nombre = partes[2];
                        double precio = Double.parseDouble(partes[3]);
                        String imagen = partes[4];

                        Producto producto = new Producto(codigo, nombre, precio, imagen);

                        ElementoDeCarrito elemento = new ElementoDeCarrito(producto, cantidad);
                        elementos.add(elemento);
                    } catch(Exception e){
                        e.getMessage();
                    }
                }
            }
        }
    }
    
    public Carrito(ArrayList<ElementoDeCarrito> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<ElementoDeCarrito> getElementos() {
        return elementos;
    }

    public boolean existeElementoConCodigo(int codigo) {
        return this.posicionElementoConCodigo(codigo) != -1;
    }

    public void meteProductoConCodigo(int codigo) {
        if (this.existeElementoConCodigo(codigo))
        {
            elementos.get(posicionElementoConCodigo(codigo)).incrementaCantidad(1);
        } else
        {
            Catalogo catalogo = new Catalogo();
            catalogo.cargaDatos();
            elementos.add(new ElementoDeCarrito(catalogo.productoConCodigo(codigo), 1));
        }
    }

    public void eliminaProductoConCodigo(int codigo) {
        if (existeElementoConCodigo(codigo))
        {
            int i = 0;
            int posicion = 0;
            for (ElementoDeCarrito elemento : elementos)
            {
                if (elemento.getProducto().getCodigo() == codigo)
                {
                    posicion = i;
                }
                i++;
            }
            elementos.remove(posicion);
        }
    }

    private int posicionElementoConCodigo(int codigo) {
        int i = 0;
        for (ElementoDeCarrito elemento : elementos){
            if (elemento.getProducto().getCodigo() == codigo){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    /**
     * Método dameCookie.
     * @param request
     * @param nombre - Nombre de la cookie
     */
    public static Cookie dameCookie(HttpServletRequest request, String nombre) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(nombre)) {
                    return cookie;
                }
            }
        }
    return null;
    }
    
    /**
     * Método toString para serializar los elementos del carrito.
     */
    @Override
    public String toString(){
        String carritoSerializado = "";
        for (ElementoDeCarrito elemento : elementos) {
            Producto producto = elemento.getProducto();
            carritoSerializado += elemento.getCantidad() + ">" 
                                + producto.getCodigo() + ">"
                                + producto.getNombre() + ">"
                                + producto.getPrecio() + ">"
                                + producto.getImagen() + "/";
        }
        return carritoSerializado;
    }
}