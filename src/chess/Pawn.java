package chess;

public class Pawn extends Piece {
	private int x;
	private int y;
	private boolean color;

	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void move() {
		System.out.print("I can move one or two spaces lol");

	}
	

	public String toString() {
		if (color == true) {
			return "wp";
		} else {
			return "bp";
		}
	}

}
