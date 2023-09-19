package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.application.repository.StockRepository;
import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.domain.Stock;
import com.ingaamira.techsolutions.infrastructure.mapper.ProductMapper;
import com.ingaamira.techsolutions.infrastructure.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase implementa la interfaz StockRepository y proporciona acceso a los datos de registros de stock en la base de datos.
 */
@Service
public class StockRepositoryImpl implements StockRepository {

    private final StockCrudRepository stockCrudRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockMapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }

}
