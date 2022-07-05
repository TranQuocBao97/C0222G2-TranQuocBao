package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isSave = request.getParameter("remember");
        if(isSave!=null) {
            if (isSave.equals("on")) {
                Cookie cookieUsername = new Cookie("usernameCookie", username);
                Cookie cookiePassword = new Cookie("passwordCookie", password);
                cookiePassword.setMaxAge(24 * 60 * 60);//second
                response.addCookie(cookiePassword);
                response.addCookie(cookieUsername);
            }
        }
//        if (isCheckAccount(username, password)) {
//               gọi service -> repository viết SQL select * from user where username=? & password = ?
//        }
        request.getSession().setAttribute("usernameSession", username);
        response.sendRedirect("/student");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Cookie[] cookies = request.getCookies();
       for(Cookie cookie: cookies) {
           if(cookie.getName().equals("usernameCookie")){
               request.setAttribute("usernameCookie", cookie.getValue());
           }
           if(cookie.getName().equals("passwordCookie")){
               request.setAttribute("passwordCookie", cookie.getValue());
           }
       }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
