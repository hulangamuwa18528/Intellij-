package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/students") //read all files
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(value = "/students/{sId}") //read single file
    public Student getStudentbyId(@PathVariable String sId){
        return studentRepository.findStudentByStudentId(sId);
    }

    @PostMapping(value = "/students") //create
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping(value = "/students/{sId}") //delete
    public void deleteStudent(@PathVariable String sId){
        studentRepository.deleteById(sId);
    }

    @PutMapping(value = "/students/{sId}") //update
    public Student updateStudent(@PathVariable String sId,@RequestBody Student student){
        studentRepository.deleteById(sId);
        return studentRepository.save(student);
    }



}
