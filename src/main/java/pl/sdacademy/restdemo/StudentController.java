package pl.sdacademy.restdemo;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

// restController sygnalizuje klasę gdzię będą mapingi i ustawienia resta
@RestController
public class StudentController {

    // metoda pobiera dane z jsona
    @GetMapping("/students")
    public Student getStudent() throws IOException {
        //TODO get student from file student.json
        String students = readFile("student.json");
        Student targetObject = new Gson().fromJson(students, Student.class);
        return targetObject;
    }

    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) throws IOException {
        //TODO save student to file student.json
        System.out.println(student);
        Gson g = new Gson();
        String jsonToString = g.toJson(student);
        System.out.println(jsonToString);

        BufferedWriter write = new BufferedWriter(new FileWriter("student.json"));
        write.write(jsonToString);
        write.close();
    }

}
