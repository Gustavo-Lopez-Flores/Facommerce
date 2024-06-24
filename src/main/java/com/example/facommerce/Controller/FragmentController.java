package com.example.facommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"usuarioId", "tipoUsuario"})
public class FragmentController {

    @GetMapping("/fragments/general")
    public String header(@SessionAttribute("usuarioId") String usuarioId, @SessionAttribute("tipoUsuario") String tipoUsuario) {
        return "/fragments/general.html";
    }
}