public class Tile{
  private int XCoor,YCoor;
  private boolean isMaze;
  private int w = 60;
  private int h = 60;
  
  public Tile(int x, int y, int w, int h, int c){
    XCoor = x;
    YCoor = y;
    isMaze = false;
  }
  
  public Tile(int x, int y, boolean filled){
    XCoor = x;
    YCoor = y;
    isMaze = filled;
  }
  
  public int getX(){
    return XCoor;
  }
  
  public int getY(){
    return YCoor;
  }
  
  public boolean isMaze(){
    return isMaze;
  }
  
    void display() {
    stroke(0);
    rect (XCoor, YCoor+50, w , h);
    println (XCoor);
    //Mover m = new Mover();
  } // method
}