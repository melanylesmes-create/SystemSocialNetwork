
package model;

public class Video extends Publication {
    private int duration;
    
    public Video(){}
    public void createVideo(){
        
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
