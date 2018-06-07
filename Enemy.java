import java.awt.Color;

public class Enemy extends Entity {

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
	
	public int getHealth() {
		return health;
	}
	
	@Override
	public int interactWith(Entity entity) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getSize() {
		return super.getSize() + 3 * (health - 1);
	}
	
}