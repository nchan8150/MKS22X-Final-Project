public class Tile{
  private int XCoor,YCoor;
  private int w = 60;
  private int h = 60;
  private int type;
  
  public Tile(int x, int y, int w, int h, int c){
    XCoor = x;
    YCoor = y;
    //isMaze = false;
  }
  
  public Tile(int x, int y, int t){
    XCoor = x;
    YCoor = y;
    type = t;
  }
  
  //0 = nothing
  //1 = tower
  public int getType() {
    return type;
  }
  
  
  public int getX(){
    return XCoor;
  }
  
  public int getY(){
    return YCoor;
  }
  
 // public boolean isMaze(){
  //  return isMaze;
 // }
  
    void display() {
    stroke(0);
    rect (XCoor, YCoor+50, w , h);
    println (XCoor);
    //Mover m = new Mover();
  } // method
}