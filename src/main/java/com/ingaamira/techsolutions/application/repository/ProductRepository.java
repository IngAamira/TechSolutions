package com.ingaamira.techsolutions.application.repository;

import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.User;

/**
 * Esta interfaz define las operaciones para acceder a los productos en el repositorio.
 */
public interface ProductRepository {

    /**
     * Obtiene todos los productos almacenados en el repositorio.
     *
     * @return Una colección de productos.
     */
    Iterable<Product> getProducts();

    /**
     * Obtiene todos los productos asociados a un usuario específico.
     *
     * @param user El usuario para el cual se quieren obtener los productos.
     * @return Una colección de productos asociados al usuario dado.
     */
    Iterable<Product> getProductsByUser(User user);

    /**
     * Obtiene un producto por su ID.
     *
     * @param id El ID del producto a obtener.
     * @return El producto correspondiente al ID dado, o null si no se encuentra.
     */
    Product getProductById(Integer id);

    /**
     * Guarda un producto en el repositorio.
     *
     * @param product El producto a guardar.
     * @return El producto guardado.
     */
    Product saveProduct(Product product);

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    void deleteProductById(Integer id);

}
