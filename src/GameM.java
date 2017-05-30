//note the count variable is not reset when a new game is pressed

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import java.util.*;
//btn1.setBackground(colors[index]
public class GameM implements ActionListener {
    JFrame frame = new JFrame("Memory Game");

    JPanel field = new JPanel();
    JPanel menu = new JPanel();
    JPanel menu2 = new JPanel();
    JPanel menu3 = new JPanel();
    JPanel mini = new JPanel();

    JPanel start_screen = new JPanel();
    JPanel end_screen = new JPanel();
    JPanel instruct_screen = new JPanel();

    JButton btn[] = new JButton[20];
    JButton start = new JButton("Start");
    JButton over = new JButton("Exit");
    JButton easy = new JButton("Easy");
    JButton hard = new JButton("Hard");
    JButton inst = new JButton("Instructions");
    JButton redo = new JButton("Play Again");
    JButton goBack = new JButton("Main Menu");

    Random randomGenerator = new Random();
    private boolean purgatory = false;
    JLabel winner;
    Boolean game_over = false;
    int level=0;
    int score=0;

    String[] board;
    int[] boardQ=new int[20];
    Boolean shown = true;
    int temp=30;
    int temp2=30;
    String a[]=new String[10];
    boolean eh=true;

    private JLabel label = new JLabel("Enter level from 1 to 10");
    private JTextField text = new JTextField(10);
    private JTextArea instructM = new JTextArea("When the game begins, the screen will be filled\nwith pairs of buttons.\n Memorize their placement.\nOnce you press any button, they will all clear. \n Your goal is to click the matching buttons in a row.\nWhen you finish that, you win.\nEvery incorrect click gives you a point (those are bad).\n GOOD LUCK! \n"+"for a single level: enter a level between 1 and 10,\nselect easy or hard, then press start.");
    //instructM.setEditable(false);
    //instructW.setEditable(false);
    //instructM.setLineWrap(true);
    //instructW.setWrapStyleWord(true);


        String[] b = {":-D","X","O","-(*.*)-","<>","<(^-^)>","=>",";^P","ABC","123"};//harder version
        String[] c = {"square","circle","rectangle","heart","diamond","clover","spade","triangle","polygon","tetrahedral"};//easier version
        if(what) a=c;//if what is true, make the game easy and use c
        else a=b;//otherwise make it hard and use b

        for(int i=0;i<x;i++){
            for(int z=0;z<2;z++){
                while(true){
                    int y = randomGenerator.nextInt(x*2);
                    if(board[y]==null){
                        btn[y].setText(a[i]);
                        board[y]=a[i];
                        break;
                    }
                }
            }


        }
        createBoard();

    }
    public void hideField(int x){//this sets all the boxes blank
        for(int i=0;i<(x*2);i++){
			/*if(boardQ[i]==0)*/ btn[i].setText("");
        }
        shown=false;
    }
    public void switchSpot(int i){//this will switch the current spot to either blank or what it should have
        if(board[i]!="done"){//when a match is correctly chosen, it will no longer switch when pressed
            if(btn[i].getText()==""){
                btn[i].setText(board[i]);
                //shown=true;
            } else {
                btn[i].setText("");
                //shown=false;
            }
        }
    }
    public void showSpot(int i){
        btn[i].setText(board[i]);
    }
    public void showField(int x, String a[]){//this shows all the symbols on the field
        for(int i=0;i<(x*2);i++){
            btn[i].setText(a[i]);
        }
        shown=true;
    }
    void waitABit(){//this was an attempt at fixing the glitch i told you about

        try{
            Thread.sleep(5);
        } catch(Exception e){

        }
    }
    public boolean checkWin(){//checks if every spot is labeled as done
        for(int i=0;i<(level*2);i++){
            if (board[i]!="done")return false;
        }
        winner();
        return true;
    }
    public void winner(){

        start_screen.remove(field);
        start_screen.add(end_screen, BorderLayout.CENTER);
        end_screen.add(new TextField("You Win"), BorderLayout.NORTH);
        end_screen.add(new TextField("Score: " + score), BorderLayout.SOUTH);
        end_screen.add(goBack);
        goBack.setEnabled(true);
        goBack.addActionListener(this);




    }
    public void goToMainScreen(){
        new GameM();
    }
    public void createBoard(){//this is just gui stuff to show the board
        field.setLayout(new BorderLayout());
        start_screen.add(field, BorderLayout.CENTER);

        field.setLayout(new GridLayout(5,4,2,2));
        field.setBackground(Color.black);
        field.requestFocus();
    }
    public void clearMain(){//clears the main menu so i can add the board or instructions
        start_screen.remove(menu);
        start_screen.remove(menu2);
        start_screen.remove(menu3);

        start_screen.revalidate();
        start_screen.repaint();
    }

    public static void main(String[] args) {
        new GameM();// Calling the class construtor.
    }

}
