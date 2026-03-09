package model;

import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends Publication {
    
    private int width;
    private int height;
    private String filePath;


    
    public Image(){}
    
    //Metodos propios de Imagen
    public void createImage(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una identificacion de su publicacion");
        identifier = sc.nextLine();
        
        System.out.println("Escriba fecha de la siguiente manera: " + "\nDía/Mes/año");
        date = sc.nextLine();
        
        System.out.println("Ingrese la ruta del archivo de imagen:");
        filePath = sc.next();

        try {
            File file = new File(filePath);
            BufferedImage img = ImageIO.read(file);
            width = img.getWidth();
            height = img.getHeight();
            System.out.println("Resolucion: " + width + " x " + height);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    public String seeContent() {
        return "Publicación de Imagen\n"
                + "ID: " + identifier + "\n"
                + "Fecha: " + date + "\n"
                + "Resolución: " + width + " x " + height + "\n"
                + "Reacciones: " + numberReaction;

    }

}
