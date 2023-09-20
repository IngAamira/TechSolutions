package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.StockService;
import com.ingaamira.techsolutions.application.service.ValidateStock;
import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    /**
     * Muestra el historial de stock de un producto específico.
     *
     * @param id    El ID del producto.
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista que muestra el historial de stock del producto.
     */
    @GetMapping("/{id}")
    public String show (@PathVariable Integer id, Model model){
        Product product = new Product();
        product.setId(id);
        List<Stock> stocks = stockService.getStockByProduct(product);
        model.addAttribute("stocks", stocks);
        model.addAttribute("idproduct", id);
        return "admin/stock/show";
    }

    /**
     * Muestra el formulario para agregar una unidad al stock de un producto.
     *
     * @param id    El ID del producto.
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista del formulario para agregar una unidad al stock.
     */
    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id);
        return "admin/stock/create";
    }

    /**
     * Guarda la unidad agregada al stock de un producto.
     *
     * @param stock     El objeto Stock con la información a guardar.
     * @param idproduct El ID del producto al que se agrega el stock.
     * @return Redirecciona a la vista de administración de productos.
     */
    @PostMapping("/save-unit-product")
    public String save(Stock stock, @RequestParam("idproduct") Integer idproduct){
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("inventario");
        Product product = new Product();
        product.setId(idproduct);
        stock.setProduct(product);
        stockService.saveStock( validateStock.calculateBalance(stock));
        return "redirect:/admin/products/show";
    }

}