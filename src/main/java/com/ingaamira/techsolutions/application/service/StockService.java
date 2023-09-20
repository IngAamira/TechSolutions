package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.application.repository.StockRepository;
import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase proporciona métodos para manejar el inventario de productos en la aplicación.
 */
@Service
public class StockService {
    private final StockRepository stockRepository;

    /**
     * Constructor de la clase StockService.
     *
     * @param stockRepository El repositorio de inventario utilizado para acceder a los datos del inventario.
     */
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * Guarda un registro de inventario en el repositorio.
     *
     * @param stock El registro de inventario a guardar.
     * @return El registro de inventario guardado.
     */
    public Stock saveStock(Stock stock) {
        return stockRepository.saveStock(stock);
    }

    /**
     * Obtiene una lista de registros de inventario asociados a un producto específico.
     *
     * @param product El producto para el cual se quieren obtener los registros de inventario.
     * @return Una lista de registros de inventario asociados al producto dado.
     */
    public List<Stock> getStockByProduct(Product product) {
        return stockRepository.getStockByProduct(product);
    }

}
