package com.example.facommerce.Service.Auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.Service.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (CookieService.getCookie(request, "usuarioId") != null) {           
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (CookieService.getCookie(request, "usuarioId") != null) {
            modelAndView.addObject("usuarioId", CookieService.getCookie(request, "usuarioId"));
        }
    }
}