package model;

public class ProductoMayor150 extends HamburguesaException {

    public ProductoMayor150(String m) {
        super(m);
        System.out.println("El pedido no puede superar los $150000");
    }
    
}
