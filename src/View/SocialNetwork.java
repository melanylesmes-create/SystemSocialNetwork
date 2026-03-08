
package View;
import controller.*;
import java.util.Scanner;
import model.*;

//Prueba de actualizacion Mario cars melany liney 

public class SocialNetwork {

    public static void main(String[] args) {
        Scanner write = new Scanner (System.in);
        SystemSocial systemSocial = new SystemSocial();
        User user1 = new User ("123","Eliana");
        User user2 = new User ("234","Santiago");
        User user3 = new User ("345","Javier");
        
        systemSocial.addListUser(user1);
        systemSocial.addListUser(user2);
        systemSocial.addListUser(user3);
        
        int option;
        System.out.println("Bienvenido a Social Network" + 
                          "\n =========================" +
                          "\n       MENÚ INICIAL       " +
                          "\n 1. Entrar " +
                          "\n 2. Salir  " +
                          "\n =========================");
        option= write.nextInt();
        
        switch (option){
            case 1:
                menuPrincipal();
            break;
            case 2:
                
            break;
            default:
                System.out.println("Opcion no valida");           
        }
                       
    }
    
    
    public static void menuPrincipal(){
        Scanner write = new Scanner (System.in);
        int option1,option2;
        System.out.println("Elige una de las siguientes opciones" +
                           "\n==================================" +
                           "\n 1. Crear Publicacion" +
                           "\n 2. Ver seguidores" +
                           "\n 3. Seguir a un Usuario" +
                           "\n 4. salir" +
                           "\n =================================");
        option1=write.nextInt();
        
        switch (option1){
            case 1:
                do{
                System.out.println("¿Que tipo de Publicacion crearas?" +
                                   "\n 1. Texto" +
                                   "\n 2. Video" +
                                   "\n 3. Imagen.");
                option2=write.nextInt();
                if (option2==1){
                    Text text = new Text();
                    text.createText();
                    
                }else if(option2==2){
                    Video video = new Video();
                    video.createVideo();
                }else if (option2==3){
                    Image image = new Image();
                    image.createImage();
                }else                    
                    System.out.println("Opcion no valida");                                    
                }while(option2>=4);
            break;
            case 2:
                
            break;
            case 3:
                System.out.println("");
            break;
            default:
                System.out.println("Opcion no valida");           
        }
    }
}
