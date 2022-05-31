package controller;

import model.Product;
import service.IProductService;
import service.impl_service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    IProductService iProductService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action== null){
            action="";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("product/create.jsp").forward(request,response);
                break;
            case "edit":
                Integer idEdit = Integer.parseInt(request.getParameter("id"));
                Product productEdit = iProductService.findById(idEdit);
                request.setAttribute("product",productEdit);
                request.getRequestDispatcher("product/edit.jsp").forward(request,response);
                break;
            case "delete":
                Integer idDelete = Integer.parseInt(request.getParameter("id"));
                Product productDelete = iProductService.findById(idDelete);
                request.setAttribute("product",productDelete);
                request.getRequestDispatcher("product/delete.jsp").forward(request,response);
                break;
            case "display":
                Integer idDisplay = Integer.parseInt(request.getParameter("id"));
                Product productDisplay = iProductService.findById(idDisplay);
                request.setAttribute("product",productDisplay);
                request.getRequestDispatcher("product/display.jsp").forward(request,response);
                break;
            case "search":
                break;
            default:
                List<Product> products = this.iProductService.displayAll();
                request.setAttribute("listProduct",products);
                request.getRequestDispatcher("product/list.jsp").forward(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action== null){
            action="";
        }
        switch (action){
            case "create":
                Integer idCreate = iProductService.findNextId();
                String nameCreate = request.getParameter("name");
                Double priceCreate = Double.parseDouble(request.getParameter("price"));
                String informationCreate = request.getParameter("information");
                String companyCreate = request.getParameter("company");
                Product productCreate = new Product(idCreate,nameCreate,priceCreate,informationCreate,companyCreate);
                iProductService.save(productCreate);
                request.setAttribute("mess","New product was created");
                request.getRequestDispatcher("product/create.jsp").forward(request,response);
//                response.sendRedirect("/product");
                break;
            case "edit":
                Integer idEdit = Integer.parseInt(request.getParameter("id"));
                String nameEdit = request.getParameter("name");
                Double priceEdit = Double.parseDouble(request.getParameter("price"));
                String informationEdit = request.getParameter("information");
                String companyEdit = request.getParameter("company");
                Product productEdit =  iProductService.findById(idEdit);
                productEdit.setName(nameEdit);
                productEdit.setPrice(priceEdit);
                productEdit.setInformation(informationEdit);
                productEdit.setCompany(companyEdit);
                request.setAttribute("mess","Product was updated");
                request.getRequestDispatcher("product/edit.jsp").forward(request,response);
                break;
            case "delete":
                Integer idDelete = Integer.parseInt(request.getParameter("id"));
                iProductService.remove(idDelete);
                request.setAttribute("mess","Product was Deleted");
                request.getRequestDispatcher("product/delete.jsp").forward(request,response);
                break;
            case "display":
                break;
            case "search":
                String nameSearch = request.getParameter("search");
                List<Product> productsSearch = iProductService.search(nameSearch);
                request.setAttribute("listProductSearch",productsSearch);
                request.getRequestDispatcher("product/search.jsp").forward(request,response);
                break;
            default:
                List<Product> products = this.iProductService.displayAll();
                request.setAttribute("listProduct",products);
                request.getRequestDispatcher("product/list.jsp").forward(request,response);
        }
    }
}
