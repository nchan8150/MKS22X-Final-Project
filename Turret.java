import java.util.ArrayList;
import java.util.List;

public abstract class Turret implements Purchasable {

	private SquareCoordinate position;
	private int cooldown;

	public Turret(SquareCoordinate position) {
		this(position, 1);
	}

	public Turret(SquareCoordinate position, int cooldown) {
		this.position = position;
		this.cooldown = cooldown;
	}

	public Projectile fire(List<Enemy> enemies, long tick) {
		if (tick % getCooldown() == 0)
			return getProjectile(enemies);
		return null;
	}

	public abstract Projectile getProjectile(List<Enemy> enemies);

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

	public int getDamage() {
		return 1;
	}
	
	public int getCooldown() {
		return cooldown;
	}

	public SquareCoordinate getPosition() {
		return position;
	}

	public int getValue() {
		return getBasePrice();
	}


}