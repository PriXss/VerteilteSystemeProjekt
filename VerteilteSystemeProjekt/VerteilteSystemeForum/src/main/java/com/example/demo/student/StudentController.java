package com.example.demo.student;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private static final Gson gson = new Gson();
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @CrossOrigin(methods={RequestMethod.OPTIONS,RequestMethod.POST},origins={"http://localhost:63342"})
    @PostMapping(consumes="text/plain")
    public void registerNewStudent(@RequestBody String student){
        Student tmp = gson.fromJson(student,Student.class);
        studentService.addNewStudent(tmp);
    }
    @CrossOrigin
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @CrossOrigin
    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId")Long studentId,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,username, email);
    }


}
