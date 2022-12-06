package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{

    @Autowired
    private StudentRepoImpl studentRepo;

    @Override
    public void insertStudent(Student student) {
        studentRepo.insertStudent(student);
    }

    @Override
    public Student selectStudent(String name) {
        return studentRepo.selectStudent(name);
    }

    @Override
    public List<Student> selectStudents() {
        return studentRepo.selectStudents();
    }

    @Override
    public void insertStudents(List<Student> studentList){
        studentRepo.insertStudents(studentList);
    }

    @Override
    public List<Student> deleteStudent(int id) {
        studentRepo.deleteStudent(id);
        return studentRepo.selectStudents();
    }
}
