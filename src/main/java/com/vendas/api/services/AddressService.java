package com.vendas.api.services;

import com.vendas.api.controllers.request.AddressRequest;
import com.vendas.api.controllers.response.AddressResponse;
import com.vendas.api.entities.Address;
import com.vendas.api.entities.User;
import com.vendas.api.mapper.AddressMapper;
import com.vendas.api.repositories.AddressRepository;
import com.vendas.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService{

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public AddressResponse createAddress(Long id, AddressRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O id:" + id + "nao foi encontrado"));

        Address address = addressMapper.toAddress(request);

        address.setUser(user);
        user.getAddresses().add(address);
        addressRepository.save(address);

        return addressMapper.toResponse(address);

    }

    public List<AddressResponse> findByUserId(Long userId){

        List<Address> addresses = addressRepository.findByUserId(userId);

        List<AddressResponse> list = addresses.stream().map(address -> addressMapper.toResponse(address)).toList();

        return list;

    }

    public List<AddressResponse> findAll( ){
        List<Address> addresses = addressRepository.findAll();

        return addresses.stream().map(address -> addressMapper.toResponse(address)).toList();
    }










}

