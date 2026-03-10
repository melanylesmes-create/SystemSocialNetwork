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
    private double duration;
    private String filePath;
    public Video(){}
    public void createVideo(){
        Scanner write = new Scanner (System.in);
        System.out.println("Enter an ID for your publication");
        identifier=write.nextLine();
        
        System.out.println("Write the date as follows:" + "\nDay/Month/year");
        date=write.nextLine();
        
        System.out.println("Recommendation: slash / " + "\nEnter the video file path:");
        filePath=write.nextLine();
        
        //File representa el archivo del Sistema 
        File file = new File(filePath); 
        
        if(file.exists()) {
            duration= (double) getVideoDuration(filePath);
            System.out.println("Duration of video: " + duration + " minutes with seconds ");
        }else 
            System.out.println("The file was not found :D");
    }
    public double getVideoDuration(String filePath){
        try{
            //Propio del Isoparser para leer el MP4
            IsoFile isoFile = new IsoFile(filePath);
            //Busca donde se encuentra la duracion
            MovieHeaderBox mvhd = Path.getPath(isoFile, "moov/mvhd");
            double durationVideo = (double) mvhd.getDuration() / mvhd.getTimescale();
            isoFile.close();
            return Math.round((durationVideo / 60.0) * 100.0) / 100.0;
        }catch(Exception e){
            System.out.println("Error reading video duration");
            return 0;
        }
    }
    @Override
    public String seeContent() {
        return "Publication of Video\n"
       + "ID: " + identifier + "\n"
       + "Date: " + date + "\n"
       + "Duration: " + duration + " segundos\n"
       + "Reactions: " + numberReaction;
    }
}
