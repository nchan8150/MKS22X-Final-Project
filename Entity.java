import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Tickable{
	
	private EntityCoordinate position;
	private VelocityVector velocity;
	private int size;
	private Color color;
	private boolean alive = true;
	
	public Entity() {
		this(new EntityCoordinate(0, 0));
	}
	public Entity(EntityCoordinate position) {
		this(position, 20);
	}
	public Entity(EntityCoordinate position, int size) {
		this(position, size, Color.BLACK);
	}
	public Entity(EntityCoordinate position, int size, Color color) {
		this.position = position;
		this.size = size;
		this.color = color;
		this.velocity = new VelocityVector(0, 0);
	}
	public void kill() {
		alive = false;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public EntityCoordinate getPosition() {
		return position;
	}
	public double getX() {
		return position.getX();
	}
	protected void setX(double x) {
		if (x >= 0 && x <= Map.COLUMNS)
			position.setX(x);
		if (x < 0)
			position.setX(0);
		if (x > Map.COLUMNS)
			position.setX(Map.COLUMNS);
	}
	public double getY() {
		return position.getY();
	}
	protected void setY(double y) {
		if (y >= 0 && y <= Map.ROWS)
			position.setY(y);
		if (y < 0)
			position.setY(0);
		if (y > Map.ROWS)
			position.setY(Map.ROWS);
	}
	public int getSize() {
		return size;
	}
	
	public VelocityVector getVelocity() {
		return velocity;
	}
	protected void setVelocityVector(VelocityVector velocity) {
		this.velocity = velocity;
	}
	public boolean isAlive() {
		return alive;
	}
	public boolean isDead() {
		return !isAlive();
	}
}
