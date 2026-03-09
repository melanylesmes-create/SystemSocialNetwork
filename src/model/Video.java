
package model;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.googlecode.mp4parser.util.Path;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Video extends Publication {
    
    private int duration;
    private String filePath;
    
    public Video(){}
    
    public void createVideo(){
        Scanner write = new Scanner (System.in);
        System.out.println("Escriba una identificacion de su publicacion");
        identifier=write.nextLine();
        
        System.out.println("Escriba fecha de la siguiente manera: " + "\nDía/Mes/año");
        date=write.nextLine();
        
        System.out.println("*Recomendacion: los slash deben ir / " + "\nIngrese la ruta del archivo del video:");
        filePath=write.nextLine();
        
        //File representa el archivo del Sistema 
        File file = new File(filePath); 
        
        if(file.exists()) {
            duration= (int) getVideoDuration(filePath);
            System.out.println("Duracion del video: " + duration + " segundos ");
        }else 
            System.out.println("No se encontro el archivo :D");
    }
    
    //Metodo con isoparser para duración de video solo con MP4 funciona!
    //Metodo incluye aspectjrt -1.9.19 para que funcione
    public double getVideoDuration(String filePath){
        try{
            //Propio del Isoparser para leer el MP4
            IsoFile isoFile = new IsoFile(filePath);
            //Busca donde se encuentra la duracion
            MovieHeaderBox mvhd = Path.getPath(isoFile, "moov/mvhd");
            double durationVideo = (double) mvhd.getDuration() / mvhd.getTimescale();
            isoFile.close();
            return durationVideo;
        }catch(Exception e){
            System.out.println("Error al leer la duración del video");
            return 0;
        }
    }
    
    @Override
    public String seeContent() {
        return "Publicación de Video\n" +
           "ID: " + identifier + "\n" +
           "Fecha: " + date + "\n" +
           "Duración: " + duration + " segundos\n" +
           "Reacciones: " + numberReaction;

    }
    
}
