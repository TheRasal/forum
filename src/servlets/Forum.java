package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/forum")
public class Forum extends HttpServlet {
    private static String NICK;
    private static final String MESSAGE="message";
    private static final String CHAT="chat";
    private static ArrayList<Messages> defaultMes=new ArrayList<>();
    private static ArrayList<Messages> firstRoomMes=new ArrayList<>();
    private static ArrayList<Messages> nextRoomMes=new ArrayList<>();




    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession(true);
        String thisMessage=request.getParameter(MESSAGE);
        String thisIp=request.getRemoteAddr();

        if(request.getParameter(CHAT)!=null&&!request.getParameter(CHAT).equals("")){
        if(request.getParameter(CHAT).equals("defaultChat")) {
            session.setAttribute("chat","defaultChat");
            request.setAttribute("message", defaultMes);
        }else
        if(request.getParameter(CHAT).equals("firstChat")){
            session.setAttribute("chat","firstChat");
            request.setAttribute("message", firstRoomMes);
        }else
        if(request.getParameter(CHAT).equals("nextChat")){
            session.setAttribute("chat","nextChat");
            request.setAttribute("message", nextRoomMes);
        }
        request.getRequestDispatcher("forum.jsp").forward(request,response);
        }

        if (thisMessage!=null&&!thisMessage.equals("")){
           NICK= new UserDB().getNick(thisIp);
           if (session.getAttribute("chat").equals("defaultChat")){
               defaultMes.add(new Messages(new Date(System.currentTimeMillis()).toString(), NICK, thisMessage));
               request.setAttribute("message",defaultMes);
           }else
                if (session.getAttribute("chat").equals("firstChat")){
               firstRoomMes.add(new Messages(new Date(System.currentTimeMillis()).toString(),NICK,thisMessage));
               request.setAttribute("message", firstRoomMes);
                }
                else if (session.getAttribute("chat").equals("nextChat")){
                    nextRoomMes.add(new Messages(new Date(System.currentTimeMillis()).toString(),NICK,thisMessage));
                    request.setAttribute("message", nextRoomMes);
                }


           request.getRequestDispatcher("forum.jsp").forward(request,response);



        }
    }

}
