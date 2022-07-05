package controller;

import dto.StudentDTO;
import model.Student;
import service.IStudentService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentController", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    private IStudentService iStudentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameSession = (String) request.getSession().getAttribute("usernameSession");
        if (usernameSession != null) {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    String codeStudent = request.getParameter("codeStudent");
                    String nameStudent = request.getParameter("nameStudent");
                    String point = request.getParameter("point");
                    String gender = request.getParameter("gender");
//                    Student student = new Student(codeStudent, nameStudent, point, gender);
                    Map<String, String> errors = this.iStudentService.save(codeStudent, nameStudent, point, gender);
                    if(errors.size() == 0) {
                        response.sendRedirect("/student");
                    } else {
                        request.setAttribute("errors", errors);
                        request.getRequestDispatcher("create.jsp").forward(request,response);
                    }
//                request.getRequestDispatcher("/list.jsp").forward(request,response);

                    break;
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameSession = (String) request.getSession().getAttribute("usernameSession");
        if (usernameSession != null) {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    request.getRequestDispatcher("create.jsp").forward(request, response);
                    break;
                case "search":
                    String nameStudent = request.getParameter("nameStudent");
                    List<Student> studentList = this.iStudentService.searchByName(nameStudent);
                    request.setAttribute("listStudent", studentList);
                    request.setAttribute("nameStudent", nameStudent);
                    request.getRequestDispatcher("list.jsp").forward(request, response);
                    break;
                default:
                    List<StudentDTO> students = this.iStudentService.getAll();
//       Gửi dữ liệu về JSP theo dạng key - value
                    request.setAttribute("listStudent", students);

//        Chuyển trang sử dụng forward.
                    request.getRequestDispatcher("list.jsp").forward(request, response);

            }
        } else {
            response.sendRedirect("/login");
        }
    }
}
