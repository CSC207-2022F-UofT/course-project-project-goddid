# Project Description and Information
## Description of app and how to use
Social media chatting app that allows users to randomly chat with someone in their contact list. Users can add and remove friends by username. They can chat with their friends to gain points based on the length of their conversation. They can also earn points by playing tic-tac-toe.

### How to use the app <br/>
Go to the loginpagemain file under src/main. Run the class loginpagemain. Once done you will be prompted with a sign in / sign up screen where you can create a user with any username and password. Click sign up and then once shown the message on the GUI click login. From here you will reach the welcome page. There is a textbox at the bottom with an add friend button. Type in Bob (use Bob because it’s a hard coded test user which can be used) and then click the add friend button. Once done you can click on the friends tab where you will find Bob. Don't shut this window or the program will shut (still need to fix that issue). Then, click match where you will be matched with Bob since he is your only friend. Then you can click start chat which will bring up a new chat screen with Bob, where you can play a game, send messages, and report. Don’t click the x button on this screen as it will also end the program (need to correct the code).

## List of features

### Mert - Game Feature

The game that we implemented is a Tic - Tac - Toe game. In order to play the game from the user interface, first create an account and login. You will be directed to the welcome page. In order to play the game, first you should have a friend that you added among the other existing users. After you have friends in your friends list, you should press match to get matched with one of your friends. Then, press Start Chat and the chat user interface will be displaced to you. At the top of the chat user interface, there is a button called Game. Press that button to start the game. The game will continue between the two users until it ends. When one of the users win, the points of that user will be incremented by 15.

There are 4 main classes for the game: GameManager (Use case), MoveTracker (Use case), GameController (Controller), GameUI (UI)

GameManager class contains the check method which checks whether there is a winning move in the board so far. It takes an arraylis as an input an checks both X and O to see if one of them has a winning move. If there is a winning move, then the location of the winning move is returned with the player that won (X or O).

GameController calls the GameManager class’s check method and gets the returned value. Based on the returned value the the locations on the board that contains the winning move is changed to green to show the winning move and name of the winner player is displaced at the top of the screen. Moreover, GameController class calls the Points System Class (use case) to update the points of the winning user.

GameUI calls the GameController which follows the clean architecture flow. The game UI is created with 9 buttons, one for each grid using GridLayout. Game UI also uses MoveTracker which converts the moves on the UI to an arraylist so the check method in GameManager can check the winning moves.

For storing the users I worked on Serialization of the data by working on ReadGraph and WriteGraph classes by collaborating with Ashvat.

The tests were written for all the win cases for X and O in the GameManagerTests. In the MoveTracker tests whether the arraylist representing the board was updated


### Brandon - Friend System
The friend system involves the friendAdder, friendRemover, and friendRecommender use cases as well as the respective tests. The system also included the respective controllers like the addFriendController that interact with the UI and call upon the correct use cases and other packages. The friendAdder class interacts with the acccountManager use case and the user and graph entities, allowing a user to add friends. There is a lot of emphasis on utilizing the graph which uses a dictionary that maps username strings to users. The friendAdder class adds a selected user to the friends ArrayList in the user entity as well as adds an edge between users in the graph entity. Likewise, the friendRemover class removes users from the friends ArrayList and removes edges from the graph. The friendRecommender class provides two ways for users to get new friends. This class can randomly select 3 friends from one of the current user's friends and return this list of users as a recommendation. The class can also recommend a user based on a graph-based algorithm such that the most common friend amongst your current friends is recommended to you. This is done by searching the user's neighbors or friends in other words in the graph and then looking through their friends and counting the most common or interconnected one and returning this recommendation.
The friendAdderTest, friendRecommenderTest, and friendRemoverTest creates a set of users and tests their respective functions through asserting the correct users have been added or recommended as well as checking if the correct amount of users have been added.


### Ashvat - AccountManager

The AccountManager contains the addUser, removeUser, addFriend, removeFriend methods that are used by the FriendAdder, FriendRemover, UserCreator, UserRemover use cases. The accountmanager uses a static graph which stores all the users in the form of a hashmap that maps the user’s username to the User object. This graph is kept static to ensure that all uses of the accountmanager in various other use cases, refer to the same graph. We update the graph in the Graph.ser file each time a change is made to it i.e. each time a user is added or removed, a friend is added or removed, we update the graph in the file. The methods in the accountmanager handle edge cases as well, such as logging into an account which does not exist.
The FriendAdder and FriendRemover are 2 use cases that are responsible for adding and removing friends of the users respectively.
The 2 entities are the Graph and the User. The User contains the respective attributes such as username, password and a list of friends. The graph contains a hashmap that maps the username to the User, as mentioned earlier.
The database package contains the ReadGraph and WriteGraph classes that are responsible for reading the graph from the ser file and writing a graph into the ser file, respectively.


### Manit - Report Button
The report feature helps make the chatting app a place of mutual respect and ensures standards are met in terms of language used and keeping it a friendly safe place where nobody should be offended. The report button in the chat allows user’s to report to the Admin if they believe the opposite person has been offensive towards them in some sort. The chat is then sent to an algorithm to help identify hatespeech used.

There are functions created within the Chat Class (this was done in collaboration with Arian) to store the messages within a txt file. In order to keep unique files for each chat in the system we defined a method to keep the file name a concatenation of the two usernames and when reading from files check the order of the concatenation of the file name to not have duplicate files for the same chat. The methods to read chat is crucial as the chats get updated simultaneously as two users are chatting.

The report algorithm is broken down into parts which are defined by helper function. Each helper function has a definitive task and you can read about it in more depth in the java docstring in the Report Class. Essentially the report class aims to not just cover the cases for if a particular word is used, but also cover test cases of using the word within words, using character replacement to saya  particular word etc.

<u> Testing the Report Class (ReportTest): </u> <br/>
The report tests include all the methods in Report Class while also some methods and features from other use cases. For example attributes from User Class, blockUser, removeFriend, removeUser from AccountManager, features of graph and the FriendRemover class. There are functions in accountManager and users which I worked on that which the Report Class was solely dependent on.

### Arian - Chat System

<u> ChatManager File: </u> <br/>
The chat management file is used to help match the user to either a random user or a preselected user, depending on what method is called. Initially the randomMatch method is called when the user clicks the match button on WelcomePage, and the matched user is printed to console (and in the future submission will also be displayed as a pop up or label to the user so they can actually see the user they are matched with). However, if a user is not satisfied with the user they are matched with they can click the skip button on WelcomePage which matches them with a new user. This is accomplished by calling the skipMatch method which uses a while loop to keep randomly matching the user to a new user until the new user is not the previously selected user. Additionally a user can select a friend they want to speak with from their friends page and this will use the choseMatch method which, as the name suggests, sets the matched user to the user that had been chosen. Since there are a lot of functions which can change the user that somebody gets matched with, and the WelcomePage also needs to know what the matched user is, there is also a getter which returns who the matched user is. Finally, there is a button on WelcomePage for the user to start a chat once they are satisfied with the user they have been matched with. This button calls the openChat method of ChatManager, which is a method that starts off by searching to check whether there is an existing file that has the conversation between the two users or if there needs to be a new file created (which was done in collaboration with Manit). Once there is for certain a file (either new or old) containing the conversation between the two users, it calls the ChatScreen file to create a new chat between the two users, and display the GUI for the chat. The WelcomePage and ChatManager link was done in collaboration with Mert as I created ChatManager and Mert incorporated the ChatManager in the WelcomePage’s code. Additionally, Manit and Ashvat assisted with debugging some errors we came across when linking these two files together.

<br/>

<u> ChatScreen File: </u> <br/>
The chat system allows two users to interact with one another and uses a timer to display messages to each user in real time. The chat also incorporates Manit’s report system through a report button, as well as Mert’s game system through a game button. When the report button has been clicked and the report system has been tripped, the chat between the two users is ended. In the chat there is also a send button as well as a key listener which checks if the enter key has been pressed so that the user can either click send or press enter and message the user they are matched with. The ChatScreen then uses the addToTextFile method which adds the message that the user had written in the text field to the file containing the conversation between the two users. Manit helped with the chat system by aiding to create the addToTextFile, and readFromTextFile methods as well as the code to delete the text file in the endChat method. The display panel which shows the messages previously sent in the chat to each user is a text area with a scroll pane and is constantly updated (using the timer) by reading from the text file and appending to the text area. After the 20 message limit has been reached or a report has been created endChat is called which stops the timer that is used to update the display, then creates a new Event object as well as PointSystemR object and calls execute on the event object with the PointSystemR object as a parameter (Malhar created the PointSystem and Event classes). The Event and PointSystemR objects are responsible for updating the points of the users in the chat as well as the event log. Afterwards, the chat file is deleted and the chat window is closed. The two classes testUser1 and testUser2 exist to create a conversation between two users “Manit” and “Arian” where each test has either of the users as their main user and the other as the matched user. These two test classes can be run simultaneously and can demonstrate the chat system by mimicking a conversation between two users




### Malhar - Point System
Worked on the Point System for the user’s. Points can be used to skip chat. We are yet implement extend chat, a feature that users can use to extend the chat after the 20 line limit is reached. Also created an event log that helps keep track of what events have occurred.

#### Clean architecture and use of design patterns
- Abstraction and inheritance
- SOLID principles
- Packaging
- Serialization
- Observer pattern?
