package prueba;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Pedido;
import model.ProductoMenu;
import model.ProductoMayor150;


public class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    public void setUp() throws Exception {
        pedido = new Pedido("Santiago", "Calle 69");
    }
    
    @Test
    public void testGetIdPedido() {
        pedido.setId(1);
        assertEquals(1, pedido.getIdPedido());
    }

    @Test
    public void testAgregarProductoExcepcion() {
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 151000, 100);
        assertThrows(ProductoMayor150.class, () -> pedido.agregarProducto(productoMenu));
    }

    @Test
    public void testGetProductos() throws ProductoMayor150 {
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        ArrayList<ProductoMenu> items = new ArrayList<ProductoMenu>();
        items.add(productoMenu);
        assertEquals(items, pedido.getProductos());
    }

    @Test
    public void testGetNombreCliente() {
        assertEquals("Santiago", pedido.getNombreCliente());
    }

    @Test
    public void testGetDireccionCliente() {
        assertEquals("Calle 69", pedido.getDireccionCliente());
    }

    @Test
    public void testGetPrecioNeto() throws ProductoMayor150 {
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        assertEquals(140000, pedido.getPrecioNetoPedido());
    }

    @Test
    public void testGetPrecioTotal() throws ProductoMayor150 {
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        assertEquals(166600, pedido.getPrecioTotalPedido());
    }

    @Test
    public void testGetCal() throws ProductoMayor150{
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        assertEquals(100, pedido.getTotalCalorias());
    }

    @Test
    public void testGetPrecioIva() throws ProductoMayor150{
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        assertEquals(26600, pedido.getPrecioIVAPedido());
    }

    @Test
    public void testGenerarTextoFactura() throws ProductoMayor150{
        ProductoMenu productoMenu = new ProductoMenu("PruebaNombre", 140000, 100);
        pedido.agregarProducto(productoMenu);
        pedido.setId(0);
        String msj = "Pedido #" + 0;
		msj += "\n";
		msj += "Nombre: " + "Santiago";
		msj += "\n";
		msj += "Dirección: " + "Calle 69";
		msj += "\n";
		msj += "\n";
		msj += "PRODUCTOS";
		msj += "\n";
		
        msj += 1 + ". " + "PruebaNombre" + " || $" + 140000.0 + " || cal:" + 100;
        msj += "\n";
		
		msj += "\n";
		msj += "IVA: $" + 26600.0;
		msj += "\n";
		msj += "Total Neto: $" + 140000.0;
		msj += "\n";
		msj += "Total Pedido: $" + 166600.0;
		msj += "\n";
		msj += "Total calorias: " + 100;
		msj += "\n";

        assertEquals(msj, pedido.generarTextoFacura());

    }
    
}
