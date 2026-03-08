
package controller;

public class Logout {
    public void logout(SystemSocial system){
        system.setCurentUser(null);
        System.out.println("Su Usuario es: " +system.getCurentUser());
        System.out.println("Cerrando sesion....");
        System.out.println("....");
        System.out.println("....");
        System.out.println("....");
    }
}
