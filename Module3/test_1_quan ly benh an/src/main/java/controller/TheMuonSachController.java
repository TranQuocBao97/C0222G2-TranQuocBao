package controller;

import modal.HocSinh;
import modal.Sach;
import modal.TheMuonSach;
import repository.HocSinhRepository;
import repository.SachRepository;
import repository.TheMuonSachRepository;
import repository.interface_repository.ISachRepository;
import service.SachService;
import service.TheMuonSachService;
import service.interface_Service.ISachService;
import service.interface_Service.ITheMuonSachService;
import util.CheckSoLuong;
import util.GetTime;

import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TheMuonSach", value = "/theMuonSach") public class TheMuonSachController extends HttpServlet {
    ISachService iSachService = new SachService();
    ITheMuonSachService iTheMuonSachService = new TheMuonSachService();


    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "addTheMuonSach":
                showAddTheMuonSach(request,response);
                break;
            default:
                dislayListTheMuonSach(request,response);
                break;
        }

    }

    private void dislayListTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        List<TheMuonSach> theMuonSachList = new TheMuonSachRepository().getListTheMuonSach();
        List<Sach> sachList = new SachRepository().getAllSach();
        List<HocSinh> hocSinhList = new HocSinhRepository().getListHocSinh();
        request.setAttribute("sachList",sachList);
        request.setAttribute("hocSinhList",hocSinhList);
        request.setAttribute("theMuonSachList",theMuonSachList);
        try {
            request.getRequestDispatcher("/theMuonSach_jsp/theMuonSachList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        if(CheckSoLuong.checkSoLuong(id)){
            String name = request.getParameter("name");
            List<HocSinh> hocSinhList = new HocSinhRepository().getListHocSinh();
            String dateNow = GetTime.getDateNow();
            List<Sach> sachList = new SachRepository().getAllSach();
            request.setAttribute("idSach",id);
            request.setAttribute("hocSinhList",hocSinhList);
            request.setAttribute("name",name);
            request.setAttribute("dateNow",dateNow);
            request.setAttribute("sachList",sachList);

            try {
                request.getRequestDispatcher("/sach_jsp/sachRent.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            List<Sach> sachList = new SachRepository().getAllSach();
            String mess = "het";
            request.setAttribute("mess",mess);
            request.setAttribute("sachList",sachList);
            try {
                request.getRequestDispatcher("/sach_jsp/sachList.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "addTheMuonSach":
                addTheMuonSach(request,response);
                break;
            case "traSach":
                updateCongValueSoLuongSach(request,response);
                break;

        }


    }

    private void updateCongValueSoLuongSach(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String maMuonSach = request.getParameter("maMuonSach");
        String ngayMuon =request.getParameter("ngayMuonSach");
        String ngayTra = request.getParameter("ngayTraSach");
        String hocSinhId = request.getParameter("hocSinhId");
        String bookId = request.getParameter("idSach");
        TheMuonSach theMuonSach = new TheMuonSach(maMuonSach,ngayMuon,ngayTra,hocSinhId,bookId);

        Map<String,String> mapMess  = iTheMuonSachService.insertTheMuonSach(theMuonSach);


        List<TheMuonSach> theMuonSachList = new TheMuonSachRepository().getListTheMuonSach();
        if(mapMess.containsKey("mess")){
            List<Sach> sachList = new SachRepository().getAllSach();
            List<HocSinh> hocSinhList = new HocSinhRepository().getListHocSinh();
            request.setAttribute("sachList",sachList);
            request.setAttribute("hocSinhList",hocSinhList);
            request.setAttribute("theMuonSachList",theMuonSachList);
            request.setAttribute("mapMess",mapMess);
            try {
                request.getRequestDispatcher("/theMuonSach_jsp/theMuonSachList.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            List<HocSinh> hocSinhList = new HocSinhRepository().getListHocSinh();
            String dateNow = GetTime.getDateNow();
            request.setAttribute("maMuonSach",maMuonSach);
            request.setAttribute("ngayMuon",ngayMuon);
            request.setAttribute("ngayTra",ngayTra);
            request.setAttribute("hocSinhId",hocSinhId);
            request.setAttribute("hocSinhList",hocSinhList);
            request.setAttribute("idSach",bookId);
            request.setAttribute("name",name);
            request.setAttribute("dateNow",dateNow);
            request.setAttribute("mapMess",mapMess);
            try {
                request.getRequestDispatcher("/sach_jsp/sachRent.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}

