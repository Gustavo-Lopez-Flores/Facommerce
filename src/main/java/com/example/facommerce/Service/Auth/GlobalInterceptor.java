package com.example.facommerce.Service.Auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.Service.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @SuppressWarnings("null")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
        if (modelAndView == null) {
            return;
        }

        if (CookieService.getCookie(request, "usuarioId") != null) {
            modelAndView.addObject("usuarioId", CookieService.getCookie(request, "usuarioId"));
            modelAndView.addObject("tipoUsuario", CookieService.getCookie(request, "tipoUsuario"));
        }
    }
}