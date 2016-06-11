import java.awt.*;

public class Enemy {
  
  private double x;
  private double y;
  private int r;
  
  private double dx;
  private double dy;
  private double rad;
  private double speed;
  
  private int health;
  private int type;
  private int rank;
  
  private Color color1;
  
  private boolean ready;
  private boolean dead;
  
  private boolean  hit;
  private long hitTimer;
  
  private boolean freeze;
  private boolean slow;
  
  public Enemy(int type, int rank) {
    
    
   this.type = type;
   this.rank = rank;
   
   // default enemy
   if(type ==1) {
     color1 = new Color(0, 255, 0, 128);
     if(rank == 1) {
       speed = 2;
       r = 5;
       health = 1;
     }
      if (rank == 2) {
       speed = 2;
       r = 10;
       health = 2;
     }
     if(rank == 3) {
      speed = 1.5;
      r = 20;
      health = 3;
     }
     if(rank == 4) {
      speed = 1.5;
      r = 30;
      health = 4;
     }
   }
   
   // stronger, faster default enemy
   if(type == 2) {
     color1 = new Color(0, 255, 255, 128);
     if(rank == 1) {
      speed = 3;
      r=5;
      health = 2;
   }
     if (rank == 2) {
       speed = 3;
       r = 10;
       health = 3;
     }
     if(rank == 3) {
      speed = 2.5;
      r = 20;
      health = 3;
     }
     if(rank == 4) {
      speed = 2.5;
      r = 30;
      health = 4;
     }
  }
  
   // slow, but hard to kill enemy
   if(type == 3) {
     color1 = new Color(255, 0, 0, 128);
     if(rank == 1) {
      speed = 1.5;
      r=5;
      health = 3;
     }  
     if (rank == 2) {
       speed = 1.5;
       r = 10;
       health = 4;
     }
     if(rank == 3) {
      speed = 1.5;
      r = 25;
      health = 5;
     }
     if(rank == 4) {
      speed = 1.5;
      r = 45;
      health = 5;
     }
   }
   if(type == 4) {
	     color1 = new Color(247, 255, 0, 128);
	     if(rank == 1) {
	      speed = 4;
	      r=5;
	      health = 10;
	     }  
	     if (rank == 2) {
	       speed = 4;
	       r = 10;
	       health = 10;
	     }	
	     if(rank == 3) {
	      speed = 4;
	      r = 25;
	      health = 10;
	     }
	     if(rank == 4) {
	      speed = 4;
	      r = 45;
	      health = 10;
	     }
	   }
   
   
  x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.WIDTH / 4;
  y = -r;
  
  double angle = Math.random() * 140 + 20;
  rad = Math.toRadians(angle);
  
  dx = Math.cos(rad) * speed;
  dy = Math.sin(rad) * speed;
  
  ready = false;
  dead = false;
  
  hit  = false;
  hitTimer = 0;
}

  //FUNCTIONS
  public double getx() {return x;}
  public double gety() {return y;}
  public int getr() {return r;}
  
  public int getType() { return type; }
  public int getRank() { return rank; }

  public void setSlow (boolean b) { slow = b; }
  public void setFreeze (boolean c) { freeze = c; }
  
  public boolean isDead() {return dead;}
  
  public void hit() {
    
    health--;
    if(health<=0) {
      dead=true;
    }
    hit = true;
    hitTimer = System.nanoTime();
  }

  public void explode() {
    if(rank > 1) {
     int amount = 0;
     if(type == 1) {
      amount = 3; 
     }
     if (type == 2){
       amount = 3;
     }
     if (type == 3){
       amount = 4;
     }
     if (type == 4){
         amount = 4;
       }
    
     for ( int i = 0; i < amount; i++) {
      Enemy e = new Enemy(getType(), getRank() - 1);
      e.setFreeze(freeze);
      e.setSlow(slow);
      
      e.x = this.x;
      e.y = this.y;
      double angle = 0;
      if(!ready) {
        angle = Math.random() * 140 + 20;
      }
      else{
        angle = Math.random() * 360;
      }
      e.rad = Math.toRadians(angle);
      e.rad = Math.toRadians(angle);
      e.dx = Math.cos(e.rad) * speed;
      e.dy = Math.sin(e.rad) * speed;
      GamePanel.enemies.add(e);
     }
     
    }
  }
  public void update () {
    if(freeze){
    	 x+= dx = 0.0000001;
         y += dy = 0.0000001;
    }
    else if(slow) {
      x+= dx * 0.3;
      y += dy * 0.3;
    }
    else{
      x+=dx;
      y+=dy;
    }
 
    if(!ready) {
    if(x>r && x < GamePanel.WIDTH - r && y>r && y < GamePanel.HEIGHT - r) {
      ready = true;
    }
  }
    if (x < r && dx < 0) dx = -dx;
    if(y < r && dy < 0) dy = -dy;
    if ( x > GamePanel.WIDTH - r && dx > 0) dx = -dx;
    if ( y > GamePanel.WIDTH - r && dy > 0) dy = -dy;

    if(hit) {
      long elapsed = (System.nanoTime() - hitTimer) / 1000000;
      if(elapsed > 70) {
        hit = false;
        hitTimer = 0;
    }
  }
     
} 
  public void draw(Graphics2D g) {
   
  if(hit) {
  
   g.setColor(Color.WHITE);
   g.fillOval ((int) (x-r), (int) (y-r), 2*r, 2*r);
 
   g.setStroke(new BasicStroke(3));
   g.setColor(Color.WHITE.darker());
   g.drawOval ((int) (x-r), (int) (y-r), 2*r, 2*r);
   g.setStroke(new BasicStroke(1));
   
  }
 
  else{
  
   g.setColor(color1);
   g.fillOval ((int) (x-r), (int) (y-r), 2*r, 2*r);
 
   g.setStroke(new BasicStroke(3));
   g.setColor(color1.darker());
   g.drawOval ((int) (x-r), (int) (y-r), 2*r, 2*r);
   g.setStroke(new BasicStroke(1));
   
    }
 }







}