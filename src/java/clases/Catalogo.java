package clases;

import java.util.ArrayList;

public class Catalogo {

    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public void cargaDatos() {
        productos.clear();
        productos.add(new Producto(1, "Pelikan_Souveran_M1000", 545, "pelikan.jpg"));
        productos.add(new Producto(2, "Parker_Duofold_International", 406, "parkerduo.jpg"));
        productos.add(new Producto(3, "Visconti_Van_Gogh", 180, "visconti.jpg"));
        productos.add(new Producto(4, "Waterman_Expert", 103.55, "waterman.jpg"));
        productos.add(new Producto(5, "Delta_Dolce_Vita", 480, "deltadolce.jpg"));
        productos.add(new Producto(6, "Montblanc_Meisterstuck_146", 580, "montblanc.jpg"));
        productos.add(new Producto(7, "Montegrappa_Extra_1930", 1190, "montegrappa.jpg"));
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Producto productoConCodigo(int codigo) {
        for (Producto producto : productos)
        {
            if (producto.getCodigo() == codigo)
            {
                return producto;
            }
        }
        return null;
    }
}
