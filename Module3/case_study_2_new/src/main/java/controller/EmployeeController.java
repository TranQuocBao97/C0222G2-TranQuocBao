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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
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
        request.setAttribute("searchId",searchId);
        request.setAttribute("searchName",searchName);
        request.setAttribute("searchPosition",searchPosition);
        request.setAttribute("searchDivision",searchDivision);
        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = null;
        try{
            id = Integer.valueOf(request.getParameter("id"));
        }catch (Exception e){
            e.printStackTrace();
        }

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = null;
        try{
            salary = Double.parseDouble(request.getParameter("salary"));
        }catch (Exception e){
            e.printStackTrace();
        }
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = null;
        try {
            positionId = Integer.valueOf(request.getParameter("position"));
        }catch (Exception e){
            e.printStackTrace();
        }
        EmployeePosition employeePosition = null;
        try{
            employeePosition = new EmployeePosition(positionId);
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer educationId = null;
        try{
            educationId = Integer.valueOf(request.getParameter("education"));
        }catch (Exception e){
            e.printStackTrace();
        }

        EducationDegree educationDegree = new EducationDegree(educationId);
        Integer divisionId = Integer.valueOf(request.getParameter("division"));
        Division division = new Division(divisionId);
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, employeePosition, educationDegree, division);


        Map<String,String> messMapEdit = iEmployeeService.editEmployee(employee);
        request.setAttribute("messMapEdit",messMapEdit);

        if(messMapEdit.containsKey("mess")){
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
            List<EmployeeDTO> employeeList = iEmployeeService.getAllEmployeeDTO();
            request.setAttribute("employeeList", employeeList);
            String positionName =null;
            String EducationName =null;
            String DivisionName = null;

            for(EmployeeDTO employeeDTO : employeeList){
                if(employeeDTO.getId().equals(id)){
                    positionName = employeeDTO.getPositionName();
                    EducationName =employeeDTO.getEducationName();
                    DivisionName = employeeDTO.getDivisionName();
                }
            }
            EmployeeDTO employeeDTO = new EmployeeDTO (id, name, birthday, idCard, salary, phone, email, address, positionName, EducationName, DivisionName);

            request.setAttribute("employeeEdit", employeeDTO);
            messMapEdit.put("validate","false");

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
        Map<String,String> messMap = new HashMap<>();
        Integer id = null;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = null;
        if(!request.getParameter("salary").isEmpty()){
            try {
                salary = Double.valueOf(request.getParameter("salary"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer employeePositionId = null;
        try {
            employeePositionId = Integer.valueOf(request.getParameter("position"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer educationDegreeId = null;
        try {
            educationDegreeId = Integer.valueOf(request.getParameter("educationDegree"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer divisionId = null;
        try {
            divisionId = Integer.valueOf(request.getParameter("division"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address,
                new EmployeePosition(employeePositionId), new EducationDegree(educationDegreeId),
                new Division(divisionId));

        messMap = iEmployeeService.addEmployee(employee);
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
        } else {
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


    }
}
