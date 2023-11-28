import  java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TacTicTos implements  ActionListener {
    boolean areAllButtonsClick = false;
    int noOfButtonsClick = 0;
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton [] buttons = new JButton[9];
    JButton restart = new JButton();
    boolean player1Turn ;



    TacTicTos() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(25,25,25));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tac-Tic-Tos");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for (int i= 0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

//        restart.setFont(new Font("MV Boli", Font.BOLD, 12));
//        restart.setBackground(Color.red);
//        restart.setEnabled(true);
//        restart.setText("Restart");
//        restart.addActionListener(this.restart());
//
//
//
//        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));
//        titlePanel.add(textField);
//        titlePanel.add(Box.createRigidArea(new Dimension(100,100)));
//        titlePanel.add(restart);

        titlePanel.add(textField);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0; i<9; i++){
            if (e.getSource()== buttons[i]){
                if(player1Turn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        noOfButtonsClick ++;
                        check();
                    }
                }
                else{
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        noOfButtonsClick ++;
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() throws InterruptedException {
        Thread.sleep(2000);

        if(random.nextInt(2)==0){
            player1Turn=true;
            textField.setText("X turn");
        }
        else{
            player1Turn = false;
            textField.setText("0 turn");
        }
    }

    public void  check(){

//        check x win
        // first row match
        if (
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }

        // second row match
        if (
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }

        // third row match
        if (
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }

        // first column match
        if (
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }

        // second column match
        if (
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }

        // third column match
        if (
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }

        // negative daiconal match
        if (
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }

        // positive daiconal match
        if (
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }


//        check O win
        // first row match
        if (
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }

        // second row match
        if (
                (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }

        // third row match
        if (
                (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }

        // first column match
        if (
                (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }

        // second column match
        if (
                (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }

        // third column match
        if (
                (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }

        // negative daiconal match
        if (
                (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }

        // positive daiconal match
        if (
                (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }

        else {
            if(noOfButtonsClick == 9){
                textField.setText("oops!!! Nobody won this game");
                for (int i=0; i<9; i++){
                    buttons[i].setBackground(Color.red);
                    buttons[i].setEnabled(false);
                }
            }

        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i =0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i =0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }

    public ActionListener restart() throws InterruptedException {
        new TacTicTos();
        return null;
    }
}
