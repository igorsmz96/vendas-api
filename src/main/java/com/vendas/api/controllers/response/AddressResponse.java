package com.vendas.api.controllers.response;

import com.vendas.api.entities.User;
import lombok.Builder;

@Builder
public record AddressResponse(Long id,
                              Long userId,
                              String rua,
                              String numero,
                              String bairro,
                              String cidade,
                              String estado,
                              String cep) {
}
