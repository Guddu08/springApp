package org.example.controller;

import javafx.application.Application;
import org.example.model.Student;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/insertStudent")
    @ResponseBody
    void insertStudent(@RequestBody Student student){
       String a = "10";
       String b = "20.2";
       int c = Integer.parseInt(a);
       float d = Float.parseFloat(b);
        studentService.insertStudent(student);
    }

    @RequestMapping("/selectStudent")
    @ResponseBody
    Student selectStudent(@RequestParam String name){
        return studentService.selectStudent(name);
    }
    @RequestMapping("/selectStudents")
    @ResponseBody
    List<Student> selectStudents(){
        return studentService.selectStudents();
    }
//    @RequestMapping("/")
//    String dashboard(){
//        return "index.html";
//    }
    @RequestMapping("/insertStudents")
    @ResponseBody
    void insertStudents(@RequestBody List<Student> studentList){
        studentService.insertStudents(studentList);
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    List<Student> deleteStudent(@RequestParam int id ){
        return studentService.deleteStudent(id);
    }

}
