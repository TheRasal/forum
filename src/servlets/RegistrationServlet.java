package servlets;

import sun.rmi.runtime.Log;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/newUser")
public class RegistrationServlet extends HttpServlet {
    private static final String LOGIN="new_login";
    private static final String PASSWORD="new_password";
        UserDB addUser=new UserDB();






    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String this_login=request.getParameter(LOGIN.toString());
        String this_Password=request.getParameter(PASSWORD.toString());
        String this_ip= request.getRemoteAddr().toString();


        if (!this_login.equals("")&&!this_Password.equals("")){
            addUser.addUsers(this_login,this_Password,this_ip);
            request.setAttribute("name",this_login);
            request.getRequestDispatcher("registration.jsp").forward(request,response);
        }


    }
    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }



}
