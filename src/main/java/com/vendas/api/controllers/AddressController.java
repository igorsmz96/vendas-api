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
@RequestMapping(value = "/addresses")
public class AddressController {


    private final AddressService addressService;


    @PostMapping("/users/{id}")
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long id, @RequestBody AddressRequest request){
        AddressResponse addressResponse = addressService.createAddress(id,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<AddressResponse>> findAddressByUserId(@PathVariable Long id){
        List<AddressResponse> byUserId = addressService.findByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(byUserId);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}