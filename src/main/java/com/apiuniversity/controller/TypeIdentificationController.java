package com.apiuniversity.controller;

import com.apiuniversity.dto.TypeIdentificationDTO;
import com.apiuniversity.dto.mapper.TypeIdentificationMapper;
import com.apiuniversity.entity.TypeIdentification;
import com.apiuniversity.service.impl.TypeIdentificationServiceImpl;
import jakarta.validation.Valid;
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
@RequestMapping("/api/v1/identifications")
@RequiredArgsConstructor
public class TypeIdentificationController {

    private static final Logger logger = LoggerFactory.getLogger(TypeIdentificationController.class);
    private final TypeIdentificationServiceImpl typeIdentificationService;
    private final TypeIdentificationMapper mapper;

    @GetMapping
    public ResponseEntity<List<TypeIdentificationDTO>> findAll() {
        return new ResponseEntity<>(this.mapper.toTypeIdentificationDTO(typeIdentificationService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeIdentificationDTO> findById(@PathVariable("id") Long id) {
        TypeIdentification type = this.typeIdentificationService.findById(id);
        return new ResponseEntity<>(this.mapper.typeIdentificationToDTO(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TypeIdentificationDTO typeIdentificationDto) {
        TypeIdentification type = typeIdentificationService.save(this.mapper.dtoToTypeIdentification(typeIdentificationDto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(type.getIdTypeIdentification()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TypeIdentificationDTO> update(@PathVariable("id") Long id, @Valid @RequestBody TypeIdentificationDTO typeIdentificationDto) {
        typeIdentificationDto.setIdTypeIdentification(id);
        TypeIdentification type = this.typeIdentificationService.update(id, this.mapper.dtoToTypeIdentification(typeIdentificationDto));
        return new ResponseEntity<>(this.mapper.typeIdentificationToDTO(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.typeIdentificationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
