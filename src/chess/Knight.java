package chess;

public class Knight extends Piece{
	private int x;
	private int y;
	private boolean color;
	
	public Knight(int x, int y, boolean color) {
		super(x, y, color);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void move() {
		System.out.print("I can move in like an l lol!");
		
	}
	
	public String toString() {
		if(color ==true) {
			return "wN";
		}else {
			return "bN";
		}
	}

}
