package org.example.repo;

import org.example.model.Student;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements StudentRepoImpl{
    String url = "jdbc:mysql://localhost:3306/hello";
    String username = "root";
    String password = "";
    @Override
    public void insertStudent(Student student){

        String query = "insert into student values('"+student.getId()
                                                +"','"+student.getName()
                                                +"','"+student.getEmail()+"')";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Student selectStudent(String name) {
//        String url = "jdbc:mysql://localhost:3306/stud";
//        String username = "root";
//        String password = "";
        String query = "select * from student where name = '"+name+"'";
        Student student = new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }

    @Override
    public List<Student> selectStudents() {
//        String url = "jdbc:mysql://localhost:3306/stud";
//        String username = "root";
//        String password = "";
        String query = "select * from student";
        List<Student> studentList = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }

    @Override
    public void insertStudents(List<Student> studentList){
//        int n = studentList.size();
//        for (int i=0;i<n;i++){
//
//        }
//        String[] query = new String[n];
//        for (int i=0;i<n;i++) {
//            query[i] = "insert into student values('"+studentList.get(i).getId()+"','"+
//                                                    studentList.get(i).getName()+"','"+
//                                                    studentList.get(i).getEmail()+"')";
//        }
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url,username,password);
//            Statement st = connection.createStatement();
//            st.executeUpdate(query);
//        }catch (Exception e){
//            System.out.println(e);
//        }
        int n = studentList.size();
        String[] query = new String[n];
        for (int i=0;i<n;i++) {
            query[i] = "insert into student values('"+studentList.get(i).getId()+"','"+
                                                    studentList.get(i).getName()+"','"+
                                                    studentList.get(i).getEmail()+"')";
        }
        System.out.println(studentList.get(1).getName());
        System.out.println("-----------------");
        System.out.println(n);
        System.out.println("-----------------");
        System.out.println(query[0]);
        try{
            for (int i=0;i<n;i++) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url,username,password);
                Statement st = connection.createStatement();
                st.executeQuery(query[i]);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Boolean deleteStudent(int id) {

        String query = "delete from student where id ='"+id+"'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            System.out.println(result);
            if(result==1){
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
