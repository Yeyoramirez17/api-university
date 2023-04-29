package com.apiuniversity.controller;

import com.apiuniversity.dto.UserRequestDTO;
import com.apiuniversity.dto.UserResponseDTO;
import com.apiuniversity.dto.mapper.UserRequestMapper;
import com.apiuniversity.dto.mapper.UserResponseMapper;
import com.apiuniversity.entity.User;
import com.apiuniversity.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserServiceImpl userService;
    private final UserResponseMapper mapperResponse;
    private final UserRequestMapper mapperRequest;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return new ResponseEntity<>(mapperResponse.toUsersDTO(this.userService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        User user = this.userService.findById(id);
        return  new ResponseEntity<>(this.mapperResponse.userToUserResponseDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRequestDTO dto) {
        User user = this.userService.save(this.mapperRequest.dtoRequestToUser(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUser()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
