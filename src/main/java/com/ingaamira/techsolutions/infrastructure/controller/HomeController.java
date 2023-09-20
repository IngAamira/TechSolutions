package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.ProductService;
import com.ingaamira.techsolutions.application.service.StockService;
import com.ingaamira.techsolutions.domain.Stock;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controlador para gestionar la página principal y los detalles de los productos.
 */
@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {
    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    /**
     * Maneja la solicitud para mostrar la página de inicio con la lista de productos.
     *
     * @param model       El modelo para la vista.
     * @param httpSession La sesión HTTP del usuario.
     * @return La vista de la página de inicio.
     */
    @GetMapping
    public String home(Model model, HttpSession httpSession){
        model.addAttribute("products", productService.getProducts());
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        } catch (Exception e){

        }
        return "home";
    }

    /**
     * Maneja la solicitud para mostrar los detalles de un producto específico.
     *
     * @param id          ID del producto para mostrar detalles.
     * @param model       El modelo para la vista.
     * @param httpSession La sesión HTTP del usuario.
     * @return La vista que muestra los detalles del producto.
     */
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model, HttpSession httpSession){
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));
        log.info("Id product: {}", id);
        log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size()-1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        } catch (Exception e){

        }
        return "user/productdetail";
    }

}