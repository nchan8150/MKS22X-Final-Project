public class Enemy{
  private int health;
  private int speed; 
  private int prize;
  private int XCoor;
  private int YCoor;
  private int type; //0 = basic
  private boolean alive = true;
  //private int[][] locations; can be output of method instead
  
  private final int[][] directions;  //= ...
  
  public Enemy(int h, int s, int p, int t, int x, int y){
    health = h;
    speed = s;
    prize = p;
    type = t;
    XCoor = x;
    YCoor = y;
  }
  
  public Location getMove(Location[] validMoves){
    int maxPriority = 0;
    Location maxLoc = null;
    for(Location loc : validMoes){
       if(loc.getPriority() > maxPriority){
          maxPriority = loc.getPriority();
          maxLoc = loc;
       }
    }
    return maxLoc;
  }
  
  public void move(Location loc){
    XCoor = loc.getX();
    YCoor = loc.getY();
  }
    
}
