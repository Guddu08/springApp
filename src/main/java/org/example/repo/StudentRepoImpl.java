package org.example.repo;

import org.example.model.Student;

import java.util.List;

public interface StudentRepoImpl {
    void insertStudent(Student student);
    Student selectStudent(String name);
    List<Student> selectStudents();

    void insertStudents(List<Student> studentList);
    Boolean deleteStudent(int id);
}
