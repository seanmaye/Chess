package chess;

public class Rook extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Rook(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public void move() {
		System.out.print("I can move anywhere horizontal and vertically!");
		
	}
	
	public String toString() {
		if(this.getColor()==true) {
			return "wR";
		}else {
			return "bR";
		}
	}

}
