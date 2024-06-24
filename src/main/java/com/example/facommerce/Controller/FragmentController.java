package com.example.facommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"usuarioId", "tipoUsuario"})
public class FragmentController {
    
    @GetMapping("/fragments/general")
    public String header(Model model) {
        if (!model.containsAttribute("usuarioId")) {
            model.addAttribute("usuarioId", null);
        }
        if (!model.containsAttribute("tipoUsuario")) {
            model.addAttribute("tipoUsuario", null);
        }
        return "fragments/general.html";
    }
}