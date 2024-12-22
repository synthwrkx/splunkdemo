package com.splunk.splunkdemo.repository;

import com.splunk.splunkdemo.vo.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    public StudentRepository() {
        studentList.add(new Student(1, "Aswin", 89));
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public boolean addStudent(Student student) {
        return studentList.add(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public boolean updateStudent(int id, Student student) {
        return getStudentById(id).map(tempStudent -> {
            studentList.remove(tempStudent);
            studentList.add(student);
            return true;
        }).orElse(false);
    }

    public boolean deleteStudent(int id) {
        return studentList.removeIf(student -> student.getId() == id);
    }
}
