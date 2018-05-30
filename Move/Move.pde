Tile [] boxes = new Tile[225]; 
ArrayList<Mover> movers;

public void setup() {
  size(900, 900);
  movers = new ArrayList<Mover>();
  for (int i = 0; i < 10; i++) {
    movers.add(new Mover(1));
  }
  
  int x = 10; // dist left  
  int y = 10;  // dist top
  int k=0;
  for (int i = 0; i < 10; i += 1) { 
    for (int j = 0; j < 10; j += 1) { 
 
      boxes[k] = new Tile(x+i*53, y+j*53, 50, 50, 255);
      k++;
    } // for
  } // for
  
}
public void draw() {
  background(255);
  fill(0);
  text(frameRate, 20, 20);
  for (Mover m : movers) {
    m.display();
    m.update(movers);
  }
   for (int i = 0; i < 100; i++) { 
    //boxes[i].update(); 
    boxes[i].display();
    print (i);
    print ("  ");
  } // for
}