package controller;

import model.Floor;
import model.Land;
import model.Status;
import model.Type;
import repository.FloorRepository;
import repository.LandRepository;
import repository.StatusRepository;
import repository.TypeRepository;
import service.LandService;
import service.interface_service.ILandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Land", value = "/land")
public class LandController extends HttpServlet {
    ILandService iLandService = new LandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showPageAddLand(request,response);
                break;
            default:
               showLandList(request,response);
                break;
        }
    }

    private void showPageAddLand(HttpServletRequest request, HttpServletResponse response) {
        List<Status> statusList = new StatusRepository().getListStatus();
        List<Type> typeList = new TypeRepository().getListType();
        List<Floor> floorList = new FloorRepository().getListFloor();
        request.setAttribute("floorList",floorList);
        request.setAttribute("statusList",statusList);
        request.setAttribute("typeList",typeList);
        try {
            request.getRequestDispatcher("/land/landAdd.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLandList(HttpServletRequest request, HttpServletResponse response) {
        List<Land> landList = new LandRepository().getLandList();
        List<Status> statusList = new StatusRepository().getListStatus();
        List<Type> typeList = new TypeRepository().getListType();
        request.setAttribute("landList",landList);
        request.setAttribute("statusList",statusList);
        request.setAttribute("typeList",typeList);
        try {
            request.getRequestDispatcher("/land/landList.jsp").forward(request,response);
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
            case "create":
                insertLand(request,response);
                break;
        }
    }

    private void insertLand(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idLand");
        Double area = null;
        try{
            area = Double.valueOf(request.getParameter("area"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer statusId = null;
        try{
            statusId = Integer.valueOf(request.getParameter("statusId"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer floorNumber = null;
        try{
            floorNumber = Integer.valueOf(request.getParameter("floorNumber"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Integer typeId = null;
        try{
            typeId = Integer.valueOf(request.getParameter("typeId"));
        }catch (Exception e){
            e.printStackTrace();
        }

        String information = request.getParameter("information");

        Double price = null;
        try{
            price = Double.valueOf(request.getParameter("price"));
        }catch (Exception e){
            e.printStackTrace();
        }

        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        System.out.println(dateStart);
        Land land = new Land(id,area,statusId,floorNumber,typeId,information,price,dateStart,dateEnd);

        Map<String,String> messMap = iLandService.insertLand(land);


    }
}
