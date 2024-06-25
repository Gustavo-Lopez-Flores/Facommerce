package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.DTO.LoginDTO;
import com.example.facommerce.Model.TipoUsuario;
import com.example.facommerce.Model.Usuario;
import com.example.facommerce.Service.CookieService;
import com.example.facommerce.Service.UsuarioService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView logar(@ModelAttribute LoginDTO loginDTO, boolean lembrar, HttpServletResponse response) {
        Usuario usuario = usuarioService.login(loginDTO.getEmail(), loginDTO.getSenha());
        if (usuario != null) {
            int maxAge = lembrar ? 60 * 60 * 24 * 30 : 60 * 60;
            boolean ehAdmin = usuario.getTipoUsuario().equals(TipoUsuario.ADMIN);
            CookieService.setCookie(response, "usuarioId", usuario.getCpf(), maxAge);
            CookieService.setCookie(response, "tipoUsuario", ehAdmin  ? "ADMIN" : "CLIENTE", maxAge);
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        CookieService.setCookie(response, "usuarioId", "", 0);
        CookieService.setCookie(response, "tipoUsuario", "", 0);
        return "redirect:/login";
    }
}