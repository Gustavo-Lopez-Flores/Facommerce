package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.Model.Categoria;
import com.example.facommerce.Model.Produto;
import com.example.facommerce.Service.CategoriaService;
import com.example.facommerce.Service.ProdutoService;

@Controller
@SessionAttributes({"usuarioId", "tipoUsuario"})
public class HomeController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    public HomeController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("produtos", produtoService.listarTodos());
        // Adiciona usuarioId e tipoUsuario ao modelo, se não estiverem presentes
        if (!model.containsAttribute("usuarioId")) {
            model.addAttribute("usuarioId", null);
        }
        if (!model.containsAttribute("tipoUsuario")) {
            model.addAttribute("tipoUsuario", null);
        }
        return mv;
    }
    
    @GetMapping("/produto/{id}")
    public ModelAndView produto(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("product-details");
        mv.addObject("produto", produtoService.buscarPorId(id));
        return mv;
    }
}