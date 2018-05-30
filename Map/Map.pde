//Box [] boxes = new Box[26]; 
 
/*void setup() { 
  size(600, 600); 
  // smooth();
 
  // Create a 4x4 grid of 50*50 box with 50 balls
  int x = 10; // dist left  
  int y = 10;  // dist top
  int k=0;
  for (int i = 0; i < 5; i += 1) { 
    for (int j = 0; j < 5; j += 1) { 
 
      boxes[k] = new Box(x+i*53, y+j*53, 50, 50, 50);
      k++;
    } // for
  } // for
} // setup()
 
///////////////////////////////// //And initialize the boxes like this:
 
void draw() { 
  background(255);
 
  // display the balls 
  for (int i = 0; i < 25; i++) { 
    //boxes[i].update(); 
    boxes[i].display();
    print (i);
    print ("  ");
  } // for
} // draw()
 
// ===============================================================
 
class Box {
 
  float x;
  float y; 
 
  float w=50;
  float h=50; 
 
  int col;
 
 
  // constr 
  Box ( float x, float y, float w, float h, int col ) {
    this.x=x;
    this.y=y;
  } // constr 
 
  void display() {
    stroke(0);
    rect (x, y, w, h);
    println (x);
    Mover m = new Mover();
  } // method
} // class 
//*/
