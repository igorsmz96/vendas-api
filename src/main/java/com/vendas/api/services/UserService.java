package com.vendas.api.services;

import com.vendas.api.controllers.request.AddressRequest;
import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.controllers.response.UserResponse;
import com.vendas.api.entities.Address;
import com.vendas.api.entities.User;
import com.vendas.api.mapper.AddressMapper;
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
    private final AddressMapper addressMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, AddressMapper addressMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
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

    public UserResponse updateUser(Long id, UserRequest request) {
        Optional<User> op = userRepository.findById(id);

        if (op.isPresent()) {
            User user = op.get();

            user.setName(request.name());
            user.setEmail(request.email());
            user.setPhone(request.phone());
            user.setPassword(request.password());

            user.getAddresses().clear();

            if (request.addresses() != null) {

                for (AddressRequest addressRequest : request.addresses()) {

                    Address address = addressMapper.toAddress(addressRequest);
                    address.setUser(user);
                    user.getAddresses().add(address);

                }
            }

            userRepository.save(user);
            return userMapper.toResponse(user);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario com o id: " + id + "nao encontrado");


        }

    }

    public UserResponse updatePartial(Long id, UserRequest request) {
        Optional<User> op = userRepository.findById(id);

        if (op.isPresent()) {
            User user = op.get();

            Optional.ofNullable(request.name()).ifPresent(name -> user.setName(name));
            Optional.ofNullable(request.email()).ifPresent(email -> user.setEmail(email));
            Optional.ofNullable(request.phone()).ifPresent(phone -> user.setPhone(phone));
            Optional.ofNullable(request.password()).ifPresent(password -> user.setPassword(password));

            if (request.addresses() != null) {
                for (AddressRequest addressRequest : request.addresses()) {
                    Address address = addressMapper.toAddress(addressRequest);
                    address.setUser(user);
                    user.getAddresses().add(address);
                }
            }
            userRepository.save(user);
            return userMapper.toResponse(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario com o id: " + id + "nao encontrado");
        }


    }


}
