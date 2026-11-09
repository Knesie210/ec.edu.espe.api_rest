package ec.edu.espe.api_rest.interceptor;

// Importaciones
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// Interceptor para el registro de peticiones HTTP en consola
@Component
public class RegistroHttpInterceptor implements HandlerInterceptor {

    // Método que se ejecuta antes de procesar la petición
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("[HTTP] " + request.getMethod() + " " + request.getRequestURI());
        return true;
    }
}