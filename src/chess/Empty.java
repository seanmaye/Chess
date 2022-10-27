package chess;

public class Empty extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Empty(int x, int y, boolean color) {
		super(x, y, color);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void move() {
		
	}
	
	public String toString() {
		if(color == true) {
			return "  ";
		}else {
			return "##";
		}
	}
}
