package com.example.bidirectional_one_to_one.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bidirectional_one_to_one.Entity.Student;
import com.example.bidirectional_one_to_one.Repository.StudentRepo;

@Service
public class StudentService implements StudentServiceInterface{
    StudentRepo sr;
    
    @Autowired
    public StudentService(StudentRepo sr) {
        this.sr = sr;
    }

    @Override
    public List<Student> getAllStudents() {
        return sr.findAll();
    }

    @Override
    public Student addStudent(Student newStudent) {
        return sr.save(newStudent);
    }

    @Override
    public String removeStudentById(Long studentId) {
        sr.deleteById(studentId);

        return "student is removed!";
    }

    @Override
    public Student updateStudentById(Student student) {
        Student updatedStudent = sr.findAll()
        .stream()
        .filter(a -> a.getStudentID().equals(student.getStudentID()))
        .findFirst().get();

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setMajor(student.getMajor());
        updatedStudent.setGpa(student.getGpa());
        updatedStudent.setTeacher(student.getTeacher());

        sr.save(updatedStudent);
        return updatedStudent;
    }
    
}
