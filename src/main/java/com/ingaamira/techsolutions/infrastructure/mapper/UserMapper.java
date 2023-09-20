package com.ingaamira.techsolutions.infrastructure.mapper;

import com.ingaamira.techsolutions.domain.User;
import com.ingaamira.techsolutions.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Convierte una entidad UserEntity en un objeto de dominio User.
     *
     * @param userEntity La entidad UserEntity a convertir.
     * @return El objeto de dominio User convertido.
     */
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "firstName", target = "firstName"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "address", target = "address"),
                    @Mapping(source = "cellphone", target = "cellphone"),
                    @Mapping(source = "password", target = "password"),
                    @Mapping(source = "userType", target = "userType"),
                    @Mapping(source = "dateCreated", target = "dateCreated")
            }
    )
    User toUser(UserEntity userEntity);

    /**
     * Convierte una lista de entidades UserEntity en una lista de objetos de dominio User.
     *
     * @param userEntities La lista de entidades UserEntity a convertir.
     * @return La lista de objetos de dominio User convertidos.
     */
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    /**
     * Convierte un objeto de dominio User en una entidad UserEntity.
     *
     * @param user El objeto de dominio User a convertir.
     * @return La entidad UserEntity convertida.
     */
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}