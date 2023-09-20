package com.ingaamira.techsolutions.infrastructure.mapper;

import com.ingaamira.techsolutions.domain.Product;
import com.ingaamira.techsolutions.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProductMapper {
    /**
     * Convierte una entidad ProductEntity en un objeto de dominio Product.
     *
     * @param productEntity La entidad ProductEntity a convertir.
     * @return El objeto de dominio Product convertido.
     */
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    @Mapping(source = "userEntity", target = "user")
            }
    )
    Product toProduct(ProductEntity productEntity);

    /**
     * Convierte una lista de entidades ProductEntity en una lista de objetos de dominio Product.
     *
     * @param productEntities La lista de entidades ProductEntity a convertir.
     * @return La lista de objetos de dominio Product convertidos.
     */
    Iterable<Product> toProducts(Iterable<ProductEntity> productEntities);

    /**
     * Convierte un objeto de dominio Product en una entidad ProductEntity.
     *
     * @param product El objeto de dominio Product a convertir.
     * @return La entidad ProductEntity convertida.
     */
    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);

}