package controller;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.RentTypeService;
import service.ServiceTypeService;
import service.interface_service.IService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Service", value = "/service")
public class ServiceController extends HttpServlet {
    IService iService = new service.Service();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showServiceAddPage(request, response);
                break;
            default:
                displayAllService(request,response);
                break;
        }
    }

    private void displayAllService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iService.getAllService();
        request.setAttribute("serviceList",serviceList);
        try {
            request.getRequestDispatcher("/service/serviceList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showServiceAddPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ServiceType> serviceTypeList = new ServiceTypeService().getListServiceType();
            List<RentType> rentTypeList = new RentTypeService().getListRentType();
            request.setAttribute("serviceTypeList", serviceTypeList);
            request.setAttribute("rentTypeList", rentTypeList);
            request.getRequestDispatcher("service/serviceAdd.jsp").forward(request, response);
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
                addNewService(request, response);
                break;

        }
    }

    private void addNewService(HttpServletRequest request, HttpServletResponse response) {
        Integer idService = null;
        String nameService = request.getParameter("nameService");
        Double area = Double.valueOf(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        Integer maxPeople = Integer.valueOf(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        Double poolArea = Double.valueOf(request.getParameter("poolArea"));
        Integer numberFloor = Integer.valueOf(request.getParameter("numberFloor"));
        Integer rentTypeId = Integer.valueOf(request.getParameter("rentTypeId"));
        Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceTypeId"));
        Service service = new Service(idService, nameService, area, cost,
                maxPeople, standardRoom, description, poolArea, numberFloor,
                new RentType(rentTypeId, null),
                new ServiceType(serviceTypeId, null));
        boolean checkAddService = iService.addNewService(service);
        request.setAttribute("checkAddService",checkAddService);
        try {
            request.getRequestDispatcher("service/serviceAdd.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}