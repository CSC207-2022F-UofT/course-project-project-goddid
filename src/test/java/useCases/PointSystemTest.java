package useCases;

import useCases.EventPackage.Event;
import PointSystem.PointSystemR;
import PointSystem.PointSystemS;
import entities.Graph;
import entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointSystemTest {

    Graph graph;

    AccountManager accountManager = new AccountManager();
    User curUser, user2, user3, user4, user5;

    ArrayList<User> alphaFriends, deltaFriends;


    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        graph = new Graph();

        curUser = new User("");
        curUser.setUsername("Alpha");
        curUser.setAccountType("casual");
        accountManager.addUser(curUser);


        user2 = new User("");
        user2.setUsername("Beta");
        user2.setAccountType("casual");
        accountManager.addUser(user2);

        user3 = new User("");
        user3.setUsername("Charlie");
        user3.setAccountType("casual");
        accountManager.addUser(user3);

        user4 = new User("");
        user4.setUsername("Delta");
        user4.setAccountType("casual");
        accountManager.addUser(user4);


        user5 = new User("");
        user5.setUsername("Echo");
        user5.setAccountType("casual");
        accountManager.addUser(user5);


        accountManager.addFriend(user2, user3);
        accountManager.addFriend(user2, user4);
        accountManager.addFriend(user2, user5);


    }

    @AfterEach
    void tearDown() {
    }


    /**
     * tests that a chat-end results ın both user's poınts beıng updated
     * @throws IOException
     */
    @Test
    void RenewTest() throws IOException {
        ArrayList<User> userlist = new ArrayList<>();
        userlist.add(user2);
        userlist.add(user3);
        PointSystemR testPS = new PointSystemR();

        Event e1 = new Event("ChatEnd", userlist);
        e1.execute(testPS);

        assertEquals(user2.points, 10);
        assertEquals(user3.points, 10);
    }

    /**
     * tests that a user's poınts are deducted successfully after spendıng behavıor
     * @throws IOException
     */
    @Test
    void SpendTest() throws IOException {  // also tests that non-involved user vertices are not touched
        ArrayList<User> userlist = new ArrayList<>();
        userlist.add(user2);
        userlist.add(user3);
        PointSystemR testPS = new PointSystemR();

        Event e1 = new Event("ChatEnd", userlist);
        e1.execute(testPS);

        ArrayList<User> ul2 = new ArrayList<User>();
        PointSystemS t = new PointSystemS();
        ul2.add(user2);
        Event e2 =  new Event("SpendSkip", ul2);
        e2.execute(t);

        assertEquals(user2.points, 0);
        assertEquals(user3.points, 10);
    }
}