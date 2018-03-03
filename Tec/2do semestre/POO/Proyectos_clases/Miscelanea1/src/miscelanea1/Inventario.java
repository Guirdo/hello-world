package miscelanea1;

import java.util.ArrayList;

public class Inventario {

    ArrayList<Producto> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto pro) {
        inventario.add(pro);
    }

    public void disminuirInventario(int num, int cant) {
        int num2 = inventario.get(num).getCantidad();

        inventario.get(num).setCantidad(num2 - cant);
    }

    public int busqueda(String nombre) {
        int esta = 0;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equals(nombre)) {
                esta = i;
                break;
            } else {
                esta = -1;
            }
        }

        return esta;
    }

    @Override
    public String toString() {
        String sal = "";

        for (int i = 0; i < inventario.size(); i++) {
            sal += inventario.get(i).toString();
        }

        return sal;
    }

}
