package model;

public class ProductoRepetidoException extends HamburguesaException{

    public ProductoRepetidoException(String m) {
        super(m);
        System.out.println("No se puede agregar el mismo producto dos veces");
    }
    
}
