package servlets;

import java.util.ArrayList;
import java.util.stream.Stream;

public class UserDB {
    private static ArrayList<LoginBase> users=new ArrayList();





    public void addUsers(String login, String password, String ip){
      users.add(new LoginBase(login,password,ip));
          }

    public ArrayList<LoginBase> getUsers() {
        return users;
    }

    public void setUsers() {
        this.users = users;
    }

    public String getUsers(String login, String password, String ip){
        String this_user=null;
        for (LoginBase user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                user.setIp(ip);
                this_user=user.getLogin();


            }

        }
        return this_user;
    }

    public String getNick (String ip){
        String thisNick="";
        for (LoginBase nick:users){
            if (nick.getIp().equals(ip)){
                thisNick=nick.getLogin();
                return thisNick;
            }

        }
        return thisNick;
    }


}

