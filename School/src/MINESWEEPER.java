import java.util.Scanner;
public class MINESWEEPER
{
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the size of your game:");
		int N = reader.nextInt();
		String useless = reader.nextLine()+"";
		
	
		System.out.println("");
		System.out.println("-------------------------------------");  //starts off the game and tells the user how to play
		System.out.println("[ENTER THE X COORDINATE]");
		System.out.println("[ENTER THE Y COORDINATE]");
		System.out.println("[TYPE \"!\" IF YOU WANT TO FLAG]");
		System.out.println("[PRESS ENTER TO TEST YOUR GUESS");
		System.out.println("-------------------------------------");
		System.out.println("");

        
		int[][] mines = new int[N][N];   //populates an 2D array of the specified size with some bombs
		int mineCount = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (Math.random()>0.9) { //each tile has a 10% chance of being a bomb
					mines[i][j] = -1;
					mineCount++;
				}
			}
		}

		int index, count;
		String tile = "";
		String[][] grid = new String[N][N];
		int[] dx = {-1,0,1};
		int[] dy = {-1,0,1};
		for (int i=0; i<N; i++) {  //finds the number of mines near each tile
			for (int j=0; j<N; j++) {
				index = mines[i][j];
				if (index==-1) {  //skips if the tile is already a mine
					tile = "X";
				} else {
					count = 0;  
					for (int x: dx) { 
						for (int y: dy) {
							if ((i+x<N)&&(-1<i+x)) { //stays in the bounds of the array
								if ((j+y<N)&&(-1<j+y)) {
									if (mines[i+x][j+y] == -1) {
										count++;  //there is a mine nearby; add 1 to the count
									}
								}
							}
						}
					}
					if (count > 0) {
						tile = count+""; // saves the number of nearby mines
					} else {
						tile = " "; // stays empty if there aren't any mines nearby
					}

				}
				grid[i][j] = tile;//writes the number of mines to the tile display
			}
		}
		int[][] seenTiles = new int[N][N]; //array of which tiles have been explored so far

		int X, Y; // x and y coordinate of the user's input
		String choice;  //flag or not

		printBoard(N,grid,seenTiles); //prints the board

		while (true) {  //PLAYS THE GAME!!

			X = Integer.parseInt(reader.nextLine())-1; //reads the user input
			Y = N-Integer.parseInt(reader.nextLine()); //reads the user input
			choice = reader.nextLine();                //reads the user input
			System.out.println("");
			
			if (choice.equals("")) {  //if regular check
				if (grid[Y][X].equals(" ")) {
					seenTiles = clearNeighbors(N,grid,seenTiles,Y,X);  // if zero mines are nearby we can safely expose the 8 adjacent tiles as well
				} else {
					seenTiles = clearTile(grid,seenTiles,Y,X); // if not, just look at the selected tile
				}

				printBoard(N,grid,seenTiles);  //update the board display; repeat
			} else if (choice.equals("!")) {  //the user wants to flag a mine
				seenTiles[Y][X] = 1;
				grid[Y][X] = "#"; //replaces the selected tile with a flag tile

				printBoard(N,grid,seenTiles); //update the board display; repeat
			}
			boolean test = true;  
			for (int[] i: seenTiles) {  //checks if they won; have all tiles been checked?
				for (int j: i) {
					if (j != 1) {
						test = false;
					}
				}
			}
			int flagCount = 0;
			for (String[] i: grid) { //checks if they won; have all mines been flagged?
				for (String j: i) {
					if (j.equals("#")) {
						flagCount++;
					}
				}
			}
			if (test && (flagCount == mineCount)) {  //if yes, they win!
				break;
			} else if (test && (flagCount != mineCount)) { // if they see all tiles but have redundant flag placements, they will lose
				while (true) {
					System.out.println("YOU LOSEEEE AHAHAHAHAHAHAHHAHAHAAAAAAAAAAAA");
				}
			}
		}
		reader.close();
		System.out.println("u win :)"); //done :)
	}

	public static void printBoard(int N, String[][] grid, int[][] seenTiles) {  //prints the board
		System.out.print("-+-"); //adds a row of danshes
		for (int k=0; k<N; k++) {
			System.out.print("--+-");
		}
		System.out.println("");
		for (int i=0; i<N; i++) {
			System.out.print(" | "); //splits each tile entry with a dash
			for (int j=0; j<N; j++) { 
				if (seenTiles[i][j] == 1) {
					System.out.print(grid[i][j]); // prints the value of the tile of it's visible
				} else {
					System.out.print("-"); //prints a dash if not
				}
				System.out.print(" | "); //splits each tile entry with a dash
			}
			System.out.println(""); 
			System.out.print("-+-"); //splits each row with dashes
			for (int k=0; k<N; k++) {
				System.out.print("--+-"); 
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static int[][] clearNeighbors(int N, String[][] grid, int[][] seenTiles, int i, int j) {  //expose a 3x3 area of tiles

		int[] dx = {-1,0,1};
		int[] dy = {-1,0,1};
		for (int x: dx) { //loops through the neighboring tiles
			for (int y: dy) {
				if ((i+x<N)&&(-1<i+x)) {
					if ((j+y<N)&&(-1<j+y)) {
						seenTiles[i+x][j+y] = 1; //adds the tiles to the visibility list
						if (grid[i+x][j+y].equals("X")) { // click a bomb = lose 
							while (true) {
								System.out.println("YOU LOSEEEE AHAHAHAHAHAHAHHAHAHAAAAAAAAAAAA");
							}
						}
					}
				}
			}
		}

		return seenTiles; //returns the newly modified list
	}

	public static int[][] clearTile(String[][] grid, int[][] seenTiles, int i, int j) { //expose just one tile
		seenTiles[i][j] = 1;//adds the tile to the visibility list
		if (grid[i][j].equals("X")) { // click a bomb = lose 
			while (true) {
				System.out.println("YOU LOSEEEE AHAHAHAHAHAHAHHAHAHAAAAAAAAAAAA");
			}
		}
		return seenTiles;  //returns the newly modified list
	}
}
