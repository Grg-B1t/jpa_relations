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

import com.example.bidirectional_one_to_one.Entity.Teacher;
import com.example.bidirectional_one_to_one.Service.TeacherService;

@RestController
@RequestMapping("/teach")
public class TeacherEndPoint {
    TeacherService ts;
    @Autowired
    public TeacherEndPoint(TeacherService ts) {
        this.ts = ts;
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<Teacher>> getAll(){
        try {
            return new ResponseEntity<>(ts.getAllTeachers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addNewTeacher")
    public ResponseEntity<Teacher> addNew(@RequestBody Teacher newTeacher){
        try {
            return new ResponseEntity<>(ts.addTeacher(newTeacher), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteTeacherById/{teacherID}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long teacherID){
        try {
            return new ResponseEntity<>(ts.removeTeacher(teacherID), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTeacherById")
    public ResponseEntity<Teacher> updateTeacherById(@RequestBody Teacher teacher){
        try {
            return new ResponseEntity<>(ts.addTeacher(teacher), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
