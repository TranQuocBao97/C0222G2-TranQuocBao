import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProductDiscountCalculator", value = "/ServletProductDiscountCalculator")
public class ServletProductDiscountCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<body>");
        String description = request.getParameter("product_description");
        Double price = null;
        try{
            price = Double.parseDouble(request.getParameter("product_price"));
        }catch (Exception e){
            printWriter.write("cant find price");
            printWriter.write("<br>");
        };

        Integer discount = null;
        try{
            discount = Integer.parseInt(request.getParameter("product_discount"));
        }catch (Exception e){
            printWriter.write("cant find discount");
        }
        Double discount_amount = price * discount * 0.01;
        Double discount_price = price - discount_amount;

        if (discount_amount != null && discount_price != null) {
            printWriter.write("<h4>" + description + "</h4>");
            printWriter.write("<p>" + "discount amount: " + discount_amount + "</p>");
            printWriter.write("<p>" + "discount price: " + discount_price + "</p>");
        } else {
            printWriter.write("not found");
        }
        printWriter.write("</body>");
        printWriter.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
