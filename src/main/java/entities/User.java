package entities;

import java.util.ArrayList;

import static useCases.AccountManager.*;

public class User {
    private ArrayList<Vertex> friends;
    private String username, email, password;
    public String acc_type;
    public int points;
    private ArrayList<User> blocked_friends;
    private int num_strikes;

    public User(){
        points = 0;
        friends = new ArrayList<Vertex>();
    }

    public void setUsername(String name){
        username = name;
    }

    public void setEmail(String mail){
        email = mail;
    }

    public void setPassword(String pWord){
        password = pWord;
    }

    public void setAccountType(String acc_type){
        this.acc_type = acc_type;
    }

    public String getAccountType(){
        return this.acc_type;
    }

    public Vertex getEqVertex(User user)
    {
        ArrayList<Vertex> users = user_graph.getVertices();
        for(Vertex i: users)
        {
            if(i.curr_user.equals(user))
                return i;
        }
        return null;
    }

    public void setFriends(ArrayList<Vertex> friends) {
        this.friends = friends;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBlocked_friends(){
        this.blocked_friends = new ArrayList<User>();
    }

    public void setNum_strikes(){
        this.num_strikes = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPoints() {
        return points;
    }

    /*public Boolean getPremium() {
        return premium;
    }*/

    public String getPassword(  ){
        return password;
    }

<<<<<<<<< Temporary merge branch 1
    public ArrayList<User> getBlocked_friends(){
        return blocked_friends;
    }

    public ArrayList<User> getFriends() {
=========
    public ArrayList<Vertex> getFriends() {
>>>>>>>>> Temporary merge branch 2
        return friends;
    }

    public int getNum_strikes(){
        return num_strikes;
    }

    public void addStrike(){
        this.num_strikes += 1;
    }

    public void addblocked(User user){
        blocked_friends.add(user);
    }
}