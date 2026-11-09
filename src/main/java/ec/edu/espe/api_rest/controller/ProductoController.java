package ec.edu.espe.api_rest.controller;

// Importaciones
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.edu.espe.api_rest.model.Producto;
import ec.edu.espe.api_rest.service.ProductoService;

// Controlador REST para gestionar la API de productos
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Declaración de variables y dependencias
    private final ProductoService service;

    // Inicializar constructor (Inyección de dependencias por constructor)
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // Endpoint GET: Listar productos (HTTP 200 OK)
    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    // Endpoint GET: Obtener producto por identificador (HTTP 200 OK / 404 Not Found)
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Endpoint POST: Registrar un nuevo producto (HTTP 201 Created / 400 Bad Request)
    @PostMapping
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto) {
        Producto creado = service.agregar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // Endpoint DELETE: Eliminar un producto (HTTP 204 No Content / 404 Not Found)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}