package com.vendas.api.mapper;

import com.vendas.api.controllers.request.AddressRequest;
import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.controllers.response.AddressResponse;
import com.vendas.api.controllers.response.UserResponse;
import com.vendas.api.entities.Address;
import com.vendas.api.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;

    public User toUser(UserRequest request) {

        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setPassword(request.password());


        if (request.addresses() != null) {

            for (AddressRequest ar : request.addresses()) {

                Address address = addressMapper.toAddress(ar);

                address.setUser(user);

                user.getAddresses().add(address);
            }

        }

        return user;

    }

    public UserResponse toResponse(User user) {
        List<AddressResponse> addresses = user.getAddresses()
                .stream()
                .map(addressMapper::toResponse)
                .toList();

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(addresses)
                .build();



    }


}
