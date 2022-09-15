package com.multipolar.springbootmongodb.service;

import com.multipolar.springbootmongodb.dto.StudentDto;
import com.multipolar.springbootmongodb.entity.Student;
import com.multipolar.springbootmongodb.repository.ClassRepository;
import com.multipolar.springbootmongodb.repository.StudentsRepository;
import com.multipolar.springbootmongodb.utils.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private FeignService feignService;

    // TODO: add data student
    public String addStudent(Student student) {
        studentsRepository.insert(student);
        return "New student added successfully with id : " + student.getId();
    }

    // TODO: add multiple data student
    public String addAllStudent(List<Student> student){
        studentsRepository.insert(student);
        return student.size()+" new students added successfully";
    }

    // TODO: get data student
    public List<Student> getAllStudent(){
        return studentsRepository.findAll();
    }

    // TODO : get data student using feign client
    public List<Student> getAllStudentUseFeign(){
        return feignService.getAllStudents();
    }

    // TODO : get data student by their year of entry
    public List<StudentDto> getStudentByYearOfEntry(int yearOfEntry){
        return studentsRepository.findByYearOfEntry(yearOfEntry);
    }

    // TODO : get data student by their name
    public List<Student> getStudentByName(String studentName) {
        return studentsRepository.findByName(studentName);
    }

    // TODO : get data student by their nim
    public Student getStudentByNim(String nim){
        return studentsRepository.findByNim(nim);
    }

    // TODO : update data student
    public String updateStudent(Student student){
        studentsRepository.save(student);
        return "Updated successfully!";
    }

    // TODO : delete data stduent
    public String deleteStudent(String id){
        studentsRepository.deleteById(id);
        return "Student with id "+id+" removed!";
    }

}
