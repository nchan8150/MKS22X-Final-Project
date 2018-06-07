public class Map {
	
	public static final int ROWS = 7;
	public static final int COLUMNS = 10;
	
	private Square[][] squares;
	private Base base = new Base();
	
	public Map() {
		squares = new Square[ROWS][COLUMNS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				squares[row][col] = new Square(col, row);
			}
		}
	}
	
	public Base getBase() {
		return base;
	}
	public Square[][] getSquares() {
		return squares;
	}
}