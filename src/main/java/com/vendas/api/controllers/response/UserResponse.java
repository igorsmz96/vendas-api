package com.vendas.api.controllers.response;


import java.util.List;

public record UserResponse(String name,
                           String email,
                           String phone,
                           List<AddressResponse> address) {
}
