package com.multipolar.springbootmongodb.repository;

import com.multipolar.springbootmongodb.dto.StudentDto;
import com.multipolar.springbootmongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends MongoRepository<Student, String> {

    List<StudentDto> findByYearOfEntry(int yearOfEntry);
    Student findByNim(String nim);

    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    List<Student> findByName(String studentName);
}
