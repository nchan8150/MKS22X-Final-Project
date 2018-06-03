import java.io.*;
import java.util.*;

public class Board{
  Tile start = map[0][0];
  Tile end = map[Xsize-1][Ysize-1];
  private Tile[][] map;
  private int Xsize = 12;
  private int Ysize = 12;
  private int[][]directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};
 
 public Board(){
  map = new Tile[Xsize][Ysize];
  //Xsize = 10; //dist left
  //Ysize = 10; //dist top
  
  int k = 0; //initialize map
  for (int i = 0; i < Xsize; i += 1) { 
    for (int j = 0; j < Ysize; j += 1) { 
 
      map[i][j] = new Tile(Xsize+i*53, Ysize+j*53, 50, 50, 255);
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
 
/*  public TIle[] getNeighbors(Tile L, boolean isAStar){
        Tile[] list = new Tile[4];
        for(int i = 0; i < 4; i++){
            for(int[]dir : directions){
                int x = L.getX() + dir[0];
                int y = L.getY() + dir[1];
                if(x >= 0 && x <= map.length-1 && y >= 0 && y <= map[0].length-1 &&(map[x][y] == ' ' ||map[x][y] == 'E')) {
                    int priority =  Math.abs(x - end.getX()) + Math.abs(y - end.getY());
                    if(isAStar){
                        priority += L.getPriority();
                    }
                    list[i] = new Location(x,y, L, priority, L.getPriority() + 1); //poss issue
                }
            }

        }  return list;
  }*/
 
 void display() {
   for(int x = 0; x < Xsize; x++) {
     for (int y = 0; y < Ysize; y++) {
       map[x][y].display();
     }
   }
 }
 
}
