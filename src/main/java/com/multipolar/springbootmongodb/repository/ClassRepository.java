package com.multipolar.springbootmongodb.repository;

import com.multipolar.springbootmongodb.entity.Class;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends MongoRepository<Class, String> {

    @Query("{'studentList.name' : ?0}")
    List<Class> findByStudentName(String studentName);

    @Query("{'homeroomTeacher.name' : ?0}")
    Class findByTeacherName(String teacherName);

}
