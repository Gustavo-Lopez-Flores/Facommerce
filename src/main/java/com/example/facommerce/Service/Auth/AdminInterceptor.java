package com.example.facommerce.Service.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.facommerce.Service.CookieService;
import com.example.facommerce.Service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private UsuarioService usuarioService;
    
    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cpf = CookieService.getCookie(request, "usuarioId");
        if (cpf != null && usuarioService.ehAdmin(cpf)) {           
            return true;
        }
        response.sendRedirect("/");
        return false;
    }
}