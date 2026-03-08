
package controller;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class SystemSocial {
    private List<User> listUsers = new ArrayList<User>();
    private User curentUser;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public User getCurentUser() {
        return curentUser;
    }

    public void setCurentUser(User curentUser) {
        this.curentUser = curentUser;
    }
     
    public void addListUser (User user){
       listUsers.add(user);      
    }
    
    public void seeFeed(){
       
    }
    
    public void giveLike(){
    
    }
}
