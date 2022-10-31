package chess;

public class Pawn extends Piece {
	private boolean isFirstMove;

	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		isFirstMove = true;

	}

	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (color) {
			if ((x - dX == 2 && dY == y) && isFirstMove == true) {
				//x = x - 2;
				isFirstMove = false;
				return true;
			} else if (x - dX == 1 && dY == y) {
				//x = x - 1;
				isFirstMove = false;
				return true;
			} else {
				return false;
			}
		} else {
			if ((dX - x == 2 && dY == y) && isFirstMove == true) {
				//x = x + 2;
				isFirstMove = false;
				return true;
			} else if (dX - x == 1 && dY == y) {
				//x = x + 1;
				isFirstMove = false;
				return true;
			} else {
				return false;
			}
		}

	}

	public String toString() {
		if (color) {
			return "wp";
		} else {
			return "bp";
		}
	}

}
