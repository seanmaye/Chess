package chess;

public class Rook extends Piece {

	public Rook(int x, int y, boolean color) {
		super(x, y, color);

	}

	@Override
	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y)
			return false;
		
		
		if (dX==x) {
			return true;
		}
		
		if (dY==y) {
			return true;
		}
		
		return false;
	}

	public String toString() {
		if (color == true) {
			return "wR";
		} else {
			return "bR";
		}
	}

}
