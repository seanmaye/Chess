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
	
	/*public boolean outOfCheck(boolean color) {
		if (this.color != color) {
			return false;
		}
		
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				if (move(i,j)) {
					Piece p = Board.board[i][j];
					if (Chess.hypeCheck(this, i, j, getX(), getY())) {
						System.out.println(Chess.hypeCheck(this, i, j, getX(), getY()));
							return false;
					}
				}
			}
		}
		return true;
	}*/

}
