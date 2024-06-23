package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.Model.Categoria;
import com.example.facommerce.Model.Produto;
import com.example.facommerce.Service.CategoriaService;
import com.example.facommerce.Service.ProdutoService;

@Controller
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
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("produtos", produtoService.listarTodos());
        return mv;
    }
    
    @GetMapping("/produto/{id}")
    public ModelAndView produto(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("product-details");
        mv.addObject("produto", produtoService.buscarPorId(id));
        return mv;
    }
}
