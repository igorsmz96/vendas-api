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
       return Address.builder()
               .rua(request.rua())
               .numero(request.numero())
               .bairro(request.bairro())
               .cidade(request.cidade())
               .estado(request.estado())
               .cep(request.cep())
               .longitude(request.longitude())
               .latitude(request.latitude())
               .build();
    }

    public AddressResponse toResponse ( Address address){
        if (address == null) return null;

        return AddressResponse.builder().build();


    }


}
