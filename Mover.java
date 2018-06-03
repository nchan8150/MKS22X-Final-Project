public class Mover {
  float x, xspeed, xacc;
  float y, yspeed, yacc;
  float r;
  color c;

  public Mover() {
    x = width/2;
    y = height/2;
    r = 15;
    c = color(0, 255, 0);
    xspeed= -10;
    yspeed= -10;
  }

  public Mover(int a) {
    x = random(width-2*r)+r;
    y = random(height-2*r)+r;
    r = 5;
    c = color(0, 255, 0);
    //xspeed= random(1)-.5;
    xspeed = -10;
    yspeed = -10;
  //  yacc = 0.5;
  }

  public void update(ArrayList<Mover> others) {
    //change the position etc.
    x += xspeed; 
    y += yspeed; 
    //yspeed += yacc;
    //xspeed += xacc;
    //check the rest of the world for interactions
    checkWalls();
    checkOthers(others);
  }
  
  public void checkOthers(ArrayList<Mover> others){
    c = color(255,255, 255);
    for(Mover other : others){
      if(this != other){
       //check for collide
       if(dist(x,y,other.x,other.y) < r + other.r ){
          c = color(255, 0, 0); 
       }
      }
    }
  }
  
  

  public void checkWalls() {
    if (x < r) {
      println("OW!");
      xspeed *= -1;
      x = r;//prevents 2 true in a row
    }
    if (x > width - r) {
      println("OW!");
      xspeed *= -1;
      x = width - r;//prevents 2 true in a row
    }
    if (y < r) {
      println("OW!");
      yspeed *= -.9;
      y = r;//prevents 2 true in a row
    }
    if (y > height - r) {
      println("OW!");
      yspeed *= -.9;
      y = height - r;//prevents 2 true in a row
    }
  }
  public void display() {
    fill(c);
    rect(x, y, r * 2, r * 2);
  }
}