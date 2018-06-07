import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Entity {

	private EntityCoordinate position;
	private VelocityVector velocity;
	private int size;
	private Color color;
	private boolean alive = true;
	private int damage = 0;
	private double direction = Direction.getRandomDirection();
	private int speed;
	private int health;
	
	public Enemy() {
		this(getRandomValidStartingCoordinate());
	}
	public Enemy(EntityCoordinate position) {
		this(position, 1);
	}
	public Enemy(EntityCoordinate position, int speed) {
		this(position, speed, 1);
	}
	public Enemy(EntityCoordinate position, int speed, int health) {
		super(position, 15, Color.RED);
		this.speed = speed;
		this.health = health;
	}
}