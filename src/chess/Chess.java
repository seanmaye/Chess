package chess;

public class Chess {
	public static void main(String args[]) {
		CreateBoard.createDefaultBoard();
		CreateBoard.printBoard();
		for(int i = 0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Piece piece = CreateBoard.board[i][j];
				piece.move();
				System.out.print(" ");
				
				//System.out.print(piece.getColor() +" ");
			}
			System.out.println();
		}
		
	}
}
