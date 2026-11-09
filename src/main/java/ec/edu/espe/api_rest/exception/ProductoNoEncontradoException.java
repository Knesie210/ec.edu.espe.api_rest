package ec.edu.espe.api_rest.exception;



// Excepción personalizada para recursos inexistentes
public class ProductoNoEncontradoException extends RuntimeException {

    // Inicializar constructor de la excepción
    public ProductoNoEncontradoException(Long id) {
        super("No existe el producto con id " + id);
    }
}