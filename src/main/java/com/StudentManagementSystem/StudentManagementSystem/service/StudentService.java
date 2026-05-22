package com.StudentManagementSystem.StudentManagementSystem.service;

import com.StudentManagementSystem.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
   public void deleteStudentByid(Long id){
      studentRepository.deleteById(id);

    }
    public List<Student> getStudentByDepartment(String department){
         return studentRepository.findAll();
    }
public List<Student> getHigherScore(Double marks){
   return studentRepository.findStudentwithMarksGreaterThan(marks);
}
public List<Student>searchByName(String keyword){
return studentRepository.searchByName(keyword);
}
}
