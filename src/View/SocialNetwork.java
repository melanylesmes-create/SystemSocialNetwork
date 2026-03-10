package View;

import controller.*;
import java.util.Scanner;
import model.*;
//8:20 mario cars estuvo aqui <3 f1
//yuliana estubo aqui :(
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
        System.out.println("Welcom to Social Network"
                + "\n ========================="
                + "\n          MAIN MENÚ       "
                + "\n 1. Enter "
                + "\n 2. Exit  "
                + "\n =========================");
        option = write.nextInt();
        switch (option) {
            case 1:
                User loggedUser = Login.login(systemSocial);
                if (loggedUser != null) {
                    systemSocial.setCurentUser(loggedUser);
                    mainMenu(systemSocial.getCurentUser(), systemSocial, logout);
                }
                break;
            case 2:
                logout.logout(systemSocial);
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    
   
    
    
    public static void mainMenu(User currentUser, SystemSocial systemSocial, Logout logout) {

        Scanner write = new Scanner(System.in);
        int option1;
        do {
            System.out.println("\n--------------------------"
                    +"         Chose one option           n"
                    + "\n==================================" 
                    + "\n 1. Create Publication"
                    + "\n 2. View followers"
                    + "\n 3. Follow a user"
                    + "\n 4. See feed"
                    + "\n 5. Change user"
                    + "\n 6. Following"
                    + "\n 7. React to a post"
                    + "\n 8. Exit"
                    + "\n =================================");
            option1 = write.nextInt();

            switch (option1) {
                case 1:

                    System.out.println("¿What type of publication will you create?"
                            + "\n 1. Text"
                            + "\n 2. Video"
                            + "\n 3. Image.");
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
                        System.out.println("Invalid Option");
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
                    User neUser = Login.login(systemSocial);
                    if (neUser != null) {
                        systemSocial.setCurentUser(neUser);
                        // Aquí volvemos a mostrar el menú con el nuevo usuario
                        mainMenu(systemSocial.getCurentUser(), systemSocial, logout);
                        return; // importante para que no se quede en el bucle anterior
                    }
                    break;
                    
                case 6:
                    currentUser.seeFollowing();
                    break;
                    
                case 7:
                    System.out.println("Enter the post ID to react:");
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
