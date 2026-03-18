package com.vendas.api.controllers.request;


import java.util.List;

public record UserRequest(
                          String name,
                          String email,
                          String phone,
                          String password,
                          List<AddressRequest> addresses)  {



        }
