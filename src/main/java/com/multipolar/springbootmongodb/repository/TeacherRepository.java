package com.multipolar.springbootmongodb.repository;

import com.multipolar.springbootmongodb.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    List<Teacher> findByName(String name);
    List<Teacher> deleteByAge(int age);

}
