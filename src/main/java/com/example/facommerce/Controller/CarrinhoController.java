package com.example.facommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.DTO.AddItemDTO;
import com.example.facommerce.Model.ItemCarrinho;
import com.example.facommerce.Service.CarrinhoService;
import com.example.facommerce.Service.CookieService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/carrinho")
@SessionAttributes("carrinhoId")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping
    public ModelAndView carrinho(HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("carrinho");

        //String carrinhoId = carrinhoService.buscarCarrinhoId(CookieService.getCookie("usuarioId"));

        List<ItemCarrinho> itens = List.of();
        mv.addObject("itens", itens);
        mv.addObject("total", 1);
        return mv;
    }

    @PostMapping("/add")
    public String adicionarItem(@RequestBody AddItemDTO addItemDTO) {
        //Long carrinhoId = (Long) session.getAttribute("carrinhoId");
        System.err.println(addItemDTO.getProdutoId() + " " + addItemDTO.getQuantidade() + " " + addItemDTO.getCarrinhoId());
        carrinhoService.adicionarItem(addItemDTO);
        return "redirect:/carrinho";
    }
}
