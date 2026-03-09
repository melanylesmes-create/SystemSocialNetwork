
package model;

import java.util.Scanner;

public class Text extends Publication {
    private String text;
    private String inputText;
    
    public Text(){}

    public Text(String inputText, String identifier, String date) {
        super(identifier, date);
        this.inputText = inputText;
    }
    
    //Metodos Getter y Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
    
    //Metodos propios de la clase
    public void createText(){
        Scanner write = new Scanner(System.in);
        System.out.println("Escriba una identificacion de su publicacion");
        identifier=write.nextLine();
        System.out.println("Escriba fecha de la siguiente manera: "
                            + "\nDía/Mes/año");
        date=write.nextLine();
        System.out.println("Escriba su publiciacion: ");        
        inputText=write.nextLine();  
        validateTextLength();
    }
    
    public void validateTextLength(){
        if(inputText.length()<=500){
            text=inputText;
        }else if(inputText.length()>500){
            System.out.println("Only 500 characteres");
            createText();
        }
    }
    
    @Override
    public String seeContent() {
        return "Publicación de Texto\n" +
           "ID: " + identifier + "\n" +
           "Fecha: " + date + "\n" +
           "Contenido: " + text + "\n" +
           "Reacciones: " + numberReaction;
    }  
}
