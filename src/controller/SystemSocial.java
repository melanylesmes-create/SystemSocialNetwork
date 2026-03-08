package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.User;
import java.util.*;
import model.Publication;

public class SystemSocial {

    private List<User> listUsers = new ArrayList<User>();
    private User curentUser;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public User getCurentUser() {
        return curentUser;
    }

    public void setCurentUser(User curentUser) {
        this.curentUser = curentUser;
    }

    public void addListUser(User user) {
        listUsers.add(user);
    }

    public void seeFeed(User user) {
        List<Publication> feed = new ArrayList<>();

        // Recorremos los usuarios seguidos
        for (User followed : user.getFollowing()) {
            feed.addAll(followed.getListPublications());
        }

        // Ordenamos por fecha (suponiendo formato "dd/MM/yyyy")
        Collections.sort(feed, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                try {
                    Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(p1.getDate());
                    Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(p2.getDate());
                    return d1.compareTo(d2);
                } catch (Exception e) {
                    return 0;
                }
            }
        });

        // Mostramos el contenido
        for (Publication pub : feed) {
            System.out.println(pub.seeContent());
            System.out.println("-------------------------");
        }
    }

    public Publication findPublicationById(String id) {
        for (User u : listUsers) {
            Publication pub = u.findPublicationById(id);
            if (pub != null) {
                return pub;
            }
        }
        return null;
    }

    public void reactToPublication(String idPub) {
        Publication pub = findPublicationById(idPub);
        if (pub != null) {
            pub.react();
            System.out.println("Has reaccionado a la publicación " + idPub);
        } else {
            System.out.println("Publicación no encontrada");
        }
    }

    public void giveLike() {

    }
}
