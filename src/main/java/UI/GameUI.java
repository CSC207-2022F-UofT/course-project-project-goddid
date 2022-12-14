package UI;



import controllers.GameController;
import entities.User;
import useCases.MoveTracker;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class GameUI extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] buttons = new JButton[6][7];
    User player1;
    User player2;
    boolean player1_turn = true;
    ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();





    /**
     * @param user1 first user
     * @param user2 second user
     */
    public GameUI(User user1, User user2) {

        for (int i = 0; i < 6; i++) {
            board.add(new ArrayList<>(Arrays.asList("", "", "", "", "", "", "")));
        }

        player1 = user1;
        player2 = user2;

        /**
         * A frame is created for the Connect 4 board
         * The frame is closed when the user closes the window
         */
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        /**
         * A texfield is created on top of the grids and centered in the middle
         * The textfield shows the name of the game in the beginning
         */
        textfield.setBackground(Color.black);
        textfield.setForeground(Color.white);
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Connect 4");
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        /**
         * 42 buttons are created and placed on the frame in 6 x 7 size to make a Connect 4 board
         */
        buttonPanel.setLayout(new GridLayout(6, 7));
        buttonPanel.setBackground(Color.GRAY);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new JButton();
                if (i != 5){
                    buttons[i][j].setEnabled(false);
                }
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font(null, Font.PLAIN, 100));
                buttons[i][j].addActionListener(this);
            }

            titlePanel.add(textfield);
            frame.add(titlePanel, BorderLayout.NORTH);
            frame.add(buttonPanel);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                GameController winner = new GameController(textfield, buttons);
                if (e.getSource() == buttons[i][j]) {
                    /**
                     * If player1_turn is true the first if body is executed
                     * In the body only a move can be made if the grid is empty and there is a piece below it
                     * The player one (x) is red and (o) is blue
                     * Move tracker converts the moves in the buttons to an arraylist to check the board to see if
                     * there is a winner
                     */
                    if (player1_turn) {
                        if (buttons[i][j].getText().equals("")) {
                            buttons[i][j].setForeground(Color.red);
                            buttons[i][j].setText("X");
                            if (i != 0){
                                buttons[i - 1][j].setEnabled(true);
                            }
                            MoveTracker move_cont = new MoveTracker();
                            board = move_cont.moves(board, i, j, "X");
                            player1_turn = false;
                            textfield.setText("O(" + player2.getUsername() + ") turn");
                            /**
                             * Calls the controller to check the winner and the controller calls the usecase which
                             * follows the Clean Architecture and Dependency inversion principle
                             */
                            try {
                                winner.Wins(board, player1, player2);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } else {
                        if (buttons[i][j].getText().equals("")) {
                            buttons[i][j].setForeground(Color.blue);
                            buttons[i][j].setText("O");
                            if (i != 0){
                                buttons[i - 1][j].setEnabled(true);
                            }
                            MoveTracker move_cont = new MoveTracker();
                            board = move_cont.moves(board, i, j, "O");
                            player1_turn = true;
                            textfield.setText("X(" + player1.getUsername() + ") turn");
                            try {
                                winner.Wins(board, player1, player2);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
            }
        }
    }
}