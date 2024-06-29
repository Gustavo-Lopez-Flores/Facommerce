package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.DTO.CadastroProdutoDTO;
import com.example.facommerce.Service.CategoriaService;
import com.example.facommerce.Service.ProdutoService;

@Controller
@RequestMapping("/admin")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("produtos")
    public String listar() {
        return "redirect:/";
    }

    @GetMapping("produtos/cadastrar")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("categorias", categoriaService.listarTodas());
        return mv;
    }

    @PostMapping("produtos/cadastrar")
    public String cadastrar(CadastroProdutoDTO cadastro) {
        produtoService.cadastrar(cadastro);
        return "redirect:/admin/produtos";
    }
}
