import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "calculator", urlPatterns = "/calculator")
public class calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstNumber = Double.parseDouble(request.getParameter("firstNumber"));
        Double secondNumber = Double.parseDouble(request.getParameter("secondNumber"));
        int operator = Integer.parseInt(request.getParameter("operator"));
        Double result = null;
        int exception = 0;
        if (operator == 1) {
            result = firstNumber + secondNumber;
        } else if (operator == 2) {
            result = firstNumber - secondNumber;
        } else if (operator == 3) {
            result = firstNumber * secondNumber;
        } else if (operator == 4) {
            if (secondNumber == 0) {
                exception = 1;
            } else {
                result = firstNumber / secondNumber;
            }
        }
        request.setAttribute("cantDivision", exception);
        request.setAttribute("lastResult", result);
        request.getRequestDispatcher("result_page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
