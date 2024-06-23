package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facommerce.DTO.CadastroDTO;
import com.example.facommerce.Service.UsuarioService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping
    public String cadastrar(CadastroDTO cadastro) {
        usuarioService.cadastrar(cadastro);

        return "redirect:/login";
    }
}
