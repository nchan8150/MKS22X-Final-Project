public class Enemy{
  private int health;
  private int speed; 
  private int prize;
  private int XCoor;
  private int YCoor;
  private int type; //0 = basic
  private boolean alive = true;
  //private int[][] locations; can be output of method instead
  
  //private final int[][] directions;  //= ...
  
  public Enemy(int h, int s, int p, int t, int x, int y){
    health = h;
    speed = s;
    prize = p;
    type = t;
    XCoor = x;
    YCoor = y;
  }
  
  public Enemy(){
    health = 10;
    speed = 5;
    prize = 1;
    type = 0;
    XCoor = 0;
    YCoor = 0;
  }
  
  public Location getMove(Location[] validMoves){
    int maxPriority = 0;
    Location maxLoc = null;
    for(Location loc : validMoves){
       if(loc.getPriority() > maxPriority){
          maxPriority = loc.getPriority();
          maxLoc = loc;
       }
    }
    return maxLoc;
  }
  
  public void move(int x, int y){
    XCoor += x;
    YCoor += y;
  }
  
  void display(){
    rect(XCoor, YCoor, 50,50);
  }
}