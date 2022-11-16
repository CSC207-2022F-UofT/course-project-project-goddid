package useCases;
import entities.*;
import UI.*;

import java.lang.reflect.Array;
import java.util.*;

public class AccountManager extends User {
    public static Graph user_graph = new Graph();//so that every time a new user is registered (while doing this
    //an object of account manager is created), each object of account manager refers to the same graph.

    public void addUser(String name, String pWord, String mail, String acc_type)
    {
          User new_user = new User();
          new_user.setUsername(name);
          new_user.setEmail(mail);
          new_user.setPassword(pWord);
          new_user.setAccountType(acc_type);
          new_userco.setNum_strikes();
          new_user.setBlocked_friends();
          user_graph.addVertex(new_user.getUsername(), new_user.getAccountType(), new_user);
          //user_graph.getVertices();
    }

    public void addFriend(User user1, User user2)
    {
        ArrayList<Vertex> users = user_graph.getVertices();
        for(Vertex i: users) {
            if (i.curr_user.equals(user1)) {
                Vertex temp = new Vertex(user2.getUsername(), user2.getAccountType(), user2);
                user_graph.addEdge(i, temp);
                break;
            }
        }
    }

    public void removeFriend(User user1, User user2)
    {
        ArrayList<Vertex> users = user_graph.getVertices();
        for(Vertex i: users) {
            if (i.curr_user.equals(user1)) {
                ArrayList<Vertex> temp = i.curr_user.getFriends();
                for(Vertex j: temp)
                    if(j.curr_user.equals(user2))
                        user_graph.removeEdge(i,j);
                break;
            }
        }
    }

    public void removeUser(User curr_user)
    {
        user_graph.removeVertex(curr_user.getUsername(), curr_user.getAccountType(), curr_user);
    }

    public void blockUser(User user1, User user2)
    {
     user_graph.removeEdge(user1.getUsername(), user1.getAccountType(), user1,
             user2.getUsername(), user2.getAccountType(), user2);
     user1.addblocked(user2);
    }

    public Graph getGraph(){
        return user_graph;
    }



}
