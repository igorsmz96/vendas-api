package com.vendas.api.services;

import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.controllers.response.UserResponse;
import com.vendas.api.entities.User;
import com.vendas.api.mapper.UserMapper;
import com.vendas.api.repositories.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


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

    public List<UserResponse> findAll() {

        List <User> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponse).toList();
    }

    public UserResponse findById(Long id){
        Optional <User> op = userRepository.findById(id);

        if(op.isPresent()){
            return userMapper.toResponse(op.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario com o id: " +id+ "nao encontrado");
        }
    }

    public void deleteById(Long id){
        Optional <User> op = userRepository.findById(id);

        if (op.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario com o id: " +id+ "nao encontrado");
        }

    }


}
