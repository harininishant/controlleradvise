package com.example.controlleradvice.repo;

import com.example.controlleradvice.BadNameException;
import com.example.controlleradvice.DuplicateIdentityException;
import com.example.controlleradvice.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class StudentRepo {
    private List<Student> studentList = new ArrayList<>();

    public Student CreateStudent(Student student){
        if (student.getFirstName()== null){
         throw new BadNameException("Student Name cant be null");
        }
        if (student.getLastName()== null){
            throw new BadNameException("Student Name cant be null");
        }
        long count = studentList.stream().filter(s -> s.getId() == student.getId()).count();
if (count!=0){
    throw new DuplicateIdentityException(String.format("Student with id %d alrwady exist",student.getId()));
}
studentList.add(student);
return student;
    }
}
