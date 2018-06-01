public class Tower extends Tile{
  private int type;
  private int cost;
  private int level;
  private int damage;
  private int range;
  private int xCoor;
  private int yCoor;
  private int upgradeCost;
  private Enemy TargetEnemy();
  
  
  //0 = basic 
  //1 = freeze
  //2 = cannon
  //3 = sniper
  public Tower(double xPos, double yPos){
    xCoor = xPos;
    yCoor = yPos;
    //this.lastAttackTime = 0;
    //angleOfRotation = 0;
    //lastAttackTime = 0;
  }
  
  public abstract Tower(int type){
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
  
  
}