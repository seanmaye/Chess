package chess;

public class Queen extends Piece {

	public Queen(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		
		//rook code
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (dX==x) {
			return true;
		}
		
		if (dY==y) {
			return true;
		}
		
		
		
		//bishop code
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
			return "wQ";
		} else {
			return "bQ";
		}
	}

}
