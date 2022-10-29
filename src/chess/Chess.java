package chess;

import java.util.Scanner;

public class Chess {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Board.createDefaultBoard();
		String input = "";
		while (input != "end") {
			Board.printBoard();
			System.out.print("Move: ");
			input = in.nextLine();
			char toTranslate1 = input.charAt(0);
			int toTranslate2 = Character.getNumericValue(input.charAt(1));
			char toTranslate3 = input.charAt(3);
			int toTranslate4 = Character.getNumericValue(input.charAt(4));
			int toMoveY = 0;
			int toMoveX = 0;
			int destinationY = 0;
			int destinationX = 0;

			if (toTranslate1 == 'a') {
				toMoveY = 0;
			} else if (toTranslate1 == 'b') {
				toMoveY = 1;
			} else if (toTranslate1 == 'c') {
				toMoveY = 2;
			} else if (toTranslate1 == 'd') {
				toMoveY = 3;
			} else if (toTranslate1 == 'e') {
				toMoveY = 4;
			} else if (toTranslate1 == 'f') {
				toMoveY = 5;
			} else if (toTranslate1 == 'g') {
				toMoveY = 6;
			} else if (toTranslate1 == 'h') {
				toMoveY = 7;
			}

			if (toTranslate2 == 1) {
				toMoveX = 7;
			} else if (toTranslate2 == 2) {
				toMoveX = 6;
			} else if (toTranslate2 == 3) {
				toMoveX = 5;
			} else if (toTranslate2 == 4) {
				toMoveX = 4;
			} else if (toTranslate2 == 5) {
				toMoveX = 3;
			} else if (toTranslate2 == 6) {
				toMoveX = 2;
			} else if (toTranslate2 == 7) {
				toMoveX = 1;
			} else if (toTranslate2 == 8) {
				toMoveX = 0;
			}

			if (toTranslate3 == 'a') {
				destinationY = 0;
			} else if (toTranslate3 == 'b') {
				destinationY = 1;
			} else if (toTranslate3 == 'c') {
				destinationY = 2;
			} else if (toTranslate3 == 'd') {
				destinationY = 3;
			} else if (toTranslate3 == 'e') {
				destinationY = 4;
			} else if (toTranslate3 == 'f') {
				destinationY = 5;
			} else if (toTranslate3 == 'g') {
				destinationY = 6;
			} else if (toTranslate3 == 'h') {
				destinationY = 7;
			}

			if (toTranslate4 == 1) {
				destinationX = 7;
			} else if (toTranslate4 == 2) {
				destinationX = 6;
			} else if (toTranslate4 == 3) {
				destinationX = 5;
			} else if (toTranslate4 == 4) {
				destinationX = 4;
			} else if (toTranslate4 == 5) {
				destinationX = 3;
			} else if (toTranslate4 == 6) {
				destinationX = 2;
			} else if (toTranslate4 == 7) {
				destinationX = 1;
			} else if (toTranslate4 == 8) {
				destinationX = 0;
			}
			Piece piece = Board.board[toMoveX][toMoveY];
			boolean isLegit = piece.move(destinationX, destinationY);
			if (isLegit) {
				Board.updateBoard(piece, toMoveX, toMoveY);
			}
			
			//maybe we should make a turn int that keeps track of turns so we know if black or white can move
		}

	}
}
