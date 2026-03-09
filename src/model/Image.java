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
        System.out.println("Enter an ID for your publication");
        identifier = sc.nextLine();
        
        System.out.println("Write the date as follows:" + "\nDay/Month/year");
        date = sc.nextLine();
        
        System.out.println("Enter the image file path:");
        filePath = sc.next();

        try {
            File file = new File(filePath);
            BufferedImage img = ImageIO.read(file);
            width = img.getWidth();
            height = img.getHeight();
            System.out.println("Resolution: " + width + " x " + height);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public String seeContent() {
        return "Publication og Image\n"
                + "ID: " + identifier + "\n"
                + "date: " + date + "\n"
                + "Resolution: " + width + " x " + height + "\n"
                + "Reactions: " + numberReaction;

    }

}
