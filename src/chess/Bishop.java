package chess;

public class Bishop extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Bishop(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public void move() {
		System.out.print("I can move anywhere diagonally!");
		
	}
	
	public String toString() {
		if(this.getColor()==true) {
			return "wB";
		}else {
			return "bB";
		}
	}

}
