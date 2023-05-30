package prueba;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ProductoMenu;

public class ProductoMenuTest {

    private ProductoMenu productoMenu;

    @BeforeEach
    public void setUp() throws Exception {
        productoMenu = new ProductoMenu("PruebaNombre", 100, 100);
    }
	
    @Test
    public void testGetPrecio() {
        assertEquals(100, productoMenu.getPrecio());
        
    }

    @Test
    public void testGetNombre() {
        assertEquals("PruebaNombre",productoMenu.getNombre());
        
    }

    @Test
    public void testGenerarTextoFactura() {
        assertEquals(null, this.productoMenu.generarTextoFactura());
    }

    @Test
    public void testGetCal() {
        assertEquals(100, this.productoMenu.getCal());
    }
    
}
