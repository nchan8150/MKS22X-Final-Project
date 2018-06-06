import java.util.List;

public class EntityCoordinate{
	
	private double x;
	private double y;
	
	public EntityCoordinate() {
		this(0, 0);
	}
		
	public EntityCoordinate(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double angleTo(EntityCoordinate coord) {
		double deltaY = coord.getY() - this.getY();
		double deltaX = coord.getX() - this.getX();
		if (deltaX > 0)
			return Math.atan(deltaY / deltaX);
		return Math.atan(deltaY / deltaX) + Math.PI;
	}
	
	public String toString() {
		return "EntityCoordinate: {x: " + getX() + ", y: " + getY() + "}";
	}
}
	