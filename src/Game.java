//highscore 6713

import javax.swing.JFrame;

public class Game extends JFrame{

public  Game() {
  JFrame window = new JFrame("Rami Taleb's Game");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
    window.setContentPane(new GamePanel());
   
    window.pack();
    window.setResizable(true);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
}
    public static void main (String args[]) {
    	new Game();
  }
}