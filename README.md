# Spring-Boot-School-API

This repository is a repository as a SchoolAPI meant for learning spring boot using mongodb

# Documentation

### A. Student
#### 1. Add Data Student
* **endpoint :** `/student`
* **method   :** `POST`
* **body :** <br>
  ```css
  "name" as "String"
  "nim" as "String"
  "email" as "String"
  "gender" as "Char"
  "department" as "String"
  "yearOfEntry" as "Integer"
  ```
  
#### 2. Add Multiple Data Student
* **endpoint :** `/student/addAll`
* **method   :** `POST`
* **body :** <br>
  ```css
  [{
  "name" as "String"
  "nim" as "String"
  "email" as "String"
  "gender" as "Char"
  "department" as "String"
  "yearOfEntry" as "Integer"
  }]
  ```
  
#### 3. Get All Data Student
* **endpoint :** `/student`
* **method   :** `GET`

#### 4. Get Student By Name
* **endpoint :** `/student`
* **method   :** `GET`
* **params   :** `name`

#### 5. Get Student By Nim
* **endpoint :** `/student/getByNim/{nim}`
* **method   :** `GET`

#### 6. Get Student By Year of Entry
* **endpoint :** `/student/{yearOfEntry}`
* **method   :** `GET`

#### 7. Update Data Student
* **endpoint :** `/student`
* **method   :** `PUT`
* **body :** <br>
  ```css
  "_id" as "String"
  "name" as "String"
  "nim" as "String"
  "email" as "String"
  "gender" as "Char"
  "department" as "String"
  "yearOfEntry" as "Integer"
  ```

#### 8. Delete Data Student
* **endpoint :** `/student/{_id}`
* **method   :** `DELETE

<br>

### B. Teacher
#### 1. Add Data Teacher
#### 2. Add Multiple Data Teacher
#### 3. Get All Data Teacher
#### 4. Get Teacher By Name
#### 5. Update Data Teacher
#### 6. Delete Data Teacher
#### 7. Delete Data Teacher By Age

<br>

### C. Class
#### 1. Add Data Class
#### 2. Get All Data Class
#### 3. Get Class By Student Name
#### 4. Get Class By Homeroom Teacher Name
#### 5. Update Data Class
#### 6. Update Homeroom Teacher in Class
#### 7. Update Student in Class
#### 8. Delete Data Class
#### 9. Delete Student From List Class
