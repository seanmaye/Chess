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
	public abstract boolean move(int x, int y);
	
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
		x = this.x;
	}
	
	public void setY(int y) {
		y = this.y;
	}
	
	public void setColor(boolean color) {
		color = this.color;
	}

}
