package chess;

public class Empty extends Piece {

	public Empty(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int x, int y) {
		return false;
	}

	public String toString() {
		if (color == true) {
			return "  ";
		} else {
			return "##";
		}

	}
}
