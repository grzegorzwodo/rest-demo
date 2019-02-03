package pl.sdacademy.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public Student getStudent() {
        Student student = new Student("test", "test2");
        return student;
    }

}
