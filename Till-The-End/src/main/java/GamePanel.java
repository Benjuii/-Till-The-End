//import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel/**/ implements Runnable/*keeps it running*/{
    
    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16×16 tile (Character size)
    final int scale = 3; // scale for size 
        
    final int tileSize = originalTileSize*scale; // rightsize for computer
    final int maxScreenx = 16; // columns
    final int maxScreeny = 12; // rows           4:3 ratio
    final int screenWidth = tileSize*maxScreenx; // 768px
    final int screenHeight = tileSize*maxScreeny; // 576px
    
    //FPS
    int fps = 60;
    
    
    KeyHandeler keyH = new KeyHandeler();
    Thread gameThread; //this is class which wont stop running until the program is closed
    
    //Set player's default position.
    int playerx = 100;
    int playery = 100;
    int playerSpeed = 5;
        
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // window size
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //the drawing for this component will be done in an off screen painting buffer - improves rendering
        this.addKeyListener(keyH); //makes the gamePanel recognise the key inputs.
        this.setFocusable(true); //makes it so the gamePanel can be focused to recieve key input.
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override //when an object implementing interface "Runnable" is used to create a thread, starting the thread causes the object's run method to be called in the seperately executing thread. 
    //basically its going to run no matter what.
    public void run() {
        //where the game runs. 
        
        //I'm using the Delta method to repaint my characters which basically finds the time since the last update/repaint and if its greater than or equal to the fps of the game
        double nns = 10^9;
        double drawInterval = nns/fps; // Time between drawing and painting
        double delta = 0;
        long lastTme = System.nanoTime(); //The time before the gamethread starts
        long crntTme = 0; // Current Time - as in the time now
        
        while(gameThread != null){
            
            crntTme = System.nanoTime();
            delta += (crntTme - lastTme) / drawInterval; // delta is equal to the difference between the current and the last time.
            lastTme = crntTme;
            
            
            if(delta >= 1){
                //UPDATE information (character positions)
                update();
            
                //DRAW the screen with updated information.
                repaint(); // == paintComponent()
                delta--;
            }  
        }
    }
    
    public void update(){
        
        if(keyH.upPrs == true){                
            playery -= playerSpeed;
            keyH.upPrs=false;
        }
        if(keyH.dwnPrs == true){
            playery += playerSpeed;
            keyH.dwnPrs=false;
        }
        if(keyH.LPrs == true){
            playerx -= playerSpeed;
            keyH.LPrs=false;
        }
        if(keyH.RPrs == true){
            playerx += playerSpeed;
            keyH.RPrs=false;
        } 
    }

    @Override
    public void paintComponent(Graphics g){
        //built into java - why theres a lack of code
        
        super.paintComponent(g);
        //means it is the parent class or JFrame
        
        Graphics2D g2 = (Graphics2D)g;
        //extends the graphic class to provide more sophisticated control over geometry, colours, text layout and transformations
        
        g2.setColor(Color.white);
        g2.fillRect(playerx, playery, tileSize, tileSize);
        //(x, y, width, height)
        g2.dispose();
        //Dispose of graphics context and release any system resources that it's using
        // - clears resources at each frame
    }
}
