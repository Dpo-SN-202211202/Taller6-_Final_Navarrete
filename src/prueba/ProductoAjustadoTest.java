package prueba;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ProductoAjustado;

public class ProductoAjustadoTest {

    private ProductoAjustado productoMenuAjustado;

    @BeforeEach
    public void setUp() throws Exception {
        productoMenuAjustado = new ProductoAjustado("PruebaNombreAjustado", 150, 100);
    }
	
    @Test
    public void testGetPrecio() {
        assertEquals(150, productoMenuAjustado.getPrecio());
    }

    @Test
    public void testGetNombre() {
        assertEquals("PruebaNombreAjustado", String.valueOf(this.productoMenuAjustado.getNombre()));
    }

    @Test
    public void testGenerarTextoFactura() {
        assertEquals(null, this.productoMenuAjustado.generarTextoFactura());
    }

    @Test	
    public void testGetCal() {
        assertEquals(100, this.productoMenuAjustado.getCal());
    }
    
}
