package com.multipolar.springbootmongodb.controller;

import com.multipolar.springbootmongodb.entity.Teacher;
import com.multipolar.springbootmongodb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("")
    public String addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("/addAll")
    public String addAllTeacher(@RequestBody List<Teacher> teachers){
        return teacherService.addAllTeacher(teachers);
    }

    @GetMapping("")
    public List<Teacher> getAllTeacher(@RequestParam(name = "name", required = false) String teacherName){
        if(teacherName != null){
            return teacherService.getTeacherByName(teacherName);
        }
        return teacherService.getAllTeacher();
    }

    @PutMapping("")
    public String updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable String id){
        return teacherService.deleteTeacher(id);
    }

    @DeleteMapping("/deleteByAge/{age}")
    public String deleteTeacherByAge(@PathVariable int age){
        return teacherService.deleteTeacherByAge(age);
    }

}
