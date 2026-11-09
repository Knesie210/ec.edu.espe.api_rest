package ec.edu.espe.api_rest.exception;

// Importaciones
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Controlador global para la captura centralizada de excepciones
@RestControllerAdvice
public class ApiExceptionHandler {

    // Manejador de excepción para recurso no encontrado (HTTP 404)
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity < Map < String, String > > noEncontrado(ProductoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(ProductoInvalidoException.class)
    public ResponseEntity < Map < String , String > > manejarDatoInvalido(ProductoInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }
}