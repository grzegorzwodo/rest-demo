package pl.sdacademy.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StudentController {

    @GetMapping("/students")
    public Student getStudent() {
        //TODO get student from file student.json
        Student student = new Student("test", "test2");
        return student;
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) throws IOException {
        //TODO save student to file student.json
    }

}
