package controller;

import java.util.Scanner;
import model.*;

public class Login {

    public SystemSocial validateUser(String indentifier) {
        return null;
    }

    public static User login(SystemSocial systemSocial) {
        Scanner write = new Scanner(System.in);
        User loggedUser = null;

        while (loggedUser == null) {

            System.out.println("Ingrese su ID de usuario:");
            String idLogin = write.next();

            for (User u : systemSocial.getListUsers()) {
                if (u.getIdentifier().equals(idLogin)) {
                    System.out.println("Has iniciado sesión como: " + u.getName());
                    return u;
                }
            }
            if (loggedUser == null) {
                System.out.println("Usuario no encontrado. Intente nuevamente");
            }
        }

        return loggedUser;
    }

}
