package chess;

public class King extends Piece {
	public boolean moved;
	public boolean castleL;
	public boolean castleR;
	public static boolean isChecking;
	
	public King(int x, int y, boolean color) {
		super(x, y, color);
		moved = false;
		castleL = false;
		castleR = false;
	}

	@Override
	public boolean move(int dX, int dY) {
		if (!King.isChecking&&Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		
		//castling
		if ((dX==x && dY==y-2) && Board.board[dX][0] instanceof Rook && Board.board[dX][0].getColor()==color) {
			Rook r = (Rook) Board.board[dX][0];
			if (moved==false && r.moved==false && !Chess.check) {
				if(Board.board[dX][y-1] instanceof Empty
						&& Board.board[dX][y-2] instanceof Empty
						&& Board.board[dX][y-3] instanceof Empty){
					castleL = true;
					moved = true;
					return true;
				}
			}
		}
		
		if ((dX==x && dY==y+2) && Board.board[dX][7] instanceof Rook && Board.board[dX][7].getColor()==color) {
			Rook r = (Rook) Board.board[dX][7];
			if (moved==false && r.moved==false && !Chess.check) {
				if(Board.board[dX][y+1] instanceof Empty
						&& Board.board[dX][y+2] instanceof Empty){
					castleR = true;
					moved = true;
					return true;
				}
			}
		}
		
			
		
		if ((dX==x || dX==x-1 || dX==x+1) && (dY==y || dY==y-1 || dY==y+1)) {
			if (Board.board[dX][dY] instanceof Empty){
				King k = new King(dX, dY, color);
				if(color) {
					Chess.wkx=dX;
					Chess.wky=dY;
				}else {
					Chess.bkx=dX;
					Chess.bky=dY;
				}
				if (k.inCheck()) {
					return false;
				}
				moved = true;
				return true;
			} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)) {
				King k = new King(dX, dY, color);
				if(color) {
					Chess.wkx=dX;
					Chess.wky=dY;
				}else {
					Chess.bkx=dX;
					Chess.bky=dY;
				}
				if (k.inCheck()) {
					return false;
				}
				moved = true;
				return true;
			}
		}
		
		return false;

	}
	
	
	
	//update king position
	public void trackKingPos() {
		if (color) {
			Chess.wkx = x;
			Chess.wky = y;
		}
		else {
			Chess.bkx = x;
			Chess.bky = y;
		}
	}
	
	
	//detect check
	public boolean inCheck() {
		Piece p;
		isChecking=true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				p = Board.board[i][j];
				
				//empty square
				if (p instanceof Empty) {
					continue;
				}
				
				//p is same color, so no threat
				if (color == p.color) {
					continue;
				}
				
				//p is opposite color, threat
				if (p.move(x,y)) {
					isChecking=false;
					return true;
				}else {
				}
				
			}
		}
		isChecking=false;
		return false;
	}
	
	
	
	//detect checkmate
	/*public boolean inCheckmate() {
		King k;
		
		boolean test1;
		int testX = x-1;
		int testY = y-1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test1 = k.inCheck();
		} else {
			test1 = false;
		}
		
		boolean test2;
		testY = y;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test2 = k.inCheck();
		} else {
			test2 = false;
		}
		
		boolean test3;
		testY = y+1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test3 = k.inCheck();
		} else {
			test3 = false;
		}
		
		
		boolean test4;
		testX = x;
		testY = y-1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test4 = k.inCheck();
		} else {
			test4 = false;
		}
		
		boolean test5;
		testY = y+1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test5 = k.inCheck();
		} else {
			test5 = false;
		}
		
		
		boolean test6;
		testX = x+1;
		testY = y-1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test6 = k.inCheck();
		} else {
			test6 = false;
		}
		
		boolean test7;
		testY = y;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test7 = k.inCheck();
		} else {
			test7 = false;
		}
		
		boolean test8;
		testY = y+1;
		if (move(testX,testY)) {
			k = new King(testX, testY, color);
			test8 = k.inCheck();
		} else {
			test8 = false;
		}
		
		
		return (test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8);
	}*/

	
	
	public String toString() {
		if (color == true) {
			return "wK";
		} else {
			return "bK";
		}
	}

}
