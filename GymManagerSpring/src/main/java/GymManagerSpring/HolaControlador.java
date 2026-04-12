package GymManagerSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaControlador {

    @GetMapping("/hola")
    public String hola() {
        return "¡Spring Boot funcionando!";
    }
}