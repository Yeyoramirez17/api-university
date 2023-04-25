package com.apiuniversity.controller;

import com.apiuniversity.dto.SubjectDTO;
import com.apiuniversity.dto.mapper.SubjectMapper;
import com.apiuniversity.entity.Subject;
import com.apiuniversity.service.impl.SubjectServiceImpl;
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
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private Logger logger = LoggerFactory.getLogger(SubjectController.class);
    private final SubjectServiceImpl subjectService;
    private final SubjectMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> findAll() {
        return new ResponseEntity<>(this.mapper.toSubjectDTOs(this.subjectService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> findById(@PathVariable Long id) {
        Subject subject = this.subjectService.findById(id);
        return new ResponseEntity<>(this.mapper.SubjectToDTO(subject), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SubjectDTO SubjectDTO) {
        Subject subject = this.subjectService.save(this.mapper.dtoToSubject(SubjectDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(subject.getIdSubject()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SubjectDTO> update (@PathVariable("id") Long id, @RequestBody SubjectDTO SubjectDTO) {
        SubjectDTO.setIdSubject(id);
        Subject Subject = this.subjectService.update(id, this.mapper.dtoToSubject(SubjectDTO));

        return new ResponseEntity<>(this.mapper.SubjectToDTO(Subject), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.subjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
