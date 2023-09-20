package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Controlador para gestionar el carrito de compras del usuario.
 */
@Controller
@RequestMapping("/user/cart")
@Slf4j
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Maneja la solicitud para agregar un producto al carrito de compras.
     *
     * @param quantity    Cantidad del producto a agregar.
     * @param idProduct   ID del producto a agregar.
     * @param nameProduct Nombre del producto a agregar.
     * @param price       Precio del producto a agregar.
     * @return Redirige a la página de inicio después de agregar el producto al carrito.
     */
    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer quantity, @RequestParam Integer idProduct, @RequestParam String nameProduct, @RequestParam BigDecimal price){
        cartService.addItemCart(quantity, idProduct, nameProduct, price);
        showCart();
        return "redirect:/home";
    }

    /**
     * Muestra el contenido actual del carrito en el registro.
     */
    private void showCart() {
        cartService.getItemCarts().forEach(
                itemCart -> log.info("Item cart: {}", itemCart)
        );
    }

    /**
     * Maneja la solicitud para mostrar el contenido del carrito de compras del usuario.
     *
     * @param model       El modelo para la vista.
     * @param httpSession La sesión HTTP del usuario.
     * @return La vista que muestra el contenido del carrito de compras.
     */
    @GetMapping("/get-cart")
    public String getCart(Model model, HttpSession httpSession){
        showCart();
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total",cartService.getTotalCart());
        model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        return "user/cart/cart";
    }

    /**
     * Maneja la solicitud para eliminar un elemento del carrito de compras.
     *
     * @param id ID del producto a eliminar del carrito.
     * @return Redirige de nuevo a la página del carrito después de eliminar el elemento.
     */
    @GetMapping("/delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Integer id){
        cartService.removeItemCart(id);
        return "redirect:/user/cart/get-cart";
    }

}