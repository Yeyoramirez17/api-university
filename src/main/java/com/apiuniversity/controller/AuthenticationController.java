package com.apiuniversity.controller;

import com.apiuniversity.dto.UserRequestDTO;
import com.apiuniversity.dto.UserResponseDTO;
import com.apiuniversity.dto.mapper.UserRequestMapper;
import com.apiuniversity.entity.User;
import com.apiuniversity.security.AuthenticationService;
import com.apiuniversity.security.DTOs.AuthenticationRequest;
import com.apiuniversity.security.DTOs.AuthenticationResponse;
import com.apiuniversity.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRequestDTO dto) {
        return new ResponseEntity<AuthenticationResponse>(
                this.authenticationService.register(dto),
                HttpStatus.OK
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return new ResponseEntity<AuthenticationResponse>(
                this.authenticationService.authenticate(authenticationRequest),
                HttpStatus.OK
        );
    }
}
