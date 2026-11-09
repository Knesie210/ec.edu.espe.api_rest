package ec.edu.espe.api_rest.service;

// Importaciones
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ec.edu.espe.api_rest.model.Producto;
import ec.edu.espe.api_rest.exception.ProductoNoEncontradoException;
import ec.edu.espe.api_rest.exception.ProductoInvalidoException;

// Capa de servicio para la lógica de negocio
@Service
public class ProductoService {

    // Inicialización de variables / Colección en memoria
    private final List<Producto> productos = new ArrayList<>(List.of(
        new Producto(1L, "Laptop", 850.00, 10),
        new Producto(2L, "Mouse", 18.50, 25),
        new Producto(3L, "Teclado", 35.00, 15)
    ));

    // Método para listar todos los productos
    public synchronized List<Producto> listar() {
        return List.copyOf(productos);
    }

    // Método para buscar un producto por identificador
    public synchronized Producto buscarPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    // Método para agregar un producto validando reglas de negocio
    public synchronized Producto agregar(Producto producto) {
        // Validaciones de negocio
        if (producto.getId() == null || producto.getId() <= 0) {
            throw new ProductoInvalidoException("El id debe ser un número positivo");
        }
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new ProductoInvalidoException("El nombre del producto es obligatorio");
        }
        if (producto.getPrecio() <= 0) {
            throw new ProductoInvalidoException("El precio debe ser mayor a cero");
        }
        if (producto.getStock() < 0) {
            throw new ProductoInvalidoException("El stock no puede ser negativo");
        }
        if (productos.stream().anyMatch(p -> p.getId().equals(producto.getId()))) {
            throw new ProductoInvalidoException("Ya existe un producto con el id " + producto.getId());
        }

        // Agregar elemento a la lista
        productos.add(producto);
        return producto;
    }

    // Método para eliminar un producto por identificador
    public synchronized void eliminar(Long id) {
        // Verifica existencia antes de eliminar
        Producto producto = buscarPorId(id);
        productos.remove(producto);
    }
}