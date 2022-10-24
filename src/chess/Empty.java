package chess;

public class Empty extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Empty(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public void move() {
		System.out.print("I can't move anywhere!");
		
	}
	
	public String toString() {
		if(this.getColor() == true) {
			return "  ";
		}else {
			return "##";
		}
	}
}
