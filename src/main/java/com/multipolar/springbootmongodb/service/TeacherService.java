package com.multipolar.springbootmongodb.service;

import com.multipolar.springbootmongodb.entity.Class;
import com.multipolar.springbootmongodb.entity.Teacher;
import com.multipolar.springbootmongodb.repository.ClassRepository;
import com.multipolar.springbootmongodb.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRepository classRepository;

    // TODO : add data teacher
    public String addTeacher(Teacher teacher){
        teacherRepository.insert(teacher);
        return "New teacher added successfully with id : " + teacher.getId();
    }

    // TODO : add multiple data teacher
    public String addAllTeacher(List<Teacher> teachers){
        teacherRepository.insert(teachers);
        return teachers.size() + " new students added successfully";
    }

    // TODO : get data teacher
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    // TODO : get data teacher by their name
    public List<Teacher> getTeacherByName(String teacherName){
        return teacherRepository.findByName(teacherName);
    }

    // TODO : update data teacher
    public String updateTeacher(Teacher teacher){
        teacherRepository.save(teacher);

        Class clas = classRepository.findByTeacherId(teacher.getId());
        clas.setHomeroomTeacher(teacher);
        classRepository.save(clas);

        return "Updated successfully!";
    }

    // TODO : delete data teacher
    public String deleteTeacher(String id){
        teacherRepository.deleteById(id);
        return "Teacher with id " + id + " removed!";
    }

    // TODO : delete data teacher by their age
    public String deleteTeacherByAge(int age){
        teacherRepository.deleteByAge(age);
        return "Teacher with age " + age + " removed!";
    }

}
