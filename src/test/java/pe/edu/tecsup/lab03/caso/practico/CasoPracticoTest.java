package pe.edu.tecsup.lab03.caso.practico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import pe.edu.tecsup.lab03.caso.practico.CasoPractico;

import static org.junit.jupiter.api.Assertions.*;

public class CasoPracticoTest {

    @Test
    @DisplayName("Debe reordenar cuando stock <= punto de reorden")
    public void testDebeReordenar() {
        assertTrue(CasoPractico.debeReordenar(5, 7));
        assertTrue(CasoPractico.debeReordenar(7, 7));
        assertFalse(CasoPractico.debeReordenar(10, 7));
    }

    @Test
    @DisplayName("Aplica descuento correcto y redondea a 2 decimales")
    public void testAplicarDescuento() {
        assertEquals(135.00, CasoPractico.aplicarDescuento(150.0, 10), 0.0001);
        assertEquals(0.00, CasoPractico.aplicarDescuento(0.0, 25), 0.0001);
        assertEquals(99.99, CasoPractico.aplicarDescuento(111.10, 10), 0.0001);
    }

    @Test
    @DisplayName("Valida formato de SKU")
    public void testValidarSKU() {
        assertTrue(CasoPractico.validarSKU("ABC-123"));
        assertTrue(CasoPractico.validarSKU("SKU2024"));
        assertFalse(CasoPractico.validarSKU("ab-123"));       // minúsculas no permitidas
        assertFalse(CasoPractico.validarSKU("A!B"));          // símbolo inválido
        assertFalse(CasoPractico.validarSKU("AB"));           // muy corto
        assertFalse(CasoPractico.validarSKU("ABCDEFGHIJKL3")); // muy largo (>12)
        assertFalse(CasoPractico.validarSKU(null));
        assertFalse(CasoPractico.validarSKU("   "));
    }

    @Test
    @DisplayName("Calcula valor de ítem (precio * cantidad)")
    public void testValorItem() {
        assertEquals(59.97, CasoPractico.valorItem(19.99, 3), 0.0001);
        assertEquals(0.00, CasoPractico.valorItem(0, 100), 0.0001);
    }

    @Test
    @DisplayName("Lanza excepciones con datos inválidos")
    public void testExcepciones() {
        assertThrows(IllegalArgumentException.class, () -> CasoPractico.debeReordenar(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> CasoPractico.aplicarDescuento(100, -5));
        assertThrows(IllegalArgumentException.class, () -> CasoPractico.aplicarDescuento(100, 150));
        assertThrows(IllegalArgumentException.class, () -> CasoPractico.valorItem(-10, 1));
        assertThrows(IllegalArgumentException.class, () -> CasoPractico.valorItem(10, -1));
    }
}
