package com.vendas.api.controllers;


import com.vendas.api.controllers.request.AddressRequest;
import com.vendas.api.controllers.response.AddressResponse;
import com.vendas.api.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/vendas/address")
public class AddressController {


    private final AddressService addressService;


    @PostMapping("/users/{id}")
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long id, @RequestBody AddressRequest request){
        AddressResponse addressResponse = addressService.createAddress(id,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<AddressResponse>> findAddressByUserId(@PathVariable Long userId){
        List<AddressResponse> byUserId = addressService.findByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(byUserId);

    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressResponse>> findAll(){
        List<AddressResponse> list = addressService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);

    }




}