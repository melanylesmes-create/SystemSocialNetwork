
package model;

import controller.SystemSocial;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String identifier;
    private String name;
    
    private List <Publication> listPublications =new ArrayList<Publication>();
    private List<User> listFollowers = new ArrayList<>();
    private List<User> listFollowing = new ArrayList<>();

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
        return listFollowers;
    }

    public void setFollowers(List<User> followers) {
        this.listFollowers = followers;
    }

    public List<User> getFollowing() {
        return listFollowing;
    }

    public void setFollowing(List<User> following) {
        this.listFollowing = following;
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
        if(!listFollowing.contains(userToFollow)){
        listFollowing.add(userToFollow);
        userToFollow.addFollower(this);
        }
    }
    
    // Método para agregar un seguidor
    private void addFollower(User follower) {
        if (!listFollowers.contains(follower)) {
            listFollowers.add(follower);
        }
    }

    // Ver seguidores
    public void seeFollowers() {
        System.out.println("Tus seguidores:");
        if (listFollowers.isEmpty()) {
            System.out.println("No tienes seguidores.");
        } else {
            for (User u : listFollowers) {
                System.out.println("- " + u.getName());
            }
        }
    }

    // Ver seguidos
    public void seeFollowing() {
        System.out.println("Usuarios que sigues:");
        if (listFollowing.isEmpty()) {
            System.out.println("No sigues a nadie.");
        } else {
            for (User u : listFollowing) {
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
    
    public static void followUser (User currentUser, SystemSocial systemSocial) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the user to follow:");
        String idFollow = sc.next();

        User userToFollow = null;
        for (User u : systemSocial.getListUsers()) {
            if (u.getIdentifier().equals(idFollow)) {
                userToFollow = u;
                break;
            }
        }

        if (userToFollow != null) {
            currentUser.followUser(userToFollow);
            System.out.println("Now you follow: " + userToFollow.getName());
        } else {
            System.out.println("User not found.");
        }
    }
    @Override
    public String toString(){
        return "\nNombre: " + name + "\nIdentificacion: " + identifier;
    }
}
