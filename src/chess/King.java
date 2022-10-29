package chess;

public class King extends Piece {

	public King(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int x, int y) {
		System.out.print("I can move anywhere, in one space!");
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wK";
		} else {
			return "bK";
		}
	}

}
