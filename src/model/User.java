
package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String identifier;
    private String name;
    private List <User> listFollowers =new ArrayList<User>();
    private List <User> listFollowed =new ArrayList<User>();
    private List <Publication> listPublications =new ArrayList<Publication>();

    public User(){}
    
    public User(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }
    
    //Metodos Getter and Setters
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Metodos de la Clase
    public void addPublication(Publication publication){
        listPublications.add(publication);
    }
    public void followUser(){
    
    }
    
    @Override
    public String toString(){
        return "\nNombre: " + name + "\nIdentificacion: " + identifier;
    }
}
