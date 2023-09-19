package com.ingaamira.techsolutions.infrastructure.mapper;

import com.ingaamira.techsolutions.domain.Stock;
import com.ingaamira.techsolutions.infrastructure.entity.StockEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StockMapper {
    /**
     * Convierte una entidad StockEntity en un objeto de dominio Stock.
     *
     * @param stockEntity La entidad StockEntity a convertir.
     * @return El objeto de dominio Stock convertido.
     */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "unitIn", target = "unitIn"),
            @Mapping(source = "unitOut", target = "unitOut"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "balance", target = "balance"),
            @Mapping(source = "productEntity", target = "product")
    })
    Stock toStock(StockEntity stockEntity);

    /**
     * Convierte una lista de entidades StockEntity en una lista de objetos de dominio Stock.
     *
     * @param stockEntities La lista de entidades StockEntity a convertir.
     * @return La lista de objetos de dominio Stock convertidos.
     */
    List<Stock> toStocks(List<StockEntity> stockEntities);

    /**
     * Convierte un objeto de dominio Stock en una entidad StockEntity.
     *
     * @param stock El objeto de dominio Stock a convertir.
     * @return La entidad StockEntity convertida.
     */
    @InheritInverseConfiguration
    StockEntity toStockEntity(Stock stock);

}
