package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.*;
import com.ingaamira.techsolutions.domain.*;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*HttpSession*/

/**
 * Controlador para manejar las funcionalidades relacionadas con las órdenes de compra del usuario.
 */
@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderControler {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validateStock;
    private final Integer UNIT_IN = 0;

    public OrderControler(CartService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

/*    *//**
     * Muestra un resumen de la orden de compra para el usuario.
     *
     * @param model       El modelo para la vista.
     //* @param httpSession La sesión HTTP del usuario.
     * @return La vista que muestra el resumen de la orden.
     *//*
    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model, HttpSession httpSession){
        log.info("id user desde la variable de session: {}", httpSession.getAttribute("iduser").toString());
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        return "user/sumaryorder";
    }*/
    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
        User user = userService.findById(1);
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        return "user/sumaryorder";
    }

    /**
     * Crea una nueva orden de compra a partir de los elementos en el carrito del usuario.
     *
     * @param attributes  Atributos para agregar información adicional en la redirección.
     * @param httpSession La sesión HTTP del usuario.
     * @return Redirige al usuario a la página de inicio después de crear la orden.
     */
    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes, HttpSession httpSession){
        log.info("create order..");
        log.info("id user desde la variable de session: {}", httpSession.getAttribute("iduser").toString());

        // Obtener usuario temporal
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));

        // Crear orden
        Order order = new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);

        order = orderService.createOrder(order);

        // Crear productos de orden
        List<OrderProduct> orderProducts = new ArrayList<>();

        // Convertir elementos de carrito en productos de orden
        for (ItemCart itemCart : cartService.getItemCarts()){
            orderProducts.add(new OrderProduct(productService.getProductById(itemCart.getIdProduct()), itemCart.getQuantity(), order));
        }

        // Guardar productos de orden
        orderProducts.forEach(op -> {
            orderProductService.create(op);
            Stock stock = new Stock();
            stock.setDateCreated(LocalDateTime.now());
            stock.setProduct(op.getProduct());
            stock.setDescription("venta");
            stock.setUnitIn(UNIT_IN);
            stock.setUnitOut(op.getQuantity());
            stockService.saveStock(validateStock.calculateBalance(stock));
        });

        // Vaciar el carrito
        cartService.removeAllItemsCart();
        attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString());
        return "redirect:/home";
    }

}