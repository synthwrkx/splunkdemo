package com.splunk.splunkdemo.service;

import com.splunk.splunkdemo.repository.StudentRepository;
import com.splunk.splunkdemo.vo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    Logger logger = LogManager.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    public boolean addStudent(Student student) {
        logger.info("StudentService: addStudent - Execution started");
        logger.info("StudentService: addStudent request: {}", student.toString());
        return studentRepository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        logger.info("StudentService: getAllStudents - Execution started");
        List<Student> studentList = studentRepository.getAllStudents();
        logger.info("StudentService: getAllStudents response: {}", studentList);

        return studentList;
    }

    public Student getStudentById(int id) {
        logger.info("StudentService: getStudentById - Execution started");
        logger.info("StudentService: getStudentById id: {}", id);

        Optional<Student> student = studentRepository.getStudentById(id);
        if(student.isPresent()) {
            logger.info("StudentService response: {}", student.get());
            return student.get();
        } else {
            logger.info("StudentService response: null");
            return null;
        }
    }

    public boolean updateStudent(int id, Student student) {
        logger.info("StudentService: updateStudent - Execution started");
        logger.info("StudentService: updateStudent request: {}", ("ID: " + id + " New details: " + student.toString()));
        return studentRepository.updateStudent(id, student);
    }

    public boolean deleteStudent(int id) {
        logger.info("StudentService: deleteStudent - Execution started");
        logger.info("StudentService: deleteStudent id: {}", id);
        return studentRepository.deleteStudent(id);
    }
}
