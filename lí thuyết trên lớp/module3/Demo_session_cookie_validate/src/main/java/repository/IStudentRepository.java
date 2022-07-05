package repository;

import dto.StudentDTO;
import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDTO> getAll();

    void save(Student student);

    List<Student> searchByName(String nameStudent);
}
