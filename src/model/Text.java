
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
        System.out.println("Enter an ID of your post");
        identifier=write.nextLine();
        System.out.println("Write date as follows: "
                            + "\nDay/Month/Year");
        date=write.nextLine();
        System.out.println("Write your post: ");        
        inputText=write.nextLine();  
        validateTextLength();
    }
    
    public void validateTextLength(){
        if(inputText.length()<=500){
            text=inputText;
        }else if(inputText.length()>500){

            System.out.println("Only 500 characters");

            System.out.println("Only 500 characteres");

            createText();
        }
    }
    
    @Override
    public String seeContent() {
        return "Text Publishing\n" +
           "ID: " + identifier + "\n" +
           "Date: " + date + "\n" +
           "Content: " + text + "\n" +
           "Reactions: " + numberReaction;
    }  
}
