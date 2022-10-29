package chess;

public class Board {
	static Piece[][] board = new Piece[8][8];

	public static void createDefaultBoard() {

		// this would be a 2d array of pieces
		board[0][0] = new Rook(0, 0, false);
		board[0][1] = new Knight(0, 1, false);
		board[0][2] = new Bishop(0, 2, false);
		board[0][3] = new Queen(0, 3, false);
		;
		board[0][4] = new King(0, 4, false);
		board[0][5] = new Bishop(0, 5, false);
		board[0][6] = new Knight(0, 6, false);
		board[0][7] = new Rook(0, 7, false);
		// create black pawns
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(1, i, false);
		}

		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board[i][j] = new Empty(i, j, false);
					} else {
						board[i][j] = new Empty(i, j, true);
					}
				} else {
					if (j % 2 == 1) {
						board[i][j] = new Empty(i, j, false);
					} else {
						board[i][j] = new Empty(i, j, true);
					}
				}

			}
		}

		board[7][0] = new Rook(7, 0, true);
		board[7][1] = new Knight(7, 1, true);
		board[7][2] = new Bishop(7, 2, true);
		board[7][3] = new Queen(7, 3, true);
		board[7][4] = new King(7, 4, true);
		board[7][5] = new Bishop(7, 5, true);
		board[7][6] = new Knight(7, 6, true);
		board[7][7] = new Rook(7, 7, true);
		// create black pawns
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(6, i, true);
		}

	}

	// updates board if a move is legal
	public static void updateBoard(Piece toMove, int x, int y) {
		board[toMove.getX()][toMove.getY()] = toMove;

		if (x % 2 == 0) {
			if (y % 2 == 0) {
				board[x][y] = new Empty(x, y, false);
			} else {
				board[x][y] = new Empty(x, y, true);
			}
		} else {
			if (y % 2 == 1) {
				board[x][y] = new Empty(x, y, false);
			} else {
				board[x][y] = new Empty(x, y, true);
			}
		}
	}

	public static void printBoard() {
		int count = 8;
		String lastRow = " a  b  c  d  e  f  g  h  ";
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print(count + "\n");
			count--;
		}
		System.out.println(lastRow);
	}
}
