package com.vendas.api.controllers.response;

import lombok.Builder;

@Builder
public record AddressResponse(String rua,
                              String numero,
                              String bairro,
                              String cidade,
                              String estado,
                              String cep) {
}
