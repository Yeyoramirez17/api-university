package com.apiuniversity.controller;

import com.apiuniversity.dto.TeacherDTO;
import com.apiuniversity.dto.mapper.TeacherMapper;
import com.apiuniversity.entity.Teacher;
import com.apiuniversity.service.impl.TeacherServiceImpl;
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
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherServiceImpl teacherService;
    private final TeacherMapper mapper;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll() {
        return new ResponseEntity<>(this.mapper.toTeacherDTOs(this.teacherService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Long id) {
        Teacher teacher = this.teacherService.findById(id);
        return new ResponseEntity<>(this.mapper.teacherToDTO(teacher), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TeacherDTO TeacherDTO) {
        Teacher Teacher = this.teacherService.save(this.mapper.dtoToTeacher(TeacherDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Teacher.getIdTeacher()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TeacherDTO> update (@PathVariable("id") Long id, @RequestBody TeacherDTO dto) {
        dto.setIdTeacher(id);
        Teacher teacher = this.teacherService.update(id, this.mapper.dtoToTeacher(dto));

        return new ResponseEntity<>(this.mapper.teacherToDTO(teacher), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.teacherService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
