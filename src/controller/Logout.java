
package controller;

public class Logout {
    public void logout(SystemSocial system){
        system.setCurentUser(null);
        System.out.println("Your user is: " +system.getCurentUser());
        System.out.println("Closing session....");
        System.out.println("....");
        System.out.println("....");
        System.out.println("....");
    }
}
