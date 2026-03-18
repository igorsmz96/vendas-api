package com.vendas.api.controllers.response;




import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
public record UserResponse(String name,
                           String email,
                           String phone,
                           List<AddressResponse> address) {
}
