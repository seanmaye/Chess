package chess;

public class Pawn extends Piece {
	private boolean isFirstMove;

	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		isFirstMove = true;

	}

	public boolean move(int destinationX, int destinationY) {
		// this might need to be changed to a way to check which players turn it is
		if (color) {
			if ((x - destinationX == 2 && destinationY == y) && isFirstMove == true) {
				x = x - 2;
				isFirstMove = false;
				return true;
			} else if (x - destinationX == 1 && destinationY == y) {
				x = x - 1;
				isFirstMove = false;
				return true;
			} else {
				System.out.println("Illegal move, try again");
				return false;
			}
		} else {
			if ((destinationX - x == 2 && destinationY == y) && isFirstMove == true) {
				x = x + 2;
				isFirstMove = false;
				return true;
			} else if (destinationX - x == 1 && destinationY == y) {
				x = x + 1;
				isFirstMove = false;
				return true;
			} else {
				System.out.println("Illegal move, try again");
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
