package com.apiuniversity.controller;

import com.apiuniversity.dto.RoleDTO;
import com.apiuniversity.dto.mapper.RoleMapper;
import com.apiuniversity.entity.Role;
import com.apiuniversity.exception.BadRequestException;
import com.apiuniversity.service.impl.RoleServiceImpl;
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
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);
    private final RoleServiceImpl roleService;
    private final RoleMapper mapper;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() {
        return new ResponseEntity<>(this.mapper.toRoleDTO(this.roleService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
        Role role = this.roleService.findById(id);
        return new ResponseEntity<>(this.mapper.roleToDTO(role), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RoleDTO roleDTO) {
        Role role = this.roleService.save(this.mapper.dtoToRole(roleDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getIdRole()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<RoleDTO> update (@PathVariable("id") Long id, @RequestBody RoleDTO roleDTO) {
        roleDTO.setIdRole(id);
        Role role = this.roleService.update(id, this.mapper.dtoToRole(roleDTO));

        return new ResponseEntity<>(this.mapper.roleToDTO(role), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
