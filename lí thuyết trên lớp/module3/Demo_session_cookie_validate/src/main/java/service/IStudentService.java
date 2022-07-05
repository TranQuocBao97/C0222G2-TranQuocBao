package service;

import dto.StudentDTO;
import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<StudentDTO> getAll();

    void save(Student student);

    List<Student> searchByName(String nameStudent);

    Map<String, String> save(String codeStudent, String nameStudent, String point, String gender);
}
