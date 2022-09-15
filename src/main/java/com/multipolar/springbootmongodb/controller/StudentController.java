package com.multipolar.springbootmongodb.controller;

import com.multipolar.springbootmongodb.dto.StudentDto;
import com.multipolar.springbootmongodb.entity.Student;
import com.multipolar.springbootmongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PostMapping("/addAll")
    public String addAllStudent(@RequestBody List<Student> student){
        return studentService.addAllStudent(student);
    }

    @GetMapping("")
    public List<Student> getAllStudent(@RequestParam(value = "name", required = false) String studentName){
        if(studentName != null){
            return studentService.getStudentByName(studentName);
        }

        return studentService.getAllStudent();
    }

    //get data using feign client
    @GetMapping("/feign")
    public List<Student> getAllStudentUseFeign(){
        return studentService.getAllStudentUseFeign();
    }

    @GetMapping("/getByNim/{nim}")
    public Student getStudentByNim(@PathVariable String nim){
        return studentService.getStudentByNim(nim);
    }

    @GetMapping("/{yearOfEntry}")
    public List<StudentDto> getStudentByYearOfEntry(@PathVariable int yearOfEntry){
        return studentService.getStudentByYearOfEntry(yearOfEntry);
    }

    @PutMapping("")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

}
