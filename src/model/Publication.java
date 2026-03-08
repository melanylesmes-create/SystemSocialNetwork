
package model;

public abstract class Publication {
    protected String identifier;
    protected String date;
    protected int numberReaction;

    public Publication(String identifier, String date) {
        this.identifier = identifier;
        this.date = date;
    }
    
    public Publication(){}
    
    //Metodos Getter y Setter
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public int giveNumberReaction(){
        return 0;
    }
    public int getNumberReaction() {
        return 0;
    }
    public int setNumberReaction(){
        return 0;
    }
    
    // Método para reaccionar
    public void react() {
        numberReaction++;
    }

    // Método para ver las reacciones
    public void seeReactions() {
        System.out.println("Reacciones: " + numberReaction);
    }

    
    public abstract String seeContent();
}
