import java.io.*;
import java.util.*;

public class Board{
  Location start = new Location(0,0,null,0,0);
  Location end = new Location(5,5,null,0,0);
  private Tile[][] grid;
  private char[][] maze;
  private int Xsize = 12;
  private int Ysize = 12;
  private int[][]directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};
 
 public Board(){
  grid = new Tile[Xsize][Ysize];
  //Xsize = 10; //dist left
  //Ysize = 10; //dist top
  
  int k = 0; //initialize map
  for (int i = 0; i < Xsize; i += 1) { 
    for (int j = 0; j < Ysize; j += 1) { 
 
      grid[i][j] = new Tile(Xsize+i*53, Ysize+j*53, 50, 50, 255);
      k++;
    } // for
  } // for
 }
 
 public int getXsize() {
    return Xsize;
 }
 
 public int getYsize() {
   return Ysize;
 }
 
 public Location[] getNeighbors(Location L, boolean isAStar){
        Location[] list = new Location[4];
        for(int i = 0; i < 4; i++){
            for(int[]dir : directions){
                int x = L.getX() + dir[0];
                int y = L.getY() + dir[1];
                if(x >= 0 && x <= maze.length-1 && y >= 0 && y <= maze[0].length-1 &&(maze[x][y] == ' ' ||maze[x][y] == 'E')) {
                    int priority =  Math.abs(x - end.getX()) + Math.abs(y - end.getY());
                    if(isAStar){
                        priority += L.getPriority();
                    }
                    list[i] = new Location(x,y, L, priority, L.getPriority() + 1); //poss issue
                }
            }

        }  return list;
  }
  
    public Location getStart(){
    return start;
  }
  public Location getEnd(){
    return end;
  }
 
 void display() {
   for(int x = 0; x < Xsize; x++) {
     for (int y = 0; y < Ysize; y++) {
       grid[x][y].display();
     }
   }
 }
 
}
