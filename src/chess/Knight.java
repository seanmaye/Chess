package chess;

public class Knight extends Piece {

	public Knight(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int x, int y) {
		System.out.print("I can move in like an l lol!");
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wN";
		} else {
			return "bN";
		}
	}

}
