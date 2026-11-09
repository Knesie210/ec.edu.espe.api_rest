package ec.edu.espe.api_rest.config;

// Importaciones
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ec.edu.espe.api_rest.interceptor.RegistroHttpInterceptor;

// Configuración Web MVC para registrar interceptores
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Declaración de variables y dependencias
    private final RegistroHttpInterceptor registro;

    // Inicializar constructor (Inyección de dependencias)
    public WebConfig(RegistroHttpInterceptor registro) {
        this.registro = registro;
    }

    // Registro del interceptor para rutas /api/**
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(registro).addPathPatterns("/api/**");
    }
}