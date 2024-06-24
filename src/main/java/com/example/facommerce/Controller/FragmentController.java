package com.example.facommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {
    @GetMapping("/fragments/general")
    public String header() {
        return "/fragments/general.html";
    }
}