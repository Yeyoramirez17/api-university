package com.apiuniversity.controller;

import com.apiuniversity.dto.FacultyDTO;
import com.apiuniversity.dto.mapper.FacultyMapper;
import com.apiuniversity.entity.Faculty;
import com.apiuniversity.service.impl.FacultyServiceImpl;
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
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private Logger logger = LoggerFactory.getLogger(FacultyController.class);
    private final FacultyServiceImpl facultyService;
    private final FacultyMapper mapper;

    @GetMapping
    public ResponseEntity<List<FacultyDTO>> findAll() {
        return new ResponseEntity<>(this.mapper.toFacultyDTOs(this.facultyService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> findById(@PathVariable Long id) {
        Faculty faculty = this.facultyService.findById(id);
        return new ResponseEntity<>(this.mapper.FacultyToDTO(faculty), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FacultyDTO dto) {
        Faculty faculty = this.facultyService.save(this.mapper.dtoToFaculty(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(faculty.getIdFaculty()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<FacultyDTO> update (@PathVariable("id") Long id, @RequestBody FacultyDTO dto) {
        dto.setIdFaculty(id);
        Faculty faculty = this.facultyService.update(id, this.mapper.dtoToFaculty(dto));

        return new ResponseEntity<>(this.mapper.FacultyToDTO(faculty), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.facultyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
