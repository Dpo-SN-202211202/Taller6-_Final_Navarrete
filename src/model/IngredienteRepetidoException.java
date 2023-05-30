package model;

public class IngredienteRepetidoException extends HamburguesaException{

    public IngredienteRepetidoException(String m) {
        super(m);
        System.out.println("No se puede agregar el mismo ingrediente dos veces");
        
    }
    
}
