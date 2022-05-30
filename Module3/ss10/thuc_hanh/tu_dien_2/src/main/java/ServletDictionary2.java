import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletDictionary2", value = "/ServletDictionary2")
public class ServletDictionary2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
            
        String yourSearch =  request.getParameter("search");
        String result = null;
       if (dic.containsKey(yourSearch)){
           result=dic.get(yourSearch);
       }else {
           result="cant find this word";
       }
        request.setAttribute("search",yourSearch);
        request.setAttribute("resultWord",result);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
