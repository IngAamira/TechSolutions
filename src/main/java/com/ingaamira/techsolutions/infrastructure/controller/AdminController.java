package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.ProductService;
import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para las funciones de administración.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Maneja la solicitud para la página de inicio del panel de administración.
     *
     * @param model El modelo para la vista.
     * @return La vista de la página de inicio del panel de administración.
     */
    @GetMapping
    public String home(Model model){
        User user = new User();
        user.setId(1);
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/home";
    }

}
