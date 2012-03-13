import java.io.*;
import java.util.StringTokenizer;


/**
 * 
 * 
 * @author Osazuwa Omigie
 *
 *
 * 
 */


public class SudokuTestDriver {
	protected BufferedReader fileReader;

	protected PrintWriter fileWriter;

	private int board[][];
	
	private SuDoKuSolver k;
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		//SuDoKuSolver k = new SuDoKuSolver();
		SudokuTestDriver r = new SudokuTestDriver();
		
		r.setupSudoku();
		
		try {
			
			r.k.findSolution(0, 0);
			int num = r.k.getNumOfSolutions(); 
			if ( (num) > 1) {
				System.out.printf("\n * The puzzle has multiple solutions(%d) *\n \n",num);
			}
			
			else if(num==1) {
				System.out.println("\n * The puzzle has a unique solution * \n");
			}
			
			else{
				System.out.println("\n * The puzzle is not solvable * \n");
				}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println("\n" + k.reset_board[0][2]);
			System.out.println("CAUGHT EXCEPTION...print stack trace");
		}
		
		// TODO Auto-generated method stub

	}
	
	
	//public SudokuTestDriver()
	
	public PrintWriter openFiles() {
		final String IN_FILE_PROMPT = "\n\nPlease enter the path for the input file: ";

		//final String OUT_FILE_PROMPT = "\n\nPlease enter the path for the output file: ";

		BufferedReader keyboardReader = new BufferedReader(
				new InputStreamReader(System.in));

		String inFilePath, outFilePath;

		boolean pathsOK = false;

		while (!pathsOK) {
			try {
				System.out.print(IN_FILE_PROMPT);
				inFilePath = keyboardReader.readLine();
				fileReader = new BufferedReader(new FileReader(inFilePath));
				//System.out.print(OUT_FILE_PROMPT);
				//outFilePath = keyboardReader.readLine();
				
				//fileWriter = new PrintWriter(new FileWriter(outFilePath));
				pathsOK = true;
			} // try
			catch (IOException e) {
				System.out.println(e);
			} // catch I/O exception
		} // while
		return fileWriter;
	} // method openFiles
	
	
	public void setupSudoku() {
		
		
		
		StringTokenizer tokens;

		String line;
		
		int row, col, digit;

		//VeryLongInt veryLong = null, otherVeryLong;
		final String IN_FILE_PROMPT = "\n   ********SUDOKU SOLVER********   \n          by Osazuwa Omigie(100764733)  \n\nPlease enter the path of the input file for the puzzle: ";

		//final String OUT_FILE_PROMPT = "\n\nPlease enter the path for the output file: ";

		BufferedReader keyboardReader = new BufferedReader(
				new InputStreamReader(System.in));

		String inFilePath, outFilePath;

		boolean pathsOK = false;

		while (!pathsOK) {
			try {
				System.out.print(IN_FILE_PROMPT);
				inFilePath = keyboardReader.readLine();
				fileReader = new BufferedReader(new FileReader(inFilePath));
				//System.out.print(OUT_FILE_PROMPT);
				//outFilePath = keyboardReader.readLine();
				
				//fileWriter = new PrintWriter(new FileWriter(outFilePath));
				pathsOK = true;
			} // try
			catch (IOException e) {
				System.out.println(e);
			} // catch I/O exception
		} // while
		
		try {
			line = fileReader.readLine();
		
		//the first line of the program indicates the number of entries 
		
			if (line == null){
				throw new RuntimeException("No specified number of entries");
			}
		
			tokens = new StringTokenizer(line);
		
			int entries = Integer.parseInt(tokens.nextToken()); //number of entries or subsequent lines we are going to read
			board = new int[SuDoKuSolver.BOARD_SIZE][SuDoKuSolver.BOARD_SIZE];
			
			int i = 0;
			while (i++<entries) {
			//try {
					line = fileReader.readLine(); //reading next line
					if (line == null)
						break;
				//fileWriter.println();
				//fileWriter.println(LINE_MESSAGE + line);
					tokens = new StringTokenizer(line);
					
					if (tokens.countTokens()!=3) throw new RuntimeException(" line " + (i+1) + " has less than 3 tokens" );
					
					
					row = Integer.parseInt(tokens.nextToken());
					col = Integer.parseInt(tokens.nextToken());
					digit = Integer.parseInt(tokens.nextToken());
					board[col][row] = digit;
					
					
					
			} // while
			
			k = new SuDoKuSolver(board);
			
			
		
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} // method testVeryLongIntMethods


}
