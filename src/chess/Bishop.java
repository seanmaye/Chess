package chess;

public class Bishop extends Piece {

	public Bishop(int x, int y, boolean color) {
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
		
		//boolean clear = true;
		for (int i = x+1, j = y+1; i<8 && j<8; i++, j++) {
			//if (!(i==dX && j==dY)&& !(Board.board[i][j] instanceof Empty)){
				//clear = false;
			//}
			if (i==dX && j==dY) { //&& clear == true
				return true;
			}
		}
		
		//clear = true;
		for (int i = x-1, j = y-1; i>=0 && j>=0; i--, j--) {
			//if (!(i==dX && j==dY)&& !(Board.board[i][j] instanceof Empty)){
				//clear = false;
			//}
			if (i==dX && j==dY) {
				return true;
			}
		}
		
		//clear = true;
		for (int i = x+1, j = y-1; i<8 && j>=0; i++, j--) {
			//if (!(i==dX && j==dY)&& !(Board.board[i][j] instanceof Empty)){
				//clear = false;
			//}
			if (i==dX && j==dY) {
				return true;
			}
		}
		
		//clear = true;
		for (int i = x-1, j = y+1; i>=0 && j<8; i--, j++) {
			//if (!(i==dX && j==dY)&& !(Board.board[i][j] instanceof Empty)){
				//clear = false;
			//}
			if (i==dX && j==dY) {
				return true;
			}
		}
		
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wB";
		} else {
			return "bB";
		}
	}

}
