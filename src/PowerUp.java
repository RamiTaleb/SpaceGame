import java.awt.*;

public class PowerUp {
 //FIELDS
  private double x;
  private double y;
  private int r;
  
  private int type;
  private Color color1;
  
  
  // powerup 1 = +1 life
  // powerup 2 = +1 power
  // powerup 3 = +2 power
  // powerup 4 = slow down time
  // powerup 5 = freeze time
  // powerup 6 = shield
  // powerup 7 = +2 life
  
// CONSTRUCTOR
  public PowerUp(int type, double x, double y) {
  this.type = type;
  this.x = x;
  this.y = y;
  
  if(type == 1) {
    color1 = Color.MAGENTA;
    r = 3;
  }
     if(type == 2){
       color1 = Color.YELLOW;
       r = 3;
     }
     if(type == 3){
       color1 = Color.YELLOW;
       r = 5;
     }
     if(type == 4) {
      color1 = Color.WHITE;
       r = 3; 
     }
     
     if(type == 5) {
         color1 = Color.CYAN;
         r = 3;
     }
     if(type == 6) {
         color1 = Color.PINK;
         r = 3;
     }
     if(type == 7) {
         color1 = Color.MAGENTA;
         r = 5;
     }
  }
  
  //FUNCTIONS
  public double getx() { return x; }
  public double gety() { return y; }
  public double getr() { return r; }
  
  public int getType() { return type; }
  
  public boolean update () {
    
    y += 2;
    
    if( y > GamePanel.HEIGHT + r) {
      return true;
    }
    
    return false;
  }
  
  public void draw(Graphics2D g) {
    g.setColor(color1);
    g.fillRect((int) (x - r), (int) (y-r), 2*r, 2*r);
    
    g.setStroke(new BasicStroke(3));
    g.setColor(color1.darker());
    g.drawRect((int) (x - r), (int) (y-r), 2*r, 2*r);
    g.setStroke(new BasicStroke(1));
  }


}