## Práctica U15 - Sesiones y cookies
Esta práctica es una tienda de estilográficas en la que puedes cambiar el idioma, añadir y eliminar productos a un carrito.

![imagen](https://github.com/rocigonf/TiendaDeEstilograficas/assets/116120484/43a91f46-c75f-49ca-8c2c-e3b8e70f39c1)

# Partes del código
![imagen](https://github.com/rocigonf/TiendaDeEstilograficas/assets/116120484/aacb6487-c87d-41d7-abac-b1393cd603f4)

Nos encontramos en el índice. En esta parte del [código](web/index.jsp#L31) podemos encontrar 3 partes importantes:
- La creación del catálogo, donde se crea la instancia y llama a un método para poblarla.
- La creación del carrito mediante la creación de una cookie.
- La inicialización de los idiomas; se pone en español por defecto y se guarda en la sesión.

Si haces click sobre las banderas en la página principal, te lleva a [cambia-idioma](web/cambia-idioma.jsp), crea la sesión para recordar el idioma seleccionado y te redirige al índice con el idioma cambiado.

![imagen](https://github.com/rocigonf/TiendaDeEstilograficas/assets/116120484/3891df91-05ba-4939-b0ff-e660eff5d0fa)

*En progreso*
