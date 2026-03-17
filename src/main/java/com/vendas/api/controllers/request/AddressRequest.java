package com.vendas.api.controllers.request;




public record AddressRequest(String rua,
                             String numero,
                             String bairro,
                             String cidade,
                             String estado,
                             String cep,
                             Double longitude,
                             Double latitude) {
}
