package controller;

import model.Customer;
import model.CustomerType;
import service.CustomerServiceImpl;
import service.ICustomerService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {

    private ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "create":
                saveCustomer(request, response);
                break;


        }
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));

        Customer customer = new Customer(name, gender, birthday, customerTypeId);
        System.out.println(customer.getName());
        System.out.println(customer.getCustomerTypeId());
        System.out.println(customer.getGender());
        System.out.println(customer.getBirthday());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(request, response);
                break;

            default:
                findAll(request, response);
                break;
        }
    }
    public void showCreate(HttpServletRequest request, HttpServletResponse response){
        List<CustomerType> customerTypeList = iCustomerService.findAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void findAll(HttpServletRequest request, HttpServletResponse response){

        List<Customer> customerList = iCustomerService.findAll();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
