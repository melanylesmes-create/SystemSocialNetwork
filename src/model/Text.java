
package model;

import java.util.Scanner;

public class Text extends Publication {
    private String text;
    private String inputText;
    
    public Text(){}
    
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
    
    public String validateTextLength(){
        if(inputText.length()<=500){
            text=inputText;
        }else if(inputText.length()>500){
            System.out.println("Maximo 500 caracteres");
            createText();
        }
     return text;
    }
    
    @Override
    public String seeContent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
