package controller;


import modal.Sach;
import service.SachService;
import service.interface_Service.ISachService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Sach", value = "/sach") public class SachController extends HttpServlet {
    ISachService iSachService = new SachService();


    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                listSach(request,response);
                break;
        }
    }



    private void listSach(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> sachList = iSachService.getAllSach();
        request.setAttribute("sachList",sachList);

        try {
            request.getRequestDispatcher("/sach_jsp/sachList.jsp").forward(request,response);
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
