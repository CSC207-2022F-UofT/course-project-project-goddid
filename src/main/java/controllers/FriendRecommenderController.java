package controllers;

import entities.User;
import useCases.FriendRecommender;

import java.io.IOException;



public class FriendRecommenderController {
    private FriendRecommender friendRecommender = new FriendRecommender();


    /**
     * @param target chosen friend
     * @param curr current user
     * @return recommended friend
     * @throws IOException
     * @throws ClassNotFoundException
     *
     * Recommend a random friend among the friends of the chosen friend
     */
    public String getRandomRec(User target, User curr) throws IOException, ClassNotFoundException {
        String friend = friendRecommender.getRecommendRandom(target, curr);

        return friend;
    }


    /**
     * @param target
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     *
     * Returns the friend that has most mutuals
     */
    public String getRec(User target) throws IOException, ClassNotFoundException {

        return friendRecommender.getRecommend(target);

    }

}
