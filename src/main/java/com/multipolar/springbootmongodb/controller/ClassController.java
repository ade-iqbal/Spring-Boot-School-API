package com.multipolar.springbootmongodb.controller;

import com.multipolar.springbootmongodb.entity.Class;
import com.multipolar.springbootmongodb.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("")
    public String addClass(@RequestBody Class clas){
        return classService.addClass(clas);
    }

    @GetMapping("")
    public List<Class> getAllClass(){
        return classService.getAllClass();
    }

    @GetMapping("/getByStudentName/{studentName}")
    public List<Class> getClassByStudentName(@PathVariable String studentName){
        return classService.getClassByStudentName(studentName);
    }

    @GetMapping("/getByTeacherName/{teacherName}")
    public Class getClassByTeacherName(@PathVariable String teacherName){
        return classService.getClassByTeacherName(teacherName);
    }

    @PutMapping("")
    public String updateClass(@RequestBody Class clas){
        return classService.updateClass(clas);
    }

    @PatchMapping("/addHomeroomTeacher")
    public String addHomeroomTeacher(@RequestBody Class clas){
        return classService.updateHomeroomTeacher(clas);
    }

    @PatchMapping("/addStudent")
    public String addStudentsList(@RequestBody Class clas){
        return classService.updateStudentsList(clas);
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable String id){
        return classService.deleteClass(id);
    }

    @DeleteMapping("/{idClass}/deleteStudent/{idStudent}")
    public String deleteStudentList(@PathVariable() String idClass, @PathVariable String idStudent){
        return classService.deleteStudentFromList(idClass, idStudent);
    }

}
