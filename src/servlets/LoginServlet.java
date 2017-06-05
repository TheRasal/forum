package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN="login";
    private static final String PASSWORD="password";



    UserDB getUser=new UserDB();




    public void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String this_login=request.getParameter(LOGIN.toString());
        String this_password=request.getParameter(PASSWORD.toString());
        String this_ip=request.getRemoteAddr().toString();

        if (!this_login.equals("")&&!this_password.equals("")){
           String user=getUser.getUsers (this_login,this_password,this_ip);
                if (user!=null){
                    request.setAttribute("name",user);
                    request.getRequestDispatcher("authorizationSuccessful.jsp").forward(request,response);
                }
                else{
                    request.setAttribute("name","логин или пароль введены не верно");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            }


    }
}
