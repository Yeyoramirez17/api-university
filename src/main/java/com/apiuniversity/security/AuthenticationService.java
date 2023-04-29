package com.apiuniversity.security;

import com.apiuniversity.dto.UserRequestDTO;
import com.apiuniversity.dto.mapper.UserRequestMapper;
import com.apiuniversity.dto.mapper.UserResponseMapper;
import com.apiuniversity.entity.User;
import com.apiuniversity.repository.IUserRepository;
import com.apiuniversity.security.DTOs.AuthenticationRequest;
import com.apiuniversity.security.DTOs.AuthenticationResponse;
import com.apiuniversity.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserService userService;
    private final UserRequestMapper mapperRequest;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserRequestDTO dto) {
        User user = this.userService.save(this.mapperRequest.dtoRequestToUser(dto));

        String token = jwtTokenProvider
                .generateToken(
                        userDetailsService.loadUserByUsername(user.getUsername())
                );

        return AuthenticationResponse
                .builder()
                .accessToken(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
        );

        // User user = userService.findByUsername(request.getUsername())
        //        .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + request.getUsername()));

        String token = jwtTokenProvider
                .generateToken(
                        userDetailsService.loadUserByUsername(request.getUsername())
                );

        return AuthenticationResponse
                .builder()
                .accessToken(token)
                .build();
    }
}
