package Databases;

import entities.Graph;

import java.io.*;

public class ReadGraph implements Serializable{

    public Graph readobject() throws IOException, ClassNotFoundException {
        Graph users = new Graph();
        try {
            FileInputStream fis = new FileInputStream("Users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            users = (Graph) ois.readObject();

            ois.close();
            fis.close();
            return users;
        } catch (EOFException e){
            //users = new Graph();
            return users;
        }


        //return users;



    }
}
