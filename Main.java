package pkg5erronka;


import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private double precio, cantidad;
    private String descripcion;

    public Producto(double precio, String descripcion) {
        this.cantidad = 1;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public double getSubtotal() {
        return cantidad * precio;
    }

    public double getPrecio() {
        return precio;
    }


    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }


}

public class Main {


    public static Producto solicitarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa descripción");
        String descripcion = sc.nextLine();
        System.out.println("Ingresa precio:");
        double precio = sc.nextDouble();
        return new Producto(precio, descripcion);
    }

    public static void agregarProducto(ArrayList<Producto> productos) {
        productos.add(solicitarProducto());
    }

    public static int solicitarIndice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el número de producto: ");
        return sc.nextInt();
    }

    public static void cambiarCantidad(ArrayList<Producto> productos) {
        int indice = solicitarIndice();
        Producto p = productos.get(indice);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nueva cantidad: ");
        double nuevaCantidad = sc.nextDouble();
        p.setCantidad(nuevaCantidad);
        productos.set(indice, p);
    }

    public static void quitarProducto(ArrayList<Producto> productos) {
        int indice = solicitarIndice();
        if (indice < productos.size()) {
            productos.remove(indice);
        } else {
            System.out.println("Número no válido");
        }
    }

    public static void mostrarTicket(ArrayList<Producto> productos) {
        System.out.println("-".repeat(85));
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|\n", "Descripción", "Precio", "Cantidad", "Subtotal");
        System.out.println("-".repeat(85));
        double total = 0;
        for (Producto p : productos) {
            System.out.printf("|%-20s|%-20f|%-20f|%-20f|\n", p.getDescripcion(), p.getPrecio(), p.getCantidad(), p.getSubtotal());
            total += p.getSubtotal();
        }
        System.out.println("-".repeat(85));
        System.out.printf("|%83s|\n", "Total: " + String.valueOf(total));
        System.out.println("                            **Gracias por su compra**");
    }

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (productos.size() > 0) {
                System.out.println("-".repeat(106));
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Número", "Descripción", "Precio", "Cantidad", "Subtotal");
                System.out.println("-".repeat(106));
            }
            int contador = 0;
            for (Producto p : productos) {
                System.out.printf("|%-20d|%-20s|%-20f|%-20f|%-20f|\n", contador, p.getDescripcion(), p.getPrecio(), p.getCantidad(), p.getSubtotal());
                contador++;
            }
            if (productos.size() > 0) {
                System.out.println("-".repeat(106));
            }
            System.out.println("1. Agregar producto\n" +
                    "2. Cambiar cantidad\n" +
                    "3. Quitar producto\n" +
                    "4. Mostrar ticket y terminar venta\n" +
                    "5. Salir\n" +
                    "Seleccione: ");
            String eleccion = sc.nextLine();
            if (eleccion.equals("1")) {
                agregarProducto(productos);
            } else if (eleccion.equals("2")) {
                cambiarCantidad(productos);
            } else if (eleccion.equals("3")) {
                quitarProducto(productos);
            } else if (eleccion.equals("4")) {
                mostrarTicket(productos);
                break;
            } else if (eleccion.equals("5")) {
                break;
            } else {
                System.out.println("Opción no válida");
            }
        }
    }
}
