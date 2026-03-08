
package model;

import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Image extends Publication {
    private String resolution;
    private int width;
    private int height;
    private String filePath;

    
    public Image(){}
    
    
    public void createImage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo de imagen:");
        filePath = sc.next();

        try {
            File file = new File(filePath);
            BufferedImage img = ImageIO.read(file);
            width = img.getWidth();
            height = img.getHeight();
            System.out.println("Resolucion: "+width+" x "+height);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }


    }
    
    @Override
    public String seeContent() {
        return "Publicación de Imagen\n" +
           "ID: " + identifier + "\n" +
           "Fecha: " + date + "\n" +
           "Resolución: " + resolution + "\n" +
           "Reacciones: " + numberReaction;

    }
    
}
