public class Tile{
  private int XCoor,YCoor;
  private boolean isMaze;
  
  public Tile(int x, int y){
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
}
