package chess;

public class Pawn extends Piece {
	private boolean isFirstMove;
	public int move;

	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		isFirstMove = true;
		move=0;
	}

	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (color) {
			//System.out.println(x +" " +y);
			if(x==3 && y-1>=0 && Board.board[x][y-1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y-1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y-1) % 2 == 0) {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					}
					if ((y-1)% 2 == 1) {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					}
					return true;
				}else {
					return false;
				}
			}else if(x==3 && y+1<8 && Board.board[x][y+1]instanceof Pawn ) {
				Pawn toEnpassant = (Pawn) Board.board[x][y+1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y+1) % 2 == 0) {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					}
					if ((y+1)% 2 == 1) {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					}
					return true;
				}else {
					return false;
				}
			}else if ((dX == x-2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY]instanceof Empty && Board.board[x-1][y] instanceof Empty) {
				//x = x - 2;
		 		isFirstMove = false;
		 		move++;
				return true;
			} else if (dX == x-1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x - 1;
				isFirstMove = false;
				move++;
				return true;
			} else if (((dX == x-1 && dY == y-1) || (dX == x-1 && dY == y+1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				move++;
				return true;
			} else {
				return false;
			}
		} else {
			if(x==4 && y>=8 &&Board.board[x][y-1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y-1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y-1) % 2 == 0) {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					}
					if ((y-1)% 2 == 1) {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					}
					return true;
				}else {
					return false;
				}
			}else if(x==4 && y+1<8 &&Board.board[x][y+1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y+1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y+1) % 2 == 0) {
						Board.board[x][y+1] = new Empty(x, y+1, true);
						
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					}
					if ((y+1)% 2 == 1) {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, false);
						
					}
					return true;
				}else {
					return false;
				}
			}else if ((dX == x+2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY] instanceof Empty && Board.board[x+1][y] instanceof Empty) {
				//x = x + 2;
				isFirstMove = false;
				move++;
				return true;
			} else if (dX == x+1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x + 1;
				isFirstMove = false;
				move++;
				return true;
			} else if (((dX == x+1 && dY == y-1) || (dX == x+1 && dY == y+1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				move++;
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

