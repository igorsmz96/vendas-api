package com.vendas.api.controllers;

import com.vendas.api.controllers.request.UserRequest;
import com.vendas.api.controllers.response.UserResponse;
import com.vendas.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/vendas/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
        UserResponse userResponse = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserResponse>> findAllUser(){
        List<UserResponse> allUsers = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest request){
        UserResponse userResponse = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updatePartial(@PathVariable Long id, @RequestBody UserRequest request){
      UserResponse userResponse = userService.updatePartial(id,request);
      return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

}
