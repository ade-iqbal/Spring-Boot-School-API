package com.multipolar.springbootmongodb.service;

import com.mongodb.BasicDBObject;
import com.multipolar.springbootmongodb.entity.Class;
import com.multipolar.springbootmongodb.repository.ClassRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    MongoTemplate mongoTemplate = null;

    // TODO : add data class
    public String addClass(Class clas){
        classRepository.insert(clas);
        return "New teacher added successfully with id : " + clas.getId();
    }

    // TODO : get data class
    public List<Class> getAllClass(){
        return classRepository.findAll();
    }

    public String updateClass(Class clas){
        classRepository.save(clas);

        return "Updated successfully!";
    }

    // TODO : get data class by name of student
    public List<Class> getClassByStudentName(String studentName){
        return classRepository.findByStudentName(studentName);
    }

    // TODO : get data class by name of homeroom teacher
    public Class getClassByTeacherName(String teacherName) {
        return classRepository.findByTeacherName(teacherName);
    }

    // TODO : update data class with homeroom teacher
    public String updateHomeroomTeacher(Class clas) {
        Class classExist = classRepository.findById(clas.getId()).orElse(null);
        classExist.setHomeroomTeacher(clas.getHomeroomTeacher());
        classRepository.save(classExist);

        return "Homeroom teacher added successfully on class id "+clas.getId();
    }

    // TODO : update data class with list students
    public String updateStudentsList(Class clas) {
        Class classExist = classRepository.findById(clas.getId()).orElse(null);

        if(classExist.getStudentList() != null){
            classExist.getStudentList().addAll(clas.getStudentList());
        }
        else{
            classExist.setStudentList(clas.getStudentList());
        }

        classRepository.save(classExist);

        return clas.getStudentList().size()+
                " student"+(clas.getStudentList().size() > 1 ? "s" : "") +
                " add successfully";
    }

    // TODO : delete data class
    public String deleteClass(String id){
        classRepository.deleteById(id);

        return "Class with id "+id+" removed!";
    }

    // TODO : delete data student from list student in class
    public String deleteStudentFromList(String idClass, String idStudent) {
        // ? make a criteria from query
        Query query = new Query();
        query.addCriteria(Criteria
                .where("_id").is(new ObjectId(idClass))
        );

        /**
         * set new value to update
         * pull a student object from student list
        **/
        Update update = new Update();
        update.pull("studentList", new BasicDBObject("_id", new ObjectId(idStudent)));

        // ? execute query update using mongotemplate
        mongoTemplate.updateFirst(query, update, Class.class);

        return "Student with id "+idStudent+" removed from class id "+idClass;
    }

}
