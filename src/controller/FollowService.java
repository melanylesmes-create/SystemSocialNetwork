package controller;
import java.util.Scanner;
import model.*;

public class FollowService {
    public static void followUser (User currentUser, SystemSocial systemSocial) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del usuario a seguir:");
        String idFollow = sc.next();

        User userToFollow = null;
        for (User u : systemSocial.getListUsers()) {
            if (u.getIdentifier().equals(idFollow)) {
                userToFollow = u;
                break;
            }
        }

        if (userToFollow != null) {
            currentUser.followUser(userToFollow);
            System.out.println("Ahora sigues a " + userToFollow.getName());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

}
