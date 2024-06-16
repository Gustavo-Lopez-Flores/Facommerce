package com.example.facommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.facommerce.produtos.Produto;
import com.example.facommerce.produtos.ProdutoService;

@Controller
public class HomeController {

    @Autowired
    private ProdutoService produtoService;

    public HomeController(ProdutoService produtoService) {
        this.produtoService = produtoService;

        if(produtoService.listarTodos().spliterator().getExactSizeIfKnown() == 0) {
            produtoService.cadastrar(new Produto("Notebook Gamer Acer Nitro V15 ANV15-51-57WS i5 13ªGen 8GB RAM 512GB SSD RTX3050 15.6' FHD Linux Gutta", 3899, "Notebooks", "https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fcdn.discordapp.com%2Fattachments%2F1200269957083189268%2F1250474358699200572%2Fimage-removebg-preview_11.png%3Fex%3D666b127f%26is%3D6669c0ff%26hm%3D5d4797574c9810d7cb672238c490872d1daad9c8552d883f840804a3cc91083c%26&w=1080&q=75"));
            produtoService.cadastrar(new Produto("Notebook Predator Helios Neo PHN16-71-72W6 Ci7 13° Windows 11 Home 16GB 512GB SSD RTX 4060 16 WUXGA", 7899, "Notebooks", "https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fmedia.discordapp.net%2Fattachments%2F966771498956234762%2F1225192480429969418%2F1000036245-removebg-preview.png%3Fex%3D66203c6a%26is%3D660dc76a%26hm%3Db2553f149fadead3b4430f98ff7b39cd2cc69944d93fc9dd9c2bf6ade6210fc1%26&w=1080&q=75"));
            produtoService.cadastrar(new Produto("Notebook Galaxy Book4 Pro", 5736.74f, "Notebooks", "https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fimages.samsung.com%2Fis%2Fimage%2Fsamsung%2Fp6pim%2Fbr%2Fnp940xgk-kg1br%2Fgallery%2Fbr-galaxy-book4-pro-14-inch-np940-np940xgk-kg1br-541201711%3F%24365_292_PNG%24&w=640&q=75"));
            produtoService.cadastrar(new Produto("Notebook Lenovo LOQ I5-12450H 3050 6GB 16GB RAM 512GB SSD 15.6\" FHD Linux", 4073.99f, "Notebooks", "https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fmedia.discordapp.net%2Fattachments%2F966771498956234762%2F1208109808641908786%2FcjpAEEEEAAAasA4WcVox4BBBBAwL0A4edhDSAAAIIIGAVIPysYtQjgAACCLgXIPzcj5AGEEAAAQSsAoSfVYx6BBBAAAH3AoSfxHSAAIIIICAVYDws4pRjwACCCDgXoDwcz9CGkAAAQQQsAoQflYx6hFAAAEE3AsQfu5HSAMIIIAAAlaBfwD5OigQ4lRxIAAAAABJRU5ErkJggg.png%3Fex%3D65e216ef%26is%3D65cfa1ef%26hm%3D2eb5d03cc3f8b2b82bca56da89565a61381631cfb830a72eb8dba6884b6b5040%26%3D%26format%3Dwebp%26quality%3Dlossless&w=640&q=75"));
        }
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
