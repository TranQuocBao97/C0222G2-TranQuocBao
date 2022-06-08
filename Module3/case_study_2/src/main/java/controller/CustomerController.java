package controller;

import model.Customer;
import repository.CustomerRepository;
import repository.interface_customer_repository.ICustomerRepository;
import service.CustomerService;
import service.interface_service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Customer", value = "/customer")
public class CustomerController extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                request.getRequestDispatcher("customer/customerAdd.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                displayAllListEmployee(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        Integer idEdit = Integer.parseInt(request.getParameter("id"));
        List<Customer> listCustomer = iCustomerService.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("idEdit",idEdit);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAllListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> listCustomer = iCustomerService.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
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
                addCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                displayAllListEmployee(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("name");
        List<Customer> listCustomer = iCustomerService.searchByNameCustomer(nameSearch);
        request.setAttribute("listCustomer",listCustomer);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = null;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer type = Integer.valueOf(request.getParameter("type"));
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, type);
        boolean checkAdded = iCustomerService.addCustomer(customer);

        request.setAttribute("checkAdded", checkAdded);
        try {
            request.getRequestDispatcher("/customer/customerAdd.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId);
        boolean checkEditCustomer = iCustomerService.editCustomerByID(customer);
        List<Customer> listCustomer = iCustomerService.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("checkEditCustomer", checkEditCustomer);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer idCustomerForDelete = Integer.valueOf(request.getParameter("id"));
        boolean checkDeleteCustomer = iCustomerService.deleteCustomer(idCustomerForDelete);
        List<Customer> listCustomer = iCustomerService.getAllCustomer();
        request.setAttribute("checkDeleteCustomer", checkDeleteCustomer);
        request.setAttribute("listCustomer", listCustomer);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
