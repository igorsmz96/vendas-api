package com.vendas.api.mapper;

import com.vendas.api.controllers.request.AddressRequest;
import com.vendas.api.controllers.response.AddressResponse;
import com.vendas.api.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    public Address toAddress (AddressRequest request){
        if (request == null) return null;

        Address address = new Address();

        address.setRua(request.rua());
        address.setNumero(request.numero());
        address.setBairro(request.bairro());
        address.setCidade(request.cidade());
        address.setEstado(request.estado());
        address.setCep(request.cep());
        address.setLatitude(request.latitude());
        address.setLongitude(request.longitude());

        return address;

    }

    public AddressResponse toResponse ( Address address){
        if (address == null) return null;

        return AddressResponse.builder()
                .rua(address.getRua())
                .numero(address.getNumero())
                .bairro(address.getBairro())
                .cidade(address.getBairro())
                .estado(address.getEstado())
                .cep(address.getCep())
                .build();


    }


}
