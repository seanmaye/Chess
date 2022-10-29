package chess;

public class Queen extends Piece {

	public Queen(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int x, int y) {
		System.out.print("I can move anywhere!");
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wQ";
		} else {
			return "bQ";
		}
	}

}
