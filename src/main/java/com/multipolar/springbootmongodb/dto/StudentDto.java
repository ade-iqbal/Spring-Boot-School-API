package com.multipolar.springbootmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;
    private String nim;
    private String email;
    private String department;
    private int yearOfEntry;
    private char gender;

}
