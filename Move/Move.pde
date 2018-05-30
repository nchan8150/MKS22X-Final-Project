
ArrayList<Mover> movers;
public void setup() {
  size(900, 900);
  movers = new ArrayList<Mover>();
  for (int i = 0; i < 10; i++) {
    movers.add(new Mover(1));
  }
}
public void draw() {
  background(255);
  fill(0);
  text(frameRate, 20, 20);
  for (Mover m : movers) {
    m.display();
    m.update(movers);
  }
}
