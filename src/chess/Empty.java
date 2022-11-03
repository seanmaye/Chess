package chess;
/** Represents an empty space on a chess board   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/



public class Empty extends Piece {
	
	/**
	* Creates the Empty object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the empty space
	* @param  y  the y coordinate of the empty space
	* @param  color the color of the empty space 
	* @see Piece 
	*/
	public Empty(int x, int y, boolean color) {
		super(x, y, color);
	}

	
	
	/**
	*This method always returns false since empty spaces cannot move
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the empty space would like to move
	* @param  dY the y coordinate of where the empty space would like to move
	* @return    false if the move is illegal
	* @see Piece 
	*/
	public boolean move(int x, int y) {
		return false;
	}
	
	/**
	* Returns string that will represent the empty space on the board
	* @return         if the space is white and ## if the space is black
	*/
	public String toString() {
		if (color == true) {
			return "  ";
		} else {
			return "##";
		}

	}
}
