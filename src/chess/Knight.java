package chess;

public class Knight extends Piece {

	public Knight(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (dX == x+2) {
			if (dY == y-1 || dY == y+1) {
				return true;
			}
		}
		
		if (dX == x+1) {
			if (dY == y-2 || dY == y+2) {
				return true;
			}
		}
		
		if (dX == x-1) {
			if (dY == y-2 || dY == y+2) {
				return true;
			}
		}
		
		if (dX == x-2) {
			if (dY == y-1 || dY == y+1) {
				return true;
			}
		}
		
		//System.out.print("I can move in like an l lol!");
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wN";
		} else {
			return "bN";
		}
	}

}
