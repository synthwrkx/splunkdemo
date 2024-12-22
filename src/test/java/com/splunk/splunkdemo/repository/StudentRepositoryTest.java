package com.splunk.splunkdemo.repository;


import com.splunk.splunkdemo.vo.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryTest {

    @Test
    public void testGetAllStudents() {
        StudentRepository studentRepository = new StudentRepository();
        Student testStudent = new Student(1, "Aswin", 89.0);
        ArrayList<Student> testStudentList = new ArrayList<>(List.of(testStudent));
        Assertions.assertEquals(testStudentList, studentRepository.getAllStudents());
    }

    @Test
    public void testGetStudentById() {
        StudentRepository studentRepository = new StudentRepository();
        Student testStudent = new Student(1, "Aswin", 89.0);
        Assertions.assertEquals(testStudent, studentRepository.getStudentById(1).get());
    }
}
