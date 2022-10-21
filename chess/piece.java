package chess;

public abstract class Piece {
	private int x;
	private int y;
	
	public Piece (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void move();
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		x = this.x;
	}
	
	public void setY(int y) {
		y = this.y;
	}

}
