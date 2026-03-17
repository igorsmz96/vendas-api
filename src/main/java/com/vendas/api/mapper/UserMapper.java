package com.vendas.api.mapper;

import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;

    public  User toUser(UserRequest request){

       User user = User.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .password(request.password())
                .build();

       if (request.address() != null){
           user.getAddresses().add(addressMapper.toAddress(request.address()));
       }

       return user;

    }
}
