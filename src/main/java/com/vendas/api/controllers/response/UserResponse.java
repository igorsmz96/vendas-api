package com.vendas.api.controllers.response;


import lombok.Builder;


import java.util.List;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email,
                           String phone,
                           List<AddressResponse> address) {
}
