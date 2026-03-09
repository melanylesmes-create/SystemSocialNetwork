package View;

import controller.*;
import java.util.Scanner;
import model.*;
import controller.*;
//fggfggnxjudbhsi 
public class SocialNetwork {
    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);
        SystemSocial systemSocial = new SystemSocial();
        Logout logout = new Logout();
        User user1 = new User("123", "Eliana");
        User user2 = new User("234", "Santiago");
        User user3 = new User("345", "Javier");

        systemSocial.addListUser(user1);
        systemSocial.addListUser(user2);
        systemSocial.addListUser(user3);

        int option;
        System.out.println("Bienvenido a Social Network"
                + "\n ========================="
                + "\n       MENÚ INICIAL       "
                + "\n 1. Entrar "
                + "\n 2. Salir  "
                + "\n =========================");
        option = write.nextInt();
        switch (option) {
            case 1:
                User loggedUser = Login.iniciarSesion(systemSocial);
                if (loggedUser != null) {
                    systemSocial.setCurentUser(loggedUser);
                    menuPrincipal(systemSocial.getCurentUser(), systemSocial, logout);
                }
                break;
            case 2:
                logout.logout(systemSocial);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    
   
    
    
    public static void menuPrincipal(User currentUser, SystemSocial systemSocial, Logout logout) {

        Scanner write = new Scanner(System.in);
        int option1;
        do {
            System.out.println("Elige una de las siguientes opciones"
                    + "\n=================================="
                    + "\n 1. Crear Publicacion"
                    + "\n 2. Ver seguidores"
                    + "\n 3. Seguir a un usuario"
                    + "\n 4. Ver feed"
                    + "\n 5. Cambiar de usuario"
                    + "\n 6. siguiendo"
                    + "\n 7. Reaccionar a una publicacion"
                    + "\n 8. Salir"
                    + "\n =================================");
            option1 = write.nextInt();

            switch (option1) {
                case 1:

                    System.out.println("¿Que tipo de Publicacion crearas?"
                            + "\n 1. Texto"
                            + "\n 2. Video"
                            + "\n 3. Imagen.");
                    int option2 = write.nextInt();
                    
                    if (option2 == 1) {
                        Text text = new Text();
                        text.createText();
                        currentUser.addPublication(text);
                    } else if (option2 == 2) {
                        Video video = new Video();
                        video.createVideo();
                        currentUser.addPublication(video);
                    } else if (option2 == 3) {
                        Image image = new Image();
                        image.createImage();
                        currentUser.addPublication(image);
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;
                    
                case 2:
                    currentUser.seeFollowers();
                    break;
                    
                case 3:
                    User.followUser(currentUser, systemSocial);
                    break;
                    
                case 4:
                    systemSocial.seeFeed(currentUser);
                    break;
                    
                case 5:
                    User neUser = Login.iniciarSesion(systemSocial);
                    if (neUser != null) {
                        systemSocial.setCurentUser(neUser);
                        // Aquí volvemos a mostrar el menú con el nuevo usuario
                        menuPrincipal(systemSocial.getCurentUser(), systemSocial, logout);
                        return; // importante para que no se quede en el bucle anterior
                    }
                    break;
                    
                case 6:
                    currentUser.seeFollowing();
                    break;
                    
                case 7:
                    System.out.println("Ingrese el ID de la publicación a reaccionar:");
                    String idPub = write.next();
                    systemSocial.reactToPublication(idPub);
                    break;
                    
                case 8:
                    logout.logout(systemSocial);
                    break;
            }
        } while (option1 != 8);
    }
}
