package prueba;


import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

public class ComboTest {

    private Combo combito;
    private ProductoMenu productoMenu;
    ArrayList<Producto> items;

    @BeforeEach
    public void setUp() throws Exception {
        combito = new Combo("PruebaCombo", 10);
        productoMenu = new ProductoMenu("PruebaNombre", 151000, 100);
    }

    @Test
    public void testGetPrecio() {
        combito = new Combo("PruebaCombo", 10);
        assertEquals(10, combito.getPrecio());
    }

    @Test
    public void testGetItems() {
        items = new ArrayList<Producto>();
        items.add(productoMenu);
        combito.agregarItemACombo(productoMenu);
        assertEquals(items, combito.getItems());
    }

    @Test
    public void testGetNombre() {
        productoMenu = new ProductoMenu("PruebaNombre", 100, 100);
        assertEquals("PruebaCombo", this.combito.getNombre());
    }

    @Test
    public void testGenerarTextoFactura() {
        assertEquals(null, this.productoMenu.generarTextoFactura());
    }

    @Test
    public void testGetCal() {
        combito.agregarItemACombo(productoMenu);
        assertEquals(100, this.combito.getCal());
    }
    
    @Test
    public void testGenerarFactura() {
        assertEquals(null, this.combito.generarTextoFactura());
    }
    
   
    
}
