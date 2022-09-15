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
@Document(collection = "Teacher")
public class Teacher {

    @Id
    private String id;
    private String name;
    private String nip;
    private String email;
    private String address;
    private int age;

}
