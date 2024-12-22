package com.splunk.splunkdemo.controller;

import com.splunk.splunkdemo.service.StudentService;
import com.splunk.splunkdemo.vo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LogManager.getLogger(StudentController.class);

    private final String successMsg = "{\"status\": \"success\"}";
    private final String failureMsg = "{\"status\": \"failed\"}";

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    ResponseEntity<String> addCourse(@RequestBody Student student) {
        logger.info("Invoked /add endpoint");

        if(studentService.addStudent(student)) {
            logger.info("/addStudent endpoint: {}", successMsg);
            return new ResponseEntity<>(successMsg, HttpStatus.OK);
        } else {
            logger.info("/addStudent endpoint: {}", failureMsg);
            return new ResponseEntity<>(failureMsg, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    ResponseEntity<List<Student>> getAllStudents() {
        logger.info("Invoked /getAll endpoint");

        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        logger.info("Invoked /updateStudent endpoint");

        if(studentService.updateStudent(id, student)) {
            logger.info("/updateStudent endpoint: {}", successMsg);
            return new ResponseEntity<>(successMsg, HttpStatus.OK);
        } else {
            logger.info("/updateStudent endpoint: {}", failureMsg);
            return new ResponseEntity<>(failureMsg, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<Student> getStudentById(@PathVariable int id) {
        logger.info("Invoked /getStudentById endpoint");
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<String> deleteStudent(@PathVariable int id) {
        logger.info("Invoked /deleteStudent endpoint");

        if(studentService.deleteStudent(id)) {
            logger.info("/deleteStudent endpoint: {}", successMsg);
            return new ResponseEntity<>(successMsg, HttpStatus.OK);
        } else {
            logger.info("/deleteStudent endpoint: {}", failureMsg);
            return new ResponseEntity<>(failureMsg, HttpStatus.NOT_FOUND);
        }
    }
}
