package chess;

import java.util.Scanner;

public class Chess {
	public static boolean turn;

	public static boolean printBoard;
	public static int wkx = 7;
	public static int wky = 4;
	public static int bkx = 0;
	public static int bky = 4;
	public static boolean wCheck = false;
	public static boolean bCheck = false;

	public static boolean check;
	public static Piece[][] ghostBoard = new Piece[Board.board.length][];
	public static boolean drawRequest;

	public static boolean hypeCheck(Piece piece, int dX, int dY, int toMoveX, int toMoveY) {
		if (turn) {
			King k;

			piece.setX(dX);
			piece.setY(dY);
			Board.updateBoard(Board.board, piece, toMoveX, toMoveY);
			k = (King) Board.board[wkx][wky];

			if (k.inCheck()) {

				for (int i = 0; i < Board.board.length; i++) {
					Piece[] aMatrix = ghostBoard[i];
					int aLength = aMatrix.length;
					Board.board[i] = new Piece[aLength];
					System.arraycopy(aMatrix, 0, Board.board[i], 0, aLength);
				}
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						Piece p = ghostBoard[i][j];
						p.x = i;
						p.y = j;
						if (p instanceof King) {
							((King) p).trackKingPos();
						}

					}
				}
				return false;
			}
		} else if (!turn) {
			King k;

			piece.setX(dX);
			piece.setY(dY);
			Board.updateBoard(Board.board, piece, toMoveX, toMoveY);
			k = (King) Board.board[bkx][bky];

			if (k.inCheck()) {

				for (int i = 0; i < Board.board.length; i++) {
					Piece[] aMatrix = ghostBoard[i];
					int aLength = aMatrix.length;
					Board.board[i] = new Piece[aLength];
					System.arraycopy(aMatrix, 0, Board.board[i], 0, aLength);
				}
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						Piece p = Board.board[i][j];
						p.x = i;
						p.y = j;
						if (p instanceof King) {
							((King) p).trackKingPos();
						}

					}
				}
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Board.createDefaultBoard();
		for (int i = 0; i < Board.board.length; i++) {
			Piece[] aMatrix = Board.board[i];
			int aLength = aMatrix.length;
			ghostBoard[i] = new Piece[aLength];
			System.arraycopy(aMatrix, 0, ghostBoard[i], 0, aLength);
		}
		String input = "";

		turn = true;
		printBoard = true;

		check = false;
		drawRequest = false;

		while (input != "end") {
			if (printBoard) {
				Board.printBoard(Board.board);

				System.out.println("\n");

				// print check message
				if (wCheck && turn) {
					System.out.println("WCheck"); // new line?
				} else if (bCheck && !turn) {
					System.out.println("BCheck");
				}
			} else {
				printBoard = true;
			}

			// boolean to keep track of whose turn it is
			// white = true, black = false
			if (turn == true) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}

			input = in.nextLine();

			// draw accept
			if (drawRequest == true)
				if (!input.equals("draw")) {
					System.out.println("Illegal move, try again");
					printBoard = false;
					continue;
				} else {
					break;
				}

			// resign
			if (input.equals("resign")) {
				if (turn == true) {
					System.out.println("Black wins");
					break;
				} else {
					System.out.println("White wins");
					break;
				}
			}

			char toTranslate1 = input.charAt(0);
			int toTranslate2 = Character.getNumericValue(input.charAt(1));
			char toTranslate3 = input.charAt(3);
			int toTranslate4 = Character.getNumericValue(input.charAt(4));
			int toMoveY = 0;
			int toMoveX = 0;
			int destinationY = 0;
			int destinationX = 0;

			if (toTranslate1 == 'a') {
				toMoveY = 0;
			} else if (toTranslate1 == 'b') {
				toMoveY = 1;
			} else if (toTranslate1 == 'c') {
				toMoveY = 2;
			} else if (toTranslate1 == 'd') {
				toMoveY = 3;
			} else if (toTranslate1 == 'e') {
				toMoveY = 4;
			} else if (toTranslate1 == 'f') {
				toMoveY = 5;
			} else if (toTranslate1 == 'g') {
				toMoveY = 6;
			} else if (toTranslate1 == 'h') {
				toMoveY = 7;
			} else {
				System.out.println("Illegal move, try again");
				printBoard = false;
				continue;
			}

			if (toTranslate2 == 1) {
				toMoveX = 7;
			} else if (toTranslate2 == 2) {
				toMoveX = 6;
			} else if (toTranslate2 == 3) {
				toMoveX = 5;
			} else if (toTranslate2 == 4) {
				toMoveX = 4;
			} else if (toTranslate2 == 5) {
				toMoveX = 3;
			} else if (toTranslate2 == 6) {
				toMoveX = 2;
			} else if (toTranslate2 == 7) {
				toMoveX = 1;
			} else if (toTranslate2 == 8) {
				toMoveX = 0;
			} else {
				System.out.println("Illegal move, try again");
				printBoard = false;
				continue;
			}

			if (toTranslate3 == 'a') {
				destinationY = 0;
			} else if (toTranslate3 == 'b') {
				destinationY = 1;
			} else if (toTranslate3 == 'c') {
				destinationY = 2;
			} else if (toTranslate3 == 'd') {
				destinationY = 3;
			} else if (toTranslate3 == 'e') {
				destinationY = 4;
			} else if (toTranslate3 == 'f') {
				destinationY = 5;
			} else if (toTranslate3 == 'g') {
				destinationY = 6;
			} else if (toTranslate3 == 'h') {
				destinationY = 7;
			} else {
				System.out.println("Illegal move, try again");
				printBoard = false;
				continue;
			}

			if (toTranslate4 == 1) {
				destinationX = 7;
			} else if (toTranslate4 == 2) {
				destinationX = 6;
			} else if (toTranslate4 == 3) {
				destinationX = 5;
			} else if (toTranslate4 == 4) {
				destinationX = 4;
			} else if (toTranslate4 == 5) {
				destinationX = 3;
			} else if (toTranslate4 == 6) {
				destinationX = 2;
			} else if (toTranslate4 == 7) {
				destinationX = 1;
			} else if (toTranslate4 == 8) {
				destinationX = 0;
			} else {
				System.out.println("Illegal move, try again");
				printBoard = false;
				continue;
			}

			// trim input string
			if (input.length() >= 6) {
				input = input.substring(6);
			} else {
				input = "-";
			}

			// draw request
			if (!(input.equals("-"))) {
				if (input.equals("draw?")) {
					drawRequest = true;
				} else {
					System.out.println("Illegal move, try again");
					printBoard = false;
					continue;
				}
			}

			for (int i = 0; i < Board.board.length; i++) {
				Piece[] aMatrix = Board.board[i];
				int aLength = aMatrix.length;
				ghostBoard[i] = new Piece[aLength];
				System.arraycopy(aMatrix, 0, ghostBoard[i], 0, aLength);
			}

			Piece piece = Board.board[toMoveX][toMoveY];

			boolean isLegit = piece.move(destinationX, destinationY);
			if (isLegit) {
				King k;
				if (turn && wCheck) {
					boolean isCheck = hypeCheck(piece, destinationX, destinationY, toMoveX, toMoveY);

					/*
					 * piece.setX(destinationX); piece.setY(destinationY);
					 * Board.updateBoard(Board.board, piece, toMoveX, toMoveY); k = (King)
					 * Board.board[wkx][wky];
					 * 
					 * if (k.inCheck()) { check = true;
					 * 
					 * for (int i = 0; i < Board.board.length; i++) { Piece[] aMatrix =
					 * ghostBoard[i]; int aLength = aMatrix.length; Board.board[i] = new
					 * Piece[aLength]; System.arraycopy(aMatrix, 0, Board.board[i], 0, aLength); }
					 * for (int i = 0; i < 8; i++) { for (int j = 0; j < 8; j++) { Piece p =
					 * ghostBoard[i][j]; p.x = i; p.y = j; if (p instanceof King) { ((King)
					 * p).trackKingPos(); } } } Board.printBoard(ghostBoard);
					 * 
					 */
					if (isCheck) {
						continue;
					} else {

						System.out.println("Illegal move, try again");
						printBoard = false;
						continue;
					}
				} else {
					wCheck = false;
				}

				if (!turn && bCheck) {
					System.out.println("Do a move to get you out of check");
				}

				piece.setX(destinationX);
				piece.setY(destinationY);

				Board.updateBoard(Board.board, piece, toMoveX, toMoveY);

				// keep track of king positions to use for check & checkmate, and castling
				// King k;

				if (piece instanceof King) {
					k = (King) piece;
					k.trackKingPos();

					// castling
					if (k.castleL == true) {
						Rook r = (Rook) Board.board[destinationX][0];
						int tempx = r.getX();
						int tempy = r.getY();
						r.setX(destinationX);
						r.setY(destinationY + 1);
						Board.updateBoard(Board.board,piece, tempx, tempy);
						k.castleL = false;
						r.moved = true;
					}
					if (k.castleR == true) {
						Rook r = (Rook) Board.board[destinationX][7];
						int tempx = r.getX();
						int tempy = r.getY();
						r.setX(destinationX);
						r.setY(destinationY - 1);
						Board.updateBoard(Board.board,piece, tempx, tempy);
						k.castleR = false;
						r.moved = true;
					}
				}
				// reset check
				check = false;

				// promotion
				if (piece instanceof Pawn) {
					if (piece.getColor() == true && piece.getX() == 0) {
						if (input.equals("-")) {
							piece = new Queen(destinationX, destinationY, true);
						}
						String prom = input.substring(0, 1);
						if (prom.equals('N')) {
							piece = new Knight(destinationX, destinationY, true);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('B')) {
							piece = new Bishop(destinationX, destinationY, true);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('R')) {
							piece = new Rook(destinationX, destinationY, true);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('Q')) {
							piece = new Queen(destinationX, destinationY, true);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
					}
					if (piece.getColor() == false && piece.getX() == 7) {
						if (input.equals("-")) {
							piece = new Queen(destinationX, destinationY, false);
						}
						String prom = input.substring(0, 1);
						if (prom.equals('N')) {
							piece = new Knight(destinationX, destinationY, false);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('B')) {
							piece = new Bishop(destinationX, destinationY, false);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('R')) {
							piece = new Rook(destinationX, destinationY, false);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
						if (prom.equals('Q')) {
							piece = new Queen(destinationX, destinationY, false);
							// trim input
							if (input.length() >= 2) {
								input = input.substring(2);
							} else {
								input = "-";
							}
						}
					}
				}

				Board.updateBoard(Board.board, piece, toMoveX, toMoveY);

// prepare for next turn
				if (turn == true) {
					turn = false;
				} else {
					turn = true;
				}
				System.out.println("\n");

			} else {
				System.out.println("Illegal move, try again");
				printBoard = false;
				continue;
			}

		}

		in.close();

	}
}
