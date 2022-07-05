package service.impl;

import dto.StudentDTO;
import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<StudentDTO> getAll() {
        return iStudentRepository.getAll();
    }

    @Override
    public void save(Student student) {
        if(student.getPoint()>0 && student.getPoint()<10) {

        }
        this.iStudentRepository.save(student);
    }

    @Override
    public List<Student> searchByName(String nameStudent) {
        return this.iStudentRepository.searchByName(nameStudent);
    }

    @Override
    public Map<String, String> save(String codeStudent, String nameStudent, String point, String gender) {
        Map<String, String> errors = new HashMap<>();
        if(codeStudent.equals("") || codeStudent == null) {
            errors.put("codeStudent","CodeStudent not null!.");
        }else if(!codeStudent.matches("^STD\\-[0-9]{4}$")) {
            errors.put("codeStudent", "Code student invalid format");
        }
        if(nameStudent.equals("") || nameStudent == null) {
            errors.put("nameStudent", "Name student not null!");
        }
        if(errors.size()==0) {
            this.iStudentRepository.save(new Student(Integer.parseInt(codeStudent),nameStudent,Double.parseDouble(point),Integer.parseInt(gender)));
        }
        return errors;

    }
}
