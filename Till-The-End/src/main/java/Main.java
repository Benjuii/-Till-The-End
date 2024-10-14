//import java.util.*; //user inputs and outputs
//import java.awt.*;
import javax.swing.*;

public class Main{
    public static void main(String args[]){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//game closes when the window closes
        window.setResizable(false); //can't change the window size
        window.setTitle("'Till The End");
        
        GamePanel gamePanel = new GamePanel(); // uses GamePanel thing
        window.add(gamePanel); // adds to window
        
        window.pack(); //makes the window fit to the preferred size etc from GamePanel
        
        
        window.setLocationRelativeTo(null); //goes in the middle of screen
        window.setVisible(true); //makes it visible
        
        gamePanel.startGameThread(); //starts the game thread
        
    }
}
