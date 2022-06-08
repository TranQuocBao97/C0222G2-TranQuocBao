package controller;

import model.Division;
import model.EducationDegree;
import model.Employee;
import model.EmployeePosition;
import modelDTO.EmployeeDTO;
import repository.DivisionRepository;
import repository.EducationDegreeRepository;
import repository.EmployeePositionRepository;
import service.EmployeeService;
import service.interface_service.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Employee", value = "/employee")
public class EmployeeController extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddEmployee(request, response);
                break;
            default:
                displayAllListEmployee(request, response);
                break;
        }
    }

    private void showAddEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
        List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
        List<Division> divisionList = new DivisionRepository().getListDivision();
        request.setAttribute("employeePositionList", employeePositionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        try {
            request.getRequestDispatcher("employee/employeeAdd.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAllListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
        List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
        List<Division> divisionList = new DivisionRepository().getListDivision();
        List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("employeePositionList", employeePositionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                break;
            case "delete":
                deleteEmployeeById(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String searchId = request.getParameter("searchId");
        String searchName = request.getParameter("searchName");
        String searchPosition = request.getParameter("searchPosition");
        String searchDivision = request.getParameter("searchDivision");


        List<EmployeeDTO> employeeList = iEmployeeService.searchAllEmployeeDTO(searchId, searchName, searchPosition, searchDivision);
        request.setAttribute("employeeList", employeeList);

        List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
        List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
        List<Division> divisionList = new DivisionRepository().getListDivision();
        request.setAttribute("employeePositionList", employeePositionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.valueOf(request.getParameter("position"));
        EmployeePosition employeePosition = new EmployeePosition(positionId);
        Integer educationId = Integer.valueOf(request.getParameter("education"));
        EducationDegree educationDegree = new EducationDegree(educationId);
        Integer divisionId = Integer.valueOf(request.getParameter("division"));
        Division division = new Division(divisionId);

        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, employeePosition, educationDegree, division);

        boolean checkEdit = iEmployeeService.editEmployee(employee);
        List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
        List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
        List<Division> divisionList = new DivisionRepository().getListDivision();
        List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("employeePositionList", employeePositionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("checkEdit", checkEdit);
        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        boolean checkDelete = iEmployeeService.deleteEmployeeById(id);
        request.setAttribute("checkDelete", checkDelete);
        List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
        request.setAttribute("employeeList", employeeList);

        List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
        List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
        List<Division> divisionList = new DivisionRepository().getListDivision();
        request.setAttribute("employeePositionList", employeePositionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = null;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer employeePositionId = Integer.valueOf(request.getParameter("position"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("educationDegree"));
        Integer divisionId = Integer.valueOf(request.getParameter("division"));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address,
                new EmployeePosition(employeePositionId), new EducationDegree(educationDegreeId),
                new Division(divisionId));
        Map<String, String> messMap = iEmployeeService.addEmployee(employee);
        request.setAttribute("messMap", messMap);
        if (messMap.containsKey("mess")) {
            List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
            List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
            List<Division> divisionList = new DivisionRepository().getListDivision();
            List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
            request.setAttribute("employeeList", employeeList);
            request.setAttribute("employeePositionList", employeePositionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);
            try {
                request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("employee", employee);
            List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
            List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
            List<Division> divisionList = new DivisionRepository().getListDivision();
            request.setAttribute("employeePositionList", employeePositionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);
            try {
                request.getRequestDispatcher("/employee/employeeAdd.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ;
//        for (String str : messMap.keySet()){
//            if(str.equals("mess")){
//                List<EmployeePosition> employeePositionList = new EmployeePositionRepository().getListEmployeePosition();
//                List<EducationDegree> educationDegreeList = new EducationDegreeRepository().getListEducationDegree();
//                List<Division> divisionList = new DivisionRepository().getListDivision();
//                List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
//                request.setAttribute("employeeList", employeeList);
//                request.setAttribute("employeePositionList", employeePositionList);
//                request.setAttribute("educationDegreeList", educationDegreeList);
//                request.setAttribute("divisionList", divisionList);
//                try {
//                    request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
//                } catch (ServletException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }


    }
}
