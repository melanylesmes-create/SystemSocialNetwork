
package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String identifier;
    private String name;
    
    private List <Publication> listPublications =new ArrayList<Publication>();
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();


    public User(){}
    
    public User(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }
    
    //Metodos Getter and Setters
    public String getIdentifier() {
        return identifier;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
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
    public void followUser(){
    
    }


    public List<Publication> getListPublications() {
        return listPublications;
    }

    public void setListPublications(List<Publication> listPublications) {
        this.listPublications = listPublications;
    }
    
    public void addPublication(Publication publication) {
        listPublications.add(publication);
    }
    
    // Método para seguir a otro usuario
    public void followUser(User userToFollow) {
        if(!following.contains(userToFollow)){
        following.add(userToFollow);
        userToFollow.addFollower(this);
        }
    }
    
    // Método para agregar un seguidor
    private void addFollower(User follower) {
        if (!followers.contains(follower)) {
            followers.add(follower);
        }
    }

    // Ver seguidores
    public void seeFollowers() {
        System.out.println("Tus seguidores:");
        if (followers.isEmpty()) {
            System.out.println("No tienes seguidores.");
        } else {
            for (User u : followers) {
                System.out.println("- " + u.getName());
            }
        }
    }

    // Ver seguidos
    public void seeFollowing() {
        System.out.println("Usuarios que sigues:");
        if (following.isEmpty()) {
            System.out.println("No sigues a nadie.");
        } else {
            for (User u : following) {
                System.out.println("- " + u.getName());
            }
        }
    }

    public Publication findPublicationById(String id) {
    for (Publication p : listPublications) {
        if (p.getIdentifier().equals(id)) {
            return p;
        }
    }
    return null;
}
    
    public List<Publication> getPublications() {
    return listPublications;
}
    
    @Override
    public String toString(){
        return "\nNombre: " + name + "\nIdentificacion: " + identifier;
    }
}
