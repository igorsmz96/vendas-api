package com.vendas.api.services;

import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.controllers.response.UserResponse;
import com.vendas.api.entities.User;
import com.vendas.api.mapper.UserMapper;
import com.vendas.api.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toResponse(user);


    }

    public List<User> findAll() {

        return userRepository.findAll();
    }


}
