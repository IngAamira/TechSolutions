package com.ingaamira.techsolutions.infrastructure.mapper;

import com.ingaamira.techsolutions.domain.OrderProduct;
import com.ingaamira.techsolutions.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderProductMapper {
    /**
     * Convierte una entidad de OrderProductEntity en un objeto de dominio OrderProduct.
     *
     * @param orderProductEntity La entidad OrderProductEntity a convertir.
     * @return El objeto de dominio OrderProduct convertido.
     */
    @Mappings(
            {
                    @Mapping(source = "pk.productEntity", target = "product"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "pk.orderEntity", target = "order"),
            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);

    /**
     * Convierte una lista de entidades OrderProductEntity en una lista de objetos de dominio OrderProduct.
     *
     * @param orderProductEntities La lista de entidades OrderProductEntity a convertir.
     * @return La lista de objetos de dominio OrderProduct convertidos.
     */
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities);

    /**
     * Convierte una lista de entidades OrderProductEntity en una lista de objetos de dominio OrderProduct.
     *
     * @param orderProductEntities La lista de entidades OrderProductEntity a convertir.
     * @return La lista de objetos de dominio OrderProduct convertidos.
     */
    List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities);

    /**
     * Convierte un objeto de dominio OrderProduct en una entidad OrderProductEntity.
     *
     * @param orderProduct El objeto de dominio OrderProduct a convertir.
     * @return La entidad OrderProductEntity convertida.
     */
    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
