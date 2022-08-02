package com.example.bidirectional_one_to_one.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bidirectional_one_to_one.Entity.Student;
import com.example.bidirectional_one_to_one.Service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentEndPoint {
    StudentService ss;
    @Autowired
    public StudentEndPoint(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAll(){
        try {
            return new ResponseEntity<>(ss.getAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addNewStudent")
    public ResponseEntity<Student> addNew(@RequestBody Student newStudent){
        try {
            return new ResponseEntity<>(ss.addStudent(newStudent), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @DeleteMapping("/deleteStudentById/{studentID}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentID){
        try {
            return new ResponseEntity<>(ss.removeStudentById(studentID), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateStudentById")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student){
        try {
            return new ResponseEntity<>(ss.addStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
