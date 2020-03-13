package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var mensaje = "Mensaje con Thymeleaf";
        
        var persona = new Persona();
        persona.setNombre("Alexis");
        persona.setApellido("Martínez");
        persona.setEmail("a_martinez@mail.com");
        persona.setTelefono("2841009117");
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        
        model.addAttribute("persona", persona);
        return "index";
    }
}
