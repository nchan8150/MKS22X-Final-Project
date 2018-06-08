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
	
	public abstract int interactWith(Entity entity);
		
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
	
	protected void snapToX() {
		setX(Math.round(position.getX()));
	}
	protected void snapToY() {
		setY(Math.round(position.getY()));
	}
	protected void snapToCoordinate() {
		snapToX();
		snapToY();
	}
	
	protected void moveX(double distance) {
		setX(position.getX() + distance);
	}
	protected void moveY(double distance) {
		setY(position.getY() + distance);
	}
	protected void move(double distance, double direction) {
		if (direction == Direction.NORTH)
			moveY(distance);
		else if (direction == Direction.SOUTH)
			moveY(-1 * distance);
		else if (direction == Direction.EAST)
			moveX(distance);
		else if (direction == Direction.WEST)
			moveX(-1 * distance);
	}
	
	public VelocityVector getVelocity() {
		return velocity;
	}
	
	public void move() {
		moveX(Math.cos(velocity.getAngle()) * velocity.getSpeed());
		moveY(Math.sin(velocity.getAngle()) * velocity.getSpeed());
	}
	public void move(VelocityVector velocity) {
		setVelocityVector(velocity);
		move();
	}
	
	protected void setVelocityVector(VelocityVector velocity) {
		this.velocity = velocity;
	}
	
	public boolean onEdgeX() {
		return position.getX() == 0 || position.getX() == Map.COLUMNS + 1;
	}
	public boolean onEdgeY() {
		return position.getY() == 0 || position.getY() == Map.ROWS + 1;
	}
	public boolean onEdge() {
		return onEdgeX() || onEdgeY();
	}
	public boolean onCorner() {
		return onEdgeX() && onEdgeY();
	}
	public boolean atBase() {
		return atBase(0.1);
	}
	public boolean atBase(double error) {
		return Math.abs(getX() - 5) < error && Math.abs(getY() - 3.5) < error;
	}
	
	public boolean intersects(Entity entity) {
		if (this == entity)
			return false;
		if (entity.isDead() || this.isDead())
			return false;
		if (Math.abs(this.getX() - entity.getX()) > ((double) entity.getSize()) / 100)
			return false;
		if (Math.abs(entity.getX() - this.getX()) > ((double) this.getSize()) / 100)
			return false;
		if (Math.abs(this.getY() - entity.getY()) > ((double) this.getSize()) / 100)
			return false;
		if (Math.abs(entity.getY() - this.getY()) > ((double) entity.getSize()) / 100)
			return false;
		
		return true;
	}
	public List<Entity> intersects(List<Entity> entities) {
		ArrayList<Entity> output = new ArrayList<Entity>();
		for (Entity entity : entities) {
			if (this.intersects(entity))
				output.add(entity);
		}
		return output;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public boolean isDead() {
		return !isAlive();
	}
}
