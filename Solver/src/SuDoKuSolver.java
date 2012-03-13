//package model;

/**
 * 
 * 
 * @author Osazuwa Omigie
 *
 *
 * 
 */

public class SuDoKuSolver {
	
	//squares per row or column
	public static final int BOARD_SIZE = 9;
	
	//used to indicate an empty square
	public static final int EMPTY = 0;
	
	//used to indicate square that contains a digit
	public static final int DIGIT = 1;
	
	private int board[][]; //sudoku board
	
	private int reset_board[][];  //make a referece to the original state of the board    
	
	private static int numOfSolutions;   //number of possible solutions of the sukodu puzzle  
	
	public SuDoKuSolver(int b[][]){
		
		board = b;  
		//constructor: creates an empty square board
		reset_board = (int [][]) b.clone();
		
		//initialize the number of possible solutions to zero at the start of the program
		numOfSolutions = 0;  
		
		 
		
		//Print out the board on the console
		displayBoard();
		
	} //end constructor
	 
	/**
	 * displays the board on the console  
	 */
	public void displayBoard(){
		/**
		 * @TODO : write board to standard output; zero is an EMPTY square, one is a square containing a digit (DIGIT)
		 *  
		 */
		 
		//iterate through the board, printing each cell
		for( int row = 0; row < BOARD_SIZE; row++ ){
	         for( int col = 0; col < 9; col++ )
	            {
	        	 	if( board[row][col] != EMPTY ) //if the cell is not empty, print its value 
	        	 		System.out.print( String.valueOf(board[row][col]) + " " ) ;
	        	 	else
	        	 		System.out.print("  ");  //if the cell is empty, print an empty string  
	            	//view[row][col].setLabel( "" ) ;
	            }
	         System.out.print("\n"); //print the next row on the next line of output  
		}
		
		
	}
	
	
	//return the number of possible solutions to the puzzle
	public int getNumOfSolutions(){
		return numOfSolutions;  
	}
	
	
	
	public boolean findSolution(int row, int column)throws Exception{
		//------------------------------
				//Determines whether the square on the board at a given row and column has been repeated
				//by any digits on the columns 1 through column-1 
				
				//Each column between 1 and column-1 has a digit placed at a specific row. None of these digits can be repeated 
				
				//if the designated square has a digit that has been repeated on the same row or column, return true
				//otherwise return false
				//------------------------------
				
		// Throw an exception to stop the process if the puzzle is solved
	      if( row >= BOARD_SIZE )
	      {
	    	 //at this point we have found a solution
	    	  
	    	 ++numOfSolutions; //increment the number of solutions variable;
	    	 
	    	 displayBoard(); //print the board on the standard output/console
	    	 
	    	  
	    	 System.out.println("\n");
	         return true;
	    	 //throw new Exception( "Solution found" ) ;
	      }
	      
	      
	      // If the cell is not empty, continue with the next cell
	      if( board[row][column] != EMPTY )
	    	  findSoluUtil( row, column ); 
	      else
	      {
	         // Keep searching for valid digits that are valid for the empty cell 
	         for( int num = 1; num < 10; num++ )
	         {
	            if( isValidRow(row,num) && isValidColumn(column,num) && isValidBox(column,row,num) )
	            {
	            	//if the number found is valid for that cell, then set it  
	               board[row][column] = num ;
	               
	                
	               findSoluUtil( row, column ) ; //the recursive call handler
	            }
	         }

	         // No valid number was found, clean up and return to caller
	         board[row][column] = 0 ;
	         return true;
	          
	      }
		
		return true;
	}
	
	/** recursive call handler */
	public void findSoluUtil( int row, int col ) throws Exception
	{
		//after finding the solution for 1 cell, check if we need to move on to the next row 
		//or just the next column
		
	    if( col < 8 )
	    	findSolution( row, col + 1 ) ;    
	    else
	    	findSolution( row + 1, 0 ) ;  //after parsing a row, move on to the next row
	}
	
	
	
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
	
	
	
	
	/*
	 * Returns a true if the digit can be validly placed in the row
	 */	
	private boolean isValidRow(int row, int digit){
		
		//iterate through the digits in the specified row(column by column) for a repeated digit 
		for( int column = 0; column < BOARD_SIZE; column++ )
		{
			//if we find a repeated digit return false 
	         if( board[row][column] == digit )
	            return false ;
		}
	    return true;
	
	}
	
	/*
	 * Returns true if the digit can be validly placed in the column
	 */	
	private boolean isValidColumn(int column, int digit){
		
		//iterate through the digits in the specified column(row by row) for a repeated digit 
		for( int row = 0; row<BOARD_SIZE; row++ )
		{
	         if( board[row][column] == digit )
	            return false;
		}
	    return true;
	}
	
	/**
	 * 
	 * @param column
	 * @param row
	 * @param digit
	 * @return returns true if the digit can be validly placed in the 3x3 square  
	 */
	private boolean isValidBox(int column, int row, int digit){
		
		row = (row / 3) * 3 ;  //gets the lowest row in its box 
		column = (column / 3) * 3 ; //gets the leftmost column within its box 

		//we iterate through from the left topmost cell in the box for any other repeated occurence of the digit   
	      for( int r = 0; r < 3; r++ ){
	         for( int c = 0; c < 3; c++ )
	         { 
	        	//if we find the digit already in the box, then it will be an invalid box for that digit,
	        	 if( board[row+r][column+c] == digit ) 
	        		 return false;
	         }
	            
	      }  
	      return true ;
	}
	
	public static void main(String[] args){
		SudokuTestDriver.main(null);
		//SudokuTestDriver std = new SudokuTestDriver()
	}
	
	
	
	 
	
	
}
