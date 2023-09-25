package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.ProductService;
import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * Controlador para manejar las funcionalidades relacionadas con los productos en el panel de administración.
 */
@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Muestra la vista para crear un nuevo producto.
     *
     * @return La vista para crear un nuevo producto.
     */
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }

    /**
     * Guarda un nuevo producto en la base de datos.
     *
     * @param product      El producto a ser guardado.
     * @param multipartFile El archivo de imagen asociado al producto.
     * @param httpSession  La sesión HTTP del usuario.
     * @return Redirige al usuario a la página de administración después de guardar el producto.
     * @throws IOException Si ocurre un error al manejar el archivo de imagen.
     */
    @PostMapping("/save-product")
    public String saveProduct(Product product, @RequestParam("img") MultipartFile multipartFile, HttpSession httpSession ) throws IOException {
        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product, multipartFile, httpSession);
        return "redirect:/admin";
    }

    /**
     * Muestra una lista de productos asociados al usuario administrador.
     *
     * @param model       El modelo para la vista.
     * @param httpSession La sesión HTTP del usuario.
     * @return La vista que muestra la lista de productos.
     */
    @GetMapping("/show")
    public String showProduct(Model model, HttpSession httpSession){
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());

        User user = new User();
        user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }

    /**
     * Muestra la vista para editar un producto existente.
     *
     * @param id    El ID del producto a editar.
     * @param model El modelo para la vista.
     * @return La vista para editar un producto.
     */
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product",product);
        return "admin/products/edit";
    }

    /**
     * Elimina un producto de la base de datos.
     *
     * @param id El ID del producto a eliminar.
     * @return Redirige al usuario a la lista de productos después de eliminar el producto.
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin/products/show";
    }

}