package chess;

import java.util.Scanner;
/** Represents a pawn piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Chess {
	/**
	*Keeps track of players turn, true =white , false = black
	*/
	public static boolean turn;
	
	/**
	*Keeps track of whether or not the program should print the board depening on if the move is legal or not
	*/
	public static boolean printBoard;
	/**
	*The white kings x value
	*/
	public static int wkx = 7;
	/**
	*The white kings y value
	*/
	public static int wky = 4;
	/**
	*The black kings x value
	*/
	public static int bkx = 0;
	/**
	*The black kings y value
	*/
	public static int bky = 4;
	/**
	*Keeps track of whether or not the white player is in check
	*/
	public static boolean wCheck = false;
	/**
	*Keeps track of whether or not the black player is in check
	*/
	public static boolean bCheck = false;
	/**
	*Legacy check that works with castling
	*/
	public static boolean check;
	/**
	*A 2D array of pieces that keeps track of the board before any moves have been made on a turn
	*/
	public static Piece[][] ghostBoard = new Piece[Board.board.length][];
	/**
	*Flag that keeps track of if a player has requested a draw
	*/
	public static boolean drawRequest;
	
	/**
	* Checks if a hypothetical move will put a king in check
	* <p>
	* Makes a move on the board, if the move will result in the king being put in check, the board state is reverted 
	* @param  piece  the piece that is making the hypothetical move
	* @param  dX  the x coordinate of the proposed move of the piece 
	* @param  dy  the y coordinate of the proposed move of the piece
	* @param  toMoveX  the current x coordinate of the piece
	* @param  toMoveY  the current y coordinate of the piece
	*/
	public static boolean hypeCheck(Piece piece, int dX, int dY, int toMoveX, int toMoveY) {
		if (turn) {
			King k=null;
			if(piece instanceof King) {
				k=(King)piece;
			}
			
			piece.setX(dX);
			piece.setY(dY);
			Board.updateBoard(Board.board, piece, toMoveX, toMoveY);
			if(k!=null) {
			k.trackKingPos();
			}
			k = (King) Board.board[wkx][wky];

			if (k.inCheck()) {
				wCheck = true;

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
				return true;
			}
		} else if (!turn) {
			King k=null;
			if(piece instanceof King) {
				k=(King)piece;
			}

			piece.setX(dX);
			piece.setY(dY);
			Board.updateBoard(Board.board, piece, toMoveX, toMoveY);
			if(k!=null) {
				k.trackKingPos();
				}
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
				return true;
			}
		}
		return false;
	}
	/**
	* Main method of the chess program.
	* <p>
	* Handles player input, gameplay loop, and UI. 
	*/
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
					System.out.println("Check");
				} else if (bCheck && !turn) {
					System.out.println("Check");
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
				if (turn) {
					boolean isntCheck = hypeCheck(piece, destinationX, destinationY, toMoveX,toMoveY);
						  if (!isntCheck) {
							  wCheck = false;
							 
							  
						  } else {
						System.out.println("Illegal move, try again!!");
						printBoard = false;
						continue;
					} /*else {
						
					}*/
				}
				

				if (!turn) {
					boolean isntCheck = hypeCheck(piece, destinationX, destinationY, toMoveX,toMoveY);
						  if (!isntCheck) { 
							  bCheck=false;
							  
						 
					
						/*System.out.println("Illegal move, try again");
						printBoard = false;
						continue;*/
					} else {
						System.out.println("Illegal move, try again");
						printBoard = false;
						continue;
						/*bCheck = false;*/
					}
				}

				piece.setX(destinationX);
				piece.setY(destinationY);

				Board.updateBoard(Board.board, piece, toMoveX, toMoveY);

				// keep track of king positions to use for check & checkmate, and castling.
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
						Board.updateBoard(Board.board, piece, tempx, tempy);
						k.trackKingPos();
						k.castleL = false;
						r.moved = true;
					}
					if (k.castleR == true) {
						Rook r = (Rook) Board.board[destinationX][7];
						int tempx = r.getX();
						int tempy = r.getY();
						r.setX(destinationX);
						r.setY(destinationY - 1);
						k.trackKingPos();
						Board.updateBoard(Board.board, piece, tempx, tempy);
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

				k = (King) Board.board[wkx][wky];
				if (!turn && k.inCheck()) {
					wCheck = true;
				}
				/*if (k.inCheckmate()) {
					System.out.println ("Black wins");
					break;
				}*/
				
				k = (King) Board.board[bkx][bky];
				if (turn && k.inCheck()) {
					bCheck = true;
				}
				/*if (k.inCheckmate()) {
					System.out.println("White wins");
					break;
				}*/

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
