package chess;

public class King extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public King(int x, int y, boolean color) {
		super(x, y, color);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void move() {
		System.out.print("I can move anywhere, in one space!");
		
	}
	
	public String toString() {
		if(color ==true) {
			return "wK";
		}else {
			return "bK";
		}
	}

}
