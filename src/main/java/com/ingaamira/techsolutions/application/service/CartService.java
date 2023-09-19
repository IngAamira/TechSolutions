package com.ingaamira.techsolutions.application.service;

import com.icodeapp.ecommerce.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Esta clase representa un servicio para gestionar un carrito de compras.
 */
public class CartService {

    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    /**
     * Constructor de la clase CartService. Inicializa las estructuras de datos para el carrito.
     */
    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    /**
     * Agrega un nuevo elemento al carrito.
     *
     * @param quantity    La cantidad del producto a agregar.
     * @param idProduct   El ID del producto a agregar.
     * @param nameProduct El nombre del producto a agregar.
     * @param price       El precio del producto a agregar.
     */
    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }

    /**
     * Calcula el total del carrito sumando los precios de todos los elementos.
     *
     * @return El total del carrito.
     */
    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    /**
     * Elimina un elemento del carrito por su ID de producto.
     *
     * @param idProduct El ID del producto a eliminar del carrito.
     */
    public void removeItemCart(Integer idProduct) {
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    /**
     * Elimina todos los elementos del carrito.
     */
    public void removeAllItemsCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    // Métodos internos

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart) -> itemCarts.add(itemCart)
        );
    }

    /**
     * Devuelve una lista de los elementos actuales en el carrito.
     *
     * @return Una lista de los elementos en el carrito.
     */
    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}
