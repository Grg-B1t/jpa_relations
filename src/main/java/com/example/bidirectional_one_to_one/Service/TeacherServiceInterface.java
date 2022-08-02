package com.example.bidirectional_one_to_one.Service;

import java.util.List;

import com.example.bidirectional_one_to_one.Entity.Teacher;

public interface TeacherServiceInterface {
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher newTeacher);
    String removeTeacher(Long teacherId);
    Teacher updateTeacherById(Teacher teacher);
}
