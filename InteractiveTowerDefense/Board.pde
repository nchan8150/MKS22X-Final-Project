public class Board{
  private Tile[][] map;
  private int Xsize = 12;
  private int Ysize = 12;
 
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
 
 void display() {
   for(int x = 0; x < Xsize; x++) {
     for (int y = 0; y < Ysize; y++) {
       map[x][y].display();
     }
   }
 }
 
}
