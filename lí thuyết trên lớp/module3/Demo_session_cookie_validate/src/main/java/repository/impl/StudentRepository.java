package repository.impl;

import dto.StudentDTO;
import model.Student;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    static List<Student> students = new ArrayList<>();
    private BaseRepository baseRepository = new BaseRepository();

    static {
        students.add(new Student(1, "haiTT", 9, 1));
        students.add(new Student(2, "haiTT2", 3, 0));
        students.add(new Student(3, "haiTT3", 6, 1));
        students.add(new Student(4, "haiTT4", 8, null));
        students.add(new Student(5, "haiTT5", 5, 1));
    }

    @Override
    public List<StudentDTO> getAll() {
//        List<Student> studentList = new ArrayList<>();
        List<StudentDTO> studentList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
//            ExecuteQuery: không làm thay đổi dữ liệu
//            ExecuteUpdate: Thay đổi dữ liệu.
            ResultSet resultSet = statement.executeQuery("select student.*,class.name_class from student left join class on student.code_class = class.code_class");
            while (resultSet.next()) {
                Integer codeStudent = resultSet.getInt("code_student");
                String nameStudent = resultSet.getString("name_student");
                Double point = resultSet.getDouble("point");
                Integer gender = resultSet.getInt("gender");
                String nameClass = resultSet.getString("name_class");
                studentList.add(new StudentDTO(codeStudent, nameStudent, point, gender,nameClass));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

//    @Override
//    public void save(Student student) {
//        Connection connection = this.baseRepository.getConnectionJavaToDB();
//        try {
////            Statement statement = connection.createStatement();
////            statement.executeUpdate("insert into student(code_student, name_student, point, gender) value ("+student.getCodeStudent()+","+student.getNameStudent()+")");
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(code_student, name_student, point, gender) value (?,?,?,?)");
//            preparedStatement.setInt(1, student.getCodeStudent());
//            preparedStatement.setString(2, student.getNameStudent());
//            preparedStatement.setDouble(3, student.getPoint());
//            preparedStatement.setInt(4, student.getGender());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void save(Student student) {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            connection.setAutoCommit(false);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into student(code_student, name_student, point, gender) value ("+student.getCodeStudent()+","+student.getNameStudent()+")");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(code_student, name_student, point, gender) value (?,?,?,?)");
            preparedStatement.setInt(1, student.getCodeStudent());
            preparedStatement.setString(2, student.getNameStudent());
            preparedStatement.setDouble(3, student.getPoint());
            preparedStatement.setInt(4, student.getGender());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into class(code_class, name_class) value (?,?)");
            preparedStatement1.setInt(1, 6);
            preparedStatement1.setString(2,"C0522G1");
            preparedStatement1.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> searchByName(String nameStudent) {
       List<Student> studentList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            CallableStatement callableStatement = connection.prepareCall("call find_all_student_by_name(?)");
            callableStatement.setString(1, "%"+nameStudent+"%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer codeStudent = resultSet.getInt("code_student");
                String nameStudent2 = resultSet.getString("name_student");
                Double point = resultSet.getDouble("point");
                Integer gender = resultSet.getInt("gender");
                studentList.add(new Student(codeStudent, nameStudent2, point, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
