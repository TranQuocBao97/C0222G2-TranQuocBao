package controller;

import model.Customer;
import model.Employee;
import model.Service;
import model.TotalPrice;
import modelDTO.ContractDTO;
import modelDTO.EmployeeDTO;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.ServiceRepository;
import repository.TotalPriceRepository;
import service.ContractService;
import service.interface_service.IContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Contract", value = "/contract")
public class ContractController extends HttpServlet {
    IContractService iContractService = new ContractService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                displayAddContract(request, response);
                break;
            default:
                displayContractList(request, response);
                break;
        }

    }

    private void displayAddContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/contractJSP/contractAdd.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayContractList(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDTO> contractList = iContractService.getListContractDTO();
        List<EmployeeDTO> employeeList = new EmployeeRepository().getAllEmployeeDTO();
        List<Customer> customerList = new CustomerRepository().getAllCustomerMySQL();
        List<Service> serviceList = new ServiceRepository().getAllService();
        List<TotalPrice> totalPriceList = new TotalPriceRepository().getListTotalPrice();
        request.setAttribute("contractList", contractList);
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.setAttribute("totalPriceList",totalPriceList);
        try {
            request.getRequestDispatcher("/contractJSP/contractList.jsp").forward(request, response);
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


    }

}
