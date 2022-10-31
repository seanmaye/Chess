package chess;

public class King extends Piece {

	public King(int x, int y, boolean color) {
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
		
		
		if ((dX==x || dX==x-1 || dX==x+1) && (dY==y || dY==y-1 || dY==y+1)) {
			if (Board.board[dX][dY] instanceof Empty){
				return true;
			} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)) {
				return true;
			}
		}
		
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wK";
		} else {
			return "bK";
		}
	}

}
