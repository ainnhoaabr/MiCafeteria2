import java.util.ArrayList;
import java.util.HashMap;

public class GestorProductos {
    private HashMap<String, ArrayList<Producto>> productosPorCategoria;

    public GestorProductos(){
        productosPorCategoria = new HashMap<>();
    }

    public void agregarProducto(String categoria, Producto producto){
        if (!productosPorCategoria.containsKey(categoria)) {
            productosPorCategoria.put(categoria, new ArrayList<>());
        }
        productosPorCategoria.get(categoria).add(producto);
    }

    public void mostrarProductosPorCategoria() {

        for (String categoria : productosPorCategoria.keySet()) {

            System.out.println("\nCategoría: " + categoria);

            for (Producto producto : productosPorCategoria.get(categoria)) {

                System.out.println(producto.mostrarInformacion());

            }
        }
    }
}
