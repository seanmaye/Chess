package chess;

public class Bishop extends Piece {

	public Bishop(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int x, int y) {
		System.out.print("I can move anywhere diagonally!");
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
