package com.example.demo.student2;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/student")
public class Student2Controller {

    private static final Gson gson = new Gson();
    private final Student2Service student2Service;

    @Autowired
    public Student2Controller(Student2Service student2Service) {
        this.student2Service = student2Service;
    }

    @CrossOrigin
    @GetMapping
    public List<Student2> getStudents() {
        return student2Service.getStudents();
    }
    @CrossOrigin(methods={RequestMethod.OPTIONS,RequestMethod.POST},origins={"http://localhost:63342"})
    @PostMapping(consumes="text/plain")
    public void registerNewStudent(@RequestBody String student2){
        Student2 tmp = gson.fromJson(student2,Student2.class);
        student2Service.addNewStudent(tmp);
    }
    @CrossOrigin
    @DeleteMapping(path="{student2Id}")
    public void deleteStudent(@PathVariable("student2Id") Long student2Id){
        student2Service.deleteStudent(student2Id);
    }
    @CrossOrigin
    @PutMapping(path="{student2Id}")
    public void updateStudent(@PathVariable("student2Id")Long student2Id,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String email){
        student2Service.updateStudent(student2Id, username, email);
    }


}
