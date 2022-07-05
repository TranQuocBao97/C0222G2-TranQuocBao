import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        double numberOne = Double.parseDouble(request.getParameter("numberOne"));
        double numberTwo = Double.parseDouble(request.getParameter("numberTwo"));
        double result = numberOne + numberTwo;
        request.setAttribute("temp", result);
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<html>");
//        printWriter.write("<body>");
//        printWriter.write("<h2>" + result + "</h2>");
//        printWriter.write("</body>");
//        printWriter.write("</html>");
    }
}
