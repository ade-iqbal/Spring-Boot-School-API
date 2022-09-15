package com.multipolar.springbootmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Class")
public class Class {

    @Id
    private String id;
    private int gradeLevel;
    private String gradeName;
    private Teacher homeroomTeacher;
    private List<Student> studentList;

}
