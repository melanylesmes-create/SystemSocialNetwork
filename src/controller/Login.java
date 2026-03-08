
package controller;
import java.util.Scanner;
import model.*;

public class Login {
  
    public SystemSocial validateUser(String indentifier){
        return null;
    }
    public static User iniciarSesion(SystemSocial systemSocial) {
        Scanner write = new Scanner(System.in);

        System.out.println("Ingrese su ID de usuario:");
        String idLogin = write.next();

        for (User u : systemSocial.getListUsers()) {
            if (u.getIdentifier().equals(idLogin)) {
                System.out.println("Has iniciado sesión como: " + u.getName());
                return u;
            }
        }

        System.out.println("Usuario no encontrado.");
        return null;
    }

}
