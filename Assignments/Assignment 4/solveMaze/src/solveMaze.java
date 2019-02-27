import java.util.Random;
 /**
  * This program implements a maze generation and maze solving algorithm.
  * It may not be the most efficient but it gets the job done.
  * Please run in windows. The sound beep may not work in linux or mac os.
  * 
  * @author Jonathan Meredith
  *
  */

public class solveMaze {

	public static void main(String[] args) {

		//declare variables
		Random rand = new Random();
		int yWide = rand.nextInt(5) + 5;
		int xWide = rand.nextInt(5) + 5;

		//make maze
		char[][] maze = new char[yWide][xWide];

		//mix up maze
		maze = mazeGenerate(maze, yWide, xWide);

		//make starting position
		int X = 0;
		int Y = rand.nextInt(yWide);

		//make sure starting position is not on a corner
		if (Y == 0) {
			Y++;
		} else if (Y == maze.length-1) {
			Y--;
		}

		//traverse maze
		mazeTraverse(maze, X, Y);

		//clear @s
		clearBadPaths(maze);

		//display and beep when done
		display(maze);
		java.awt.Toolkit.getDefaultToolkit().beep();

	}

	public static char[][] mazeGenerate(char[][] maze, int widthOfMaze,
			int heightOfMaze) {

		//declare variable
		Random rand = new Random();

		//Initialize maze
		for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = '#';
            }
        }		

		//declare variables and decide how many spots to change
		int row,
			col;
		int percent = (int) (widthOfMaze * heightOfMaze * 1.5);

		//randomly change spots
		for( int i = 1; i <= percent; i++) {
			row = rand.nextInt(widthOfMaze);
			col = rand.nextInt(heightOfMaze);

			if(maze[row][col]=='#') {
				maze[row][col]= '.';
			}
		}

		//add border to this
		int _i = maze.length;
		int _j = maze[0].length;
		for (int i = 0; i < _i; i++) {
		    for (int j = 0; j < _j; j++) {
		        if(i==0 || j == 0 || i == _i - 1|| j == _j - 1){
		            maze[i][j] = '#';
		        }
		    }
		}

		//add random end
		maze[rand.nextInt(maze.length - 3) + 1][maze[0].length - 1] = '.';

		//return
		return maze;
	}

	public static void mazeTraverse(char[][] maze, int XS, int YS) {

		//declare stacks
		LinkedStack<Integer> X = new LinkedStack<>();
		LinkedStack<Integer> Y = new LinkedStack<>();
		
		//add the starting coordinates to the stacks
		X.push(XS);
		Y.push(YS);

		//set this equal to the path
		maze[YS][XS] = '-';

		//detect which ways I can move (this part should have been combined with the section underneath but I kept it in)
		String dir = "";
		boolean found = false;
		while (!found) {
			//clear screen for animation
			blankScreen();
						
			//determine if I can go south
			if( (Y.peek() + 1) < maze.length)
				//check to make sure that if I went there the character 
				//is not a # a - or a @
				if( (maze[Y.peek() + 1][X.peek()] != '#')
						&& (maze[Y.peek() + 1][X.peek()] != '-')
						&& (maze[Y.peek() + 1][X.peek()] != '@')) {
					dir = dir + "S";
				}
			//north?
			if( (Y.peek() - 1) >= 0)
				if( (maze[Y.peek() - 1][X.peek()] != '#')
						&& (maze[Y.peek() - 1][X.peek()] != '-')
						&& (maze[Y.peek() - 1][X.peek()] != '@')) {
					dir = dir + "N";
				}
			//east?
			if( (X.peek() + 1) < maze[0].length) 
				if( (maze[Y.peek()][X.peek() + 1] != '#')
						&& (maze[Y.peek()][X.peek() + 1] != '-')
						&& (maze[Y.peek()][X.peek() + 1] != '@')) {
					dir = dir + "E";
				}
			//west?
			if( (X.peek() - 1) >= 0)
				if( (maze[Y.peek()][X.peek() - 1] != '#')
						&& (maze[Y.peek()][X.peek() - 1] != '-')
						&& (maze[Y.peek()][X.peek() - 1] != '@')) {
					dir = dir + "W";
				}
			
			//if I cant go any direction then I need to pop
			if( dir.equals("")) {
				//catch the exception if stack is empty
				try {
					//set the popped location to be an @ so I dont go down the path again
					maze[Y.pop()][X.pop()] = '@';
					maze[Y.peek()][X.peek()] = '-';
				} catch ( Exception e) {
					blankScreen();
					System.out.println("This maze has no valid path");
					java.awt.Toolkit.getDefaultToolkit().beep();
					break;
				}
			} else {
				//I should be able to go a different direction so lets try to go east first
				if( dir.contains("E")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek() + 1);
				}
				//if that does not work I might be able to go north
				else if( dir.contains("N")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek() - 1);
					X.push(X.peek());
				}
				//possibly south?
				else if( dir.contains("S")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek() + 1);
					X.push(X.peek());
				}
				//must be west then
				else if( dir.contains("W")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek() - 1);
				}

				dir = "";
			}

			//print maze out
			display(maze);

			//If I reach the farthest east side I must have found the exit
			if( (X.peek() >= (maze[0].length) - 1)) {
				found = true;
				blankScreen();
				System.out.println("I found a path to the exit!!");

				//change the maze to be all spaces along the path
				while (!X.isEmpty() && !Y.isEmpty()) {
					maze[Y.pop()][X.pop()] = '-';
				}

				//skip the rest of the loops
				break;
			}

			//reset directions that the thing can go
			dir = "";

			//pause the program for a second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void blankScreen() {
		for ( int t = 1; t <= 50; t++) {
			System.out.println("");
		}
	}

	public static void clearBadPaths(char[][] maze) {
		for(int q = 0; q < maze.length; q++) {
			for(int p = 0; p < maze[q].length; p++) {
				if(maze[q][p] == '@') {
					maze[q][p] = '.';
				}
			}
		}
	}

	public static void display(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}
	}
}