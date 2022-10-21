
public class createBoard {
	static String[][] board= new String[8][8];
	public static void createDefaultBoard(){
		// to string would be bp etc
		String bp = "bp";
		String bR = "bR";
		String bN = "bN";
		String bB = "bB";
		String bQ = "bQ";
		String bK = "bK";
		
		String wp = "wp";
		String wR = "wR";
		String wN = "wN";
		String wB = "wB";
		String wQ = "wQ";
		String wK = "wK";
		//this would be a 2d array of pieces
		String wht = "  ";
		String blk= "##";
		
		 board[0][0]=bR;
		 board[0][1]=bN;
		 board[0][2]=bB;
		 board[0][3]=bQ;
		 board[0][4]=bK;
		 board[0][5]=bB;
		 board[0][6]=bN;
		 board[0][7]=bR;
		 
		 board[1][0]=bp;
		 board[1][1]=bp;
		 board[1][2]=bp;
		 board[1][3]=bp;
		 board[1][4]=bp;
		 board[1][5]=bp;
		 board[1][6]=bp;
		 board[1][7]=bp;
		 
		 board[2][0]=wht;
		 board[2][1]=blk;
		 board[2][2]=wht;
		 board[2][3]=blk;
		 board[2][4]=wht;
		 board[2][5]=blk;
		 board[2][6]=wht;
		 board[2][7]=blk;
		 
		 board[3][0]=blk;
		 board[3][1]=wht;
		 board[3][2]=blk;
		 board[3][3]=wht;
		 board[3][4]=blk;
		 board[3][5]=wht;
		 board[3][6]=blk;
		 board[3][7]=wht;
		 
		 board[4][0]=wht;
		 board[4][1]=blk;
		 board[4][2]=wht;
		 board[4][3]=blk;
		 board[4][4]=wht;
		 board[4][5]=blk;
		 board[4][6]=wht;
		 board[4][7]=blk;
		 
		 board[5][0]=blk;
		 board[5][1]=wht;
		 board[5][2]=blk;
		 board[5][3]=wht;
		 board[5][4]=blk;
		 board[5][5]=wht;
		 board[5][6]=blk;
		 board[5][7]=wht;
		 
		 
		 board[6][0]=wp;
		 board[6][1]=wp;
		 board[6][2]=wp;
		 board[6][3]=wp;
		 board[6][4]=wp;
		 board[6][5]=wp;
		 board[6][6]=wp;
		 board[6][7]=wp;
		 
		 board[7][0]=wR;
		 board[7][1]=wN;
		 board[7][2]=wB;
		 board[7][3]=wQ;
		 board[7][4]=wK;
		 board[7][5]=wB;
		 board[7][6]=wN;
		 board[7][7]=wR;
		 
		 
	}
	public static void printBoard(){
		int count = 8;
		String lastRow = " a  b  c  d  e  f  g  h  ";
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(board[i][j]+ " ");
			}
			System.out.print(count+"\n");
			count--;
		}
		System.out.println(lastRow);
	}
	public static void main(String args[]) {
		createDefaultBoard();
		printBoard();
	}

}
