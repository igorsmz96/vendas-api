package com.vendas.api.services;

import com.vendas.api.entities.Address;
import com.vendas.api.entities.User;
import com.vendas.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user){

        if (user.getAddresses() != null){

            for(Address address : user.getAddresses()){
                address.setUser(user);

            }
        }
        return userRepository.save(user);
    }

    public List<User> findAll(){

        return userRepository.findAll();
    }


}
