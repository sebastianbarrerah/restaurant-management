package com.ApiRestFull.restaurant_management.controllers.users;


import com.ApiRestFull.restaurant_management.dto.UserRequestDto;
import com.ApiRestFull.restaurant_management.dto.UserResponseDto;
import com.ApiRestFull.restaurant_management.model.Users;
import com.ApiRestFull.restaurant_management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.DtoConverter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserRequestDto userRequestDTO) {
        Users user = DtoConverter.convertToEntity(userRequestDTO);
        userService.saveUser(user);
        return ResponseEntity.ok("Usuario creado con exito");
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        List<Users> users = userService.findAllUsers();
        List<UserResponseDto> response = users.stream()
                .map(DtoConverter::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {
        Users user = userService.findUserById(id);
        return ResponseEntity.ok(DtoConverter.convertToResponseDto(user));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDTO) {
        Users user = DtoConverter.convertToEntity(userRequestDTO);
        Users updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(DtoConverter.convertToResponseDto(updatedUser));
    }
}
