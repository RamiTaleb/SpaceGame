import java.awt.*;

public class Player {
  
  
  private int x;
  private int y;
  private int r;
 
  private int dx;
  private int dy;
  private int speed;
  
  private boolean left;
  private boolean right;
  private boolean up;
  private boolean down;
  
  private boolean firing;
  private long firingTimer;
  private long firingDelay;
  
  private boolean recovering;
  private long recoveryTimer;
  
  private boolean shield;
  
  private int lives;
  private Color color1;
  private Color color2;
  
  private int score;
  
  private int powerLevel;
  private int power;
  private int[] requiredPower = {
    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
  };
  
  public Player() {
    
    x = GamePanel.WIDTH / 2;
    y= GamePanel.HEIGHT / 2;
    r = 5;
    
    dx=0;
    dy = 0;
    speed = 5;
    
    lives = 3;
    color1 = Color.WHITE;
    color2 = Color.RED;
  
    firing = false;
    firingTimer = System.nanoTime();
    firingDelay = 200;
  
    recovering = false;
    recoveryTimer = 0;
    
    shield = false;
  
    score = 0;
  }
  
  public int getx() { return x;}
  public int gety() { return y;}
  public int getr() { return r;}
  
  public int getScore() { return score;}
  public int getLives() { return lives;}
  
  public boolean isDead () { return lives <=0; }
  public boolean isRecovering() {return recovering;}
  public boolean isShield() {return shield;}
  
  public void setLeft(boolean b) {left = b;}
  public void setRight(boolean b) {right = b;}
  public void setUp(boolean b) {up = b;}
  public void setDown(boolean b) {down = b;}
   
  public void setFiring(boolean b) {firing = b; }
  public void addScore(int i) { score += i;}
  
  public void gainLife() {
   lives++; 
  }
  public void gain2Life() {
	   lives=lives+2; 
	  }
  public void loseLife() {
    
    lives--;
    recovering = true;
    recoveryTimer = System.nanoTime();
  }
  
  public void setShield(){
	  recovering = true;
	  recoveryTimer = System.nanoTime();
  }
  
  public void increasePower(int i) {
   power += i; 
   if(powerLevel == 10) {
     if(power > requiredPower[powerLevel]) {
      power = requiredPower[powerLevel]; 
     }
     return; 
   }
   if(power >= requiredPower[powerLevel]) {
    power -= requiredPower [powerLevel]; 
    powerLevel++;
   }
  }
  
  public int getPowerLevel () { return powerLevel; }
  public int getPower () { return power; }
  public int getRequiredPower() { return requiredPower [powerLevel]; }
  
  public void update() {
    if(left) {
      dx = -speed;
    }
    if(right) {
      dx = speed;
    }
     if(up) {
      dy = -speed;
    }
      if(down) {
      dy = speed;
    }
      
      x += dx;
      y += dy;
      
      if (x<r) x = r;
      if (y<r) y=r;
      if (x>GamePanel.WIDTH - r) x = GamePanel.WIDTH - r;
      if (y>GamePanel.HEIGHT - r) y = GamePanel.HEIGHT - r;
      
      dx=0;
      dy=0;
   
      if(firing) {
        
        long elapsed = (System.nanoTime() - firingTimer) / 1000000;
       
        if(elapsed > firingDelay) {

          firingTimer = System.nanoTime();
       
          if(powerLevel < 2) {
            GamePanel.bullets.add(new Bullet(270, x, y));
          }
        
          else if(powerLevel < 4) {
            GamePanel.bullets.add(new Bullet(270, x + 5, y));
            GamePanel.bullets.add(new Bullet(270, x - 5, y));
          }
          
          else if (powerLevel < 6){
            GamePanel.bullets.add(new Bullet(270, x, y));
            GamePanel.bullets.add(new Bullet(275, x + 5, y));
            GamePanel.bullets.add(new Bullet(265, x - 5, y));
          }
          
          else if (powerLevel <10){
              GamePanel.bullets.add(new Bullet(270, x, y));
              GamePanel.bullets.add(new Bullet(273, x + 5, y));
              GamePanel.bullets.add(new Bullet(267, x - 5, y));
              GamePanel.bullets.add(new Bullet(276, x + 8, y));
              GamePanel.bullets.add(new Bullet(264, x - 8, y));
        }
          else {
              GamePanel.bullets.add(new Bullet(270, x, y));
              GamePanel.bullets.add(new Bullet(273, x + 5, y));
              GamePanel.bullets.add(new Bullet(267, x - 5, y));
              GamePanel.bullets.add(new Bullet(276, x + 5, y));
              GamePanel.bullets.add(new Bullet(264, x - 5, y));
              GamePanel.bullets.add(new Bullet(90, x, y));
              GamePanel.bullets.add(new Bullet(93, x + 3, y));
              GamePanel.bullets.add(new Bullet(87, x - 3, y));
              GamePanel.bullets.add(new Bullet(96, x + 3, y));
              GamePanel.bullets.add(new Bullet(84, x - 3, y));
              GamePanel.bullets.add(new Bullet(0, x, y));
              GamePanel.bullets.add(new Bullet(3, x + 3, y));
              GamePanel.bullets.add(new Bullet(354, x - 3, y));
              GamePanel.bullets.add(new Bullet(6, x + 3, y));
              GamePanel.bullets.add(new Bullet(351, x - 3, y));
              GamePanel.bullets.add(new Bullet(180, x, y));
              GamePanel.bullets.add(new Bullet(183, x + 3, y));
              GamePanel.bullets.add(new Bullet(177, x - 3, y));
              GamePanel.bullets.add(new Bullet(186, x + 3, y));
              GamePanel.bullets.add(new Bullet(174, x - 3, y));
        }
      }
      }
  
      if(recovering){
        long elapsed = (System.nanoTime() - recoveryTimer) / 1000000;
        if(elapsed > 3000) {
          recovering = false;
          recoveryTimer = 0;
      }
      }  
 }
  
  public void draw(Graphics2D g) {
    
	 if(recovering) {
    g.setColor(color2);
    g.fillOval(x-r, y-r, 2*r, 2*r);
    
    g.setStroke(new BasicStroke(3));
    g.setColor((color2.darker()));
    g.drawOval(x-r, y-r, 2*r, 2*r);
    g.setStroke(new BasicStroke(1));
    }
    
       else{
    g.setColor(color1);
    g.fillOval(x-r, y-r, 2*r, 2*r);
    
    g.setStroke(new BasicStroke(3));
    g.setColor((color1.darker()));
    g.drawOval(x-r, y-r, 2*r, 2*r);
    g.setStroke(new BasicStroke(1));
               
       }
  }
                        
                     
}