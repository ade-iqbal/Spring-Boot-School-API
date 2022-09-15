package com.multipolar.springbootmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
public class Student {

    @Id
    private String id;
    private String name;
    private String nim;
    private String email;
    private char gender;
    private String department;
    private int yearOfEntry;

}
