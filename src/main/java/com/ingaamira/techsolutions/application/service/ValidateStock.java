package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase proporciona métodos para validar y calcular el saldo del inventario de productos.
 */
@Service
public class ValidateStock {
    private final StockService stockService;

    /**
     * Constructor de la clase ValidateStock.
     *
     * @param stockService El servicio de inventario utilizado para acceder a los datos de inventario.
     */
    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Verifica si existe saldo en el inventario para un producto específico.
     *
     * @param product El producto para el cual se quiere verificar el saldo.
     * @return `true` si existe saldo en el inventario, `false` si no.
     */
    private boolean existBalance(Product product) {
        List<Stock> stockList = stockService.getStockByProduct(product);
        return !stockList.isEmpty();
    }

    /**
     * Calcula y actualiza el saldo del inventario de acuerdo a las unidades de entrada o salida.
     *
     * @param stock El registro de inventario al que se le calcula el saldo.
     * @return El registro de inventario actualizado con el saldo calculado.
     */
    public Stock calculateBalance(Stock stock) {
        if (stock.getUnitIn() != 0) {
            if (existBalance(stock.getProduct())) {
                List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getUnitIn());
            } else {
                stock.setBalance(stock.getUnitIn());
            }
        } else {
            List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getUnitOut());
        }
        return stock;
    }

}
