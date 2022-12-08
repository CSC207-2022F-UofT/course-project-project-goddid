package entities;

import java.io.Serializable;
import java.util.ArrayList;

import static useCases.AccountManager.*;

public class User implements Serializable {
    public ArrayList<User> friends;
    private String username, password;
    public String acc_type;

    public int points;
    public ArrayList<User> blocked_friends;
    public int num_strikes;

    /**
     * @param name
     *
     * User class which is the object (entity) where the users of the app is stored as
     */
    public User(String name){
        this.username = name;
        this.points = 0;
        this.friends = new ArrayList<User>();
    }

    public void setUsername(String name){
        username = name;
    }


    public void setPassword(String pWord){
        password = pWord;
    }

    public void setAccountType(String acc_type){
        this.acc_type = acc_type;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public void setPoints(int p) {

        this.points = p;
    }

    public void setNum_strikes(){
        this.num_strikes = 0;
    }

    public String getUsername() {
        return username;
    }


    public int getPoints() {
        return this.points;
    }


    public String getPassword(  ){
        return password;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public int getNum_strikes(){
        return num_strikes;
    }

    public void addStrike(){
        this.num_strikes += 1;
    }

}