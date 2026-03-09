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

            System.out.println("Enter your user ID:");
            String idLogin = write.next();

            for (User u : systemSocial.getListUsers()) {
                if (u.getIdentifier().equals(idLogin)) {
                    System.out.println("You are logged in as: " + u.getName());
                    return u;
                }
            }
            if (loggedUser == null) {
                System.out.println("User not found. Please try again.");
            }
        }

        return loggedUser;
    }

}
