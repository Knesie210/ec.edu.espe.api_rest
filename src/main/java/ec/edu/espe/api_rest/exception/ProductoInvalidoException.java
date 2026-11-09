package ec.edu.espe.api_rest.exception;

// Excepción personalizada para errores de reglas de negocio
public class ProductoInvalidoException extends RuntimeException {

    // Inicializar constructor de la excepción
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}