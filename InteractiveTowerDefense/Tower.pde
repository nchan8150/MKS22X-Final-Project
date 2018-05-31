public abstract class Tower extends Tile{
  private String name;
  private int cost;
  private int level;
  private int damage;
  private int range;
  
  public Tower(String name) {
    this.name = name;
    cost = 10;
    level = 1;
    damage = 1;
    range = 1;
  }
  
  void display() {
    
  }
  
  public int getCost(){
    return cost;
  }
  
  public int setCost(int newCost){
    cost = newCost;
  }
  
  public int getLevel() {
    return level;
  }
  
  public int setLevel(int newLevel) {
    level = newLevel;
  
  public int getRange() {
    return range;
  }
  
  public int setRange(int newRange){
    range = newRange;
  
  public int getDamage() {
    return Damage;
  }
  
  public int setDamage(int newDamage) {
    damage = newDamage;
  }
  
  //public abstract 
  
}