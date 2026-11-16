import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExportJSON {

    public void exportarTicket(Ticket ticket){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Map<String, Object> datos = new LinkedHashMap<>();
        datos.put("cliente", ticket.getCliente().getNombre());
        datos.put("camarero", ticket.getCamarero().getNombre());
        datos.put("total", ticket.calcularTotal());

        ArrayList<Map<String, Object>> listaProductos = new ArrayList<>();

        for (Producto producto : ticket.getProductos()){
            Map<String, Object> datosProducto = new HashMap<>();
            datosProducto.put("nombre", producto.getNombre());
            datosProducto.put("precio", producto.getPrecio());
            listaProductos.add(datosProducto);
        }
        datos.put("productos", listaProductos);

        String json = gson.toJson(datos);

        try (FileWriter escritor = new FileWriter("ticket.json")) {
            escritor.write(json);
        } catch (IOException e) {
            System.out.println("Error al exportar el ticket: " + e.getMessage());
        }


    }
}
