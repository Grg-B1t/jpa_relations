package com.example.bidirectional_one_to_one.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirectional_one_to_one.Entity.Teacher;
import com.example.bidirectional_one_to_one.Repository.TeacherRepo;

@Service
public class TeacherService implements TeacherServiceInterface{
    TeacherRepo tr;

    public TeacherService(TeacherRepo tr) {
        this.tr = tr;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return tr.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher newTeacher) {
        return tr.save(newTeacher);
    }

    @Override
    public String removeTeacher(Long teacherId) {
        tr.deleteById(teacherId);
        return null;
    }

    @Override
    public Teacher updateTeacherById(Teacher teacher) {
        Teacher updateTeacher = tr.findAll()
        .stream()
        .filter(a -> a.getTeacherID().equals(teacher.getTeacherID()))
        .findFirst().get();

        updateTeacher.setFirstName(teacher.getFirstName());
        updateTeacher.setLastName(teacher.getLastName());
        updateTeacher.setDepartment(teacher.getDepartment());
        updateTeacher.setSalary(teacher.getSalary());
        updateTeacher.setStudent(teacher.getStudent());

        tr.save(updateTeacher);
        return updateTeacher;
    }


    
}
