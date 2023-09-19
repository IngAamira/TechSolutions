package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.application.repository.UserRepository;
import com.ingaamira.techsolutions.domain.User;
import com.ingaamira.techsolutions.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * Esta clase implementa la interfaz UserRepository y proporciona acceso a los datos de usuarios en la base de datos.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }

}
