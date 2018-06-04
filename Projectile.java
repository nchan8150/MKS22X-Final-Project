import java.awt.Color;
import java.util.List;

public abstract class Projectile extends Entity {
	
	private Turret source;
	
	public Projectile(Turret source, EntityCoordinate position) {
		this(source, position, Color.BLUE);
	}
	public Projectile(Turret source, EntityCoordinate position, Color color) {
		super(position, 10, color);
		this.source = source;
	}
	
	public Turret getSource() {
		return source;
	}
}