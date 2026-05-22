package com.StudentManagementSystem.StudentManagementSystem.Controller;

import com.StudentManagementSystem.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.StudentManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);

    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentByid(id);
        return "sucessfully Deteted";
    }
    @GetMapping("/department/{department}")
    public List<Student> getStudentBydepartment(@PathVariable String department){
        return studentService.getStudentByDepartment(department);
    }
    @GetMapping("/higher-scores/{marks}")
    public List<Student> getHighscore(@PathVariable Double marks){
        return  studentService.getHigherScore(marks);
    }
    @GetMapping("/search")
    public List<Student>search(@RequestParam String keyword){
        return studentService.searchByName(keyword);

    }
}
