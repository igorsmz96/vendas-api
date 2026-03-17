package com.vendas.api.controllers.request;



public record UserRequest(
                          String name,
                          String email,
                          String phone,
                          String password,
                          AddressRequest address)  {



        }
