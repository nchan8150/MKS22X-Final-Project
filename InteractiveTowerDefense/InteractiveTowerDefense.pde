//Tile [] boxes = new Tile[225]; 
Board b = new Board();
ArrayList<Mover> movers;

public void setup() {
  size(900, 700);
  movers = new ArrayList<Mover>();
  for (int i = 0; i < 10; i++) {
    movers.add(new Mover(1));
  }


  text("Dynamic Maze Tower Defense", 10, 10);
  fill(0, 0, 0);
  
}
public void draw() {
  background(255);
  fill(0);
  text(frameRate, 20, 20);
  for (Mover m : movers) {
    m.display();
    m.update(movers);
  }
  // for (int i = 0; i < 100; i++) { 
    //boxes[i].update(); 
    b.display();
    //print (i);
    print ("  ");
 // } // for
}
