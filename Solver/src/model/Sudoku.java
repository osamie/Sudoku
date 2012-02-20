package model;

public class Sudoku {
	
	//squares per row or column
	public static final int BOARD_SIZE = 9;
	
	//used to indicate an empty square
	public static final int EMPTY = 0;
	
	//used to indicate square that contains a digit
	public static final int DIGIT = 1;
	
	private int board[][]; //sudoku board
	
	public Sudoku(){
		
		//constructor: creates an empty square board
		
		board = new int[BOARD_SIZE][BOARD_SIZE];
	} //end constructor
	
	public void clearBoard(){
		//----
		//clears the board
		//sets all squares to EMPTY
		//-----
				
	} //end  clear board
	
	public void displayBoard(){
		/**
		 * @TODO : write board to standard output; zero is an EMPTY square, one is a square containing a digit (DIGIT)
		 *  
		 */
		
	}
	
	public boolean placeDigits(int column){
		//not yet implemented
		return true;  //just for compile errors
	}//end placeDigits
	
	
	private void setDigit(int row, int column){
		//------------------------------
		//sets a digit at square indicated by row and column
		//sets the square on the board in a given row and column to DIGIT.
		//------------------------------
		
	}
	
	private void removeDigit(int row, int column){
		//------------------------------
		//Removes a digit at square indicated by row and column
		//Sets the square on the board in a given row and column to EMPTY
		//------------------------------
	}
	
	private boolean isDigitRepeated(int row, int column){
		//------------------------------
		//Determines whether the square on the board at a given row and column has been repeated
		//by any digits on the columns 1 through column-1 
		
		//Each column between 1 and column-1 has a digit placed at a specific row. None of these digits can be repeated 
		
		//if the designated square has a digit that has been repeated on the same row or column, return true
		//otherwise return false
		//------------------------------
		
		return true;  //just for compilation
	}
	
	private int index(int number){
		//------------------------------
		//Returns the array index that corresponds to a row or column number
		// 1 <= number <= BOARD_SIZE
		//returns adjusted index value
		//------------------------------
		
		return 0; //just for compiling
	}
	
}
