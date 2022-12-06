package org.example.service;

import org.example.model.Student;

import java.util.List;

public interface StudentServiceImpl {
    void insertStudent(Student student);
    Student selectStudent(String name);
    List<Student> selectStudents();

    void insertStudents(List<Student> studentList);

    List<Student> deleteStudent(int id);
}
