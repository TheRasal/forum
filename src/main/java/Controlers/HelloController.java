package Controlers;

import classes.Messages;
import classes.UserDB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/in")
public class HelloController {


    private static final String LOGIN = "newLogin";
    private static final String PASSWORD = "newPassword";
    UserDB addUser = new UserDB();
    private static final String LOGIN1 = "login";
    private static final String PASSWORD1 = "password";
    private static String NICK ;
    private static final String MESSAGE = "message";
    private static final String CHAT = "chat";
    private static ArrayList<Messages> defaultMes = new ArrayList<>();
    private static ArrayList<Messages> firstRoomMes = new ArrayList<>();
    private static ArrayList<Messages> nextRoomMes = new ArrayList<>();

    UserDB getUser = new UserDB();

//    @RequestMapping("/loginUser")
//    public String hello(HttpServletRequest request)
//    {
//        String nick = request.getParameter("nick");
//        request.setAttribute("helloMessage", "Hello " + nick);
//        return "/WEB-INF/pages/nick.jsp";
//    }

    @RequestMapping("/newUser")
    public String serviceNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String thisLogin = request.getParameter(LOGIN);
        String thisPassword = request.getParameter(PASSWORD);
        String thisIp = request.getRemoteAddr();


        if (!thisLogin.equals("") && !thisPassword.equals("")) {
            addUser.addUsers(thisLogin, thisPassword, thisIp);
            request.setAttribute("name", thisLogin);
            return "/WEB-INF/pages/registration.jsp";
        }

        return null;
    }

    @RequestMapping("/loginUser")
    public String serviceLoginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String thisLogin = request.getParameter(LOGIN1);
        String thisPassword = request.getParameter(PASSWORD1);
        String thisIp = request.getRemoteAddr();

        if (!thisLogin.equals("") && !thisPassword.equals("")) {
            String user = getUser.getUsers(thisLogin, thisPassword, thisIp);
            if (user != null) {
                request.setAttribute("name", user);
                return "/WEB-INF/pages/authorizationSuccessful.jsp";
            } else {
                request.setAttribute("name", "логин или пароль введены не верно");
                return "/index.jsp";
            }
        }


        return thisLogin;
    }

    @RequestMapping("/forum")
    public String serviceForum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        String thisMessage = request.getParameter(MESSAGE);
        String thisIp = request.getRemoteAddr();

        if (request.getParameter(CHAT) != null && !request.getParameter(CHAT).equals("")) {
            if (request.getParameter(CHAT).equals("defaultChat")) {
                session.setAttribute("chat", "defaultChat");
                request.setAttribute("message", defaultMes);
            } else if (request.getParameter(CHAT).equals("firstChat")) {
                session.setAttribute("chat", "firstChat");
                request.setAttribute("message", firstRoomMes);
            } else if (request.getParameter(CHAT).equals("nextChat")) {
                session.setAttribute("chat", "nextChat");
                request.setAttribute("message", nextRoomMes);
            }
            return "/WEB-INF/pages/forum.jsp";
        }

        if (thisMessage != null && !thisMessage.equals("")) {
            NICK = new UserDB().getNick(thisIp);
            if (session.getAttribute("chat").equals("defaultChat")) {
                defaultMes.add(new Messages(new Date(System.currentTimeMillis()).toString(), NICK, thisMessage));
                request.setAttribute("message", defaultMes);
            } else if (session.getAttribute("chat").equals("firstChat")) {
                firstRoomMes.add(new Messages(new Date(System.currentTimeMillis()).toString(), NICK, thisMessage));
                request.setAttribute("message", firstRoomMes);
            } else if (session.getAttribute("chat").equals("nextChat")) {
                nextRoomMes.add(new Messages(new Date(System.currentTimeMillis()).toString(), NICK, thisMessage));
                request.setAttribute("message", nextRoomMes);
            }


            return "/WEB-INF/pages/forum.jsp";


        }
        return null;

    }
}
