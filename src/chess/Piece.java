package chess;

public abstract class Piece {
	 int x;
	 int y;
	 boolean color;
	
	public Piece (int x, int y, boolean color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	//returns move if a invalid move is done
	public abstract boolean move(int dX, int dY);
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getColor() {
		return color;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setColor(boolean color) {
		this.color = color;
	}

}
