package chess;

public class Queen extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Queen(int x, int y, boolean color) {
		super(x, y, color);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void move() {
		System.out.print("I can move anywhere!");
		
	}
	
	public String toString() {
		if(color ==true) {
			return "wQ";
		}else {
			return "bQ";
		}
	}

}
