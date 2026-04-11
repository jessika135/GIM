package GymManagerSpring.controlador;

import GymManagerSpring.modelo.Cliente;
import GymManagerSpring.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

/**
 * Controlador principal de Clientes
 * Maneja las peticiones GET y POST
 */
@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteRepositorio repositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", repositorio.findAll());
        return "clientes/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        cliente.setEstado("Activo");
        cliente.setFechaInscripcion(new Date());
        repositorio.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        repositorio.deleteById(id);
        return "redirect:/clientes";
    }
}