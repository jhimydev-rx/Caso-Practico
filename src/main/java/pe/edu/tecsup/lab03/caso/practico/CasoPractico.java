package pe.edu.tecsup.lab03.caso.practico;

import java.util.Objects;


public class CasoPractico {

    
    public static boolean debeReordenar(int stockActual, int puntoReorden) {
        if (stockActual < 0 || puntoReorden < 0) {
            throw new IllegalArgumentException("Valores negativos no permitidos");
        }
        return stockActual <= puntoReorden;
    }

    
    public static double aplicarDescuento(double total, double porcentajeDescuento) {
        if (total < 0) throw new IllegalArgumentException("Total no puede ser negativo");
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Descuento fuera de rango 0-100");
        }
        double factor = 1.0 - (porcentajeDescuento / 100.0);
        return Math.round(total * factor * 100.0) / 100.0;
    }

   
    public static boolean validarSKU(String sku) {
        if (sku == null) return false;
        String s = sku.trim();
        if (s.isEmpty()) return false;
        if (s.length() < 3 || s.length() > 12) return false;
        return s.matches("[A-Z0-9-]+");
    }


    public static double valorItem(double precioUnitario, int cantidad) {
        if (precioUnitario < 0 || cantidad < 0) {
            throw new IllegalArgumentException("Precio o cantidad negativos");
        }
        return Math.round(precioUnitario * cantidad * 100.0) / 100.0;
    }

    // Pequeña demo para ejecutar: mvn exec:java
    public static void main(String[] args) {
        System.out.println("=== Caso Práctico: Integración Continua (Maven) ===");
        System.out.println("¿Reordenar? stock=5, punto=7 -> " + debeReordenar(5, 7));
        System.out.println("Descuento 10% de 150.0 -> " + aplicarDescuento(150.0, 10));
        System.out.println("SKU válido ABC-123? -> " + validarSKU("ABC-123"));
        System.out.println("Valor item 19.99 x 3 -> " + valorItem(19.99, 3));
    }
}
