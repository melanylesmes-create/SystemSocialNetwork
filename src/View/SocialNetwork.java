package View;

import controller.*;
import java.util.Scanner;
import model.*;
import controller.*;

//Prueba de actualizacion Mario cars melany liney 
public class SocialNetwork {

    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);
        SystemSocial systemSocial = new SystemSocial();
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
                    menuPrincipal(systemSocial.getCurentUser(), systemSocial);
                }

                break;

            case 2:

                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    public static void menuPrincipal(User currentUser, SystemSocial systemSocial) {
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
                    + "\n 6. Salir"
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
                    break;
                case 3:
                    System.out.println("Ingrese el ID del usuario a seguir:");
                    String idFollow = write.next();
                    for (User user : systemSocial.getListUsers()) {
                        if (user.getIdentifier().equals(idFollow)) {
                            currentUser.followUser(user);
                            System.out.println("Ahora sigues a " + user.getName());
                        }
                    }

                    break;
                case 4:
                    systemSocial.seeFeed(currentUser);
                    break;
                case 5:
                    User nuevoUsuario = Login.iniciarSesion(systemSocial);
                    if (nuevoUsuario != null) {
                        currentUser = nuevoUsuario;
                        systemSocial.setCurentUser(nuevoUsuario);
                    }
                    break;

                default:
                    System.out.println("Saliste del sistema");
            }
        } while (option1 != 5);

    }

}
