import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandeler implements KeyListener{
    
    public boolean upPrs, dwnPrs, LPrs, RPrs; //up, down, left, and right pressed
    
    @Override
    public void keyTyped(KeyEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code;
        code = e.getKeyCode();
        if (code == KeyEvent.VK_W){
            upPrs = true; // moves up when pressed 'w'
        }
        if (code == KeyEvent.VK_A){
            LPrs = true; // moves left when pressed 'a'
        }
        if (code == KeyEvent.VK_S){
            dwnPrs = true; // moves down when pressed 's'
        }
        if (code == KeyEvent.VK_D){
            RPrs = true; // moves right when pressed 'd'
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W){
            upPrs = false; // stops moving up when pressed 'w'
        }
        if (code == KeyEvent.VK_A){
            LPrs = false; // stops moving left when pressed 'a'
        }
        if (code == KeyEvent.VK_S){
            dwnPrs = false; // stops moving down when pressed 's'
        }
        if (code == KeyEvent.VK_D){
            RPrs = false; // stops moving right when pressed 'd'
        }
    }
}
