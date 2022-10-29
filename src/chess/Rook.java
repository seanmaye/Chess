package chess;

public class Rook extends Piece {

	public Rook(int x, int y, boolean color) {
		super(x, y, color);

	}

	@Override
	public boolean move(int x, int y) {
		System.out.print("I can move anywhere horizontal and vertically!");
		return false;
	}

	public String toString() {
		if (color == true) {
			return "wR";
		} else {
			return "bR";
		}
	}

}
