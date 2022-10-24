package chess;

public class Pawn extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public void move() {
		System.out.print("I can move one or two spaces foward!");
		
	}
	
	public String toString() {
		if(this.getColor() ==true) {
			return "wp";
		}else {
			return "bp";
		}
	}

}
