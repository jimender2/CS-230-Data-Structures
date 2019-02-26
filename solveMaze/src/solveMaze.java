import java.io.IOException;
import java.util.Random;

public class solveMaze {

	public class Position {
		private int X;
		private int Y;

		public Position( int X, int Y) {
			this.X = X;
			this.Y = Y;
		}
	}
	
	public static void main(String[] args) {

//Over then down
		char[][] maze = {
						{'#', '.', '.', '.', '.', '#', '#', '#', '.', '#'},
						{'.', '.', '#', '#', '.', '#', '#', '#', '.', '#'},
						{'#', '#', '#', '#', '.', '.', '.', '#', '.', '#'},
						{'#', '.', '#', '#', '.', '#', '.', '#', '#', '#'},
						{'#', '.', '.', '.', '.', '.', '#', '#', '.', '#'},
						{'#', '#', '#', '.', '#', '.', '#', '#', '.', '#'},
						{'#', '#', '#', '#', '#', '.', '.', '.', '.', '.'},
						{'#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
						{'#', '#', '#', '#', '#', '#', '.', '.', '.', '#'},
						{'#', '#', '#', '#', '#', '#', '#', '#', '.', '#'}
						};

//		int p = 10;
//		int q = 10;
//		char[][] maze = mazeGenerate();
//		
//		int i = 0, j = 0;
////		while (i<p){
////			j=0;
////			while (j<q) {
////				System.out.println(maze[i][j]);
////				j++;
////			}
////			i++;
////		}
//		int X = 2;
//		int Y = 2;
//		//System.out.println(maze[1][1]);
		
		int X = 0;
		int Y = 1;
		mazeTraverse(maze, X, Y);

		java.awt.Toolkit.getDefaultToolkit().beep();

		int i = 0;
		int j = 0;

		while (i<maze[0].length) {
			j = 0;
			while (j<maze.length) {
				System.out.print(maze[i][j] + " ");
				j++;
			}
			System.out.println("");
			i++;
		}

	}
	
	private static char[][] mazeGenerate() {

		Random rand = new Random();
		
		int X = rand.nextInt(10) + 2;
		int Y = rand.nextInt(10) + 2;
		if (X % 2 == 0)
			X = X + 1;
		if (Y % 2 == 0)
			Y = Y + 1;
		System.out.println(X + " " + Y);


		char[][] maze = new char[Y][X];

		for ( int t = 0; t < Y; t++) {
			maze[t][0] = '#';
			maze[t][X-1] = '#';
		}

		for ( int t = 0; t < X; t++) {
			maze[0][t] = '#';
			maze[Y-1][t] = '#';
		}
		
		for ( int t = 1; t < Y; t++) {
			
		}

		int i = 0;
		int j = 0;

		while (i<X) {
			j = 0;
			while (j<Y) {
				System.out.print(maze[j][i] + " ");
				j++;
			}
			System.out.println("");
			i++;
		}

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
			//debug
			System.out.println("I am at : " + X.peek() + " " + Y.peek());
			
			//determine if I can go south
			if( (Y.peek() + 1) < maze.length)
				//check to make sure that if I went there the character is not a # a - or a @
				if( (maze[Y.peek()+1][X.peek()] != '#') && (maze[Y.peek()+1][X.peek()] != '-') && (maze[Y.peek()+1][X.peek()] != '@')) {
					dir = dir + "S";
				}
			//north?
			if( (Y.peek() - 1) >= 0)
				if( (maze[Y.peek()-1][X.peek()] != '#') && (maze[Y.peek()-1][X.peek()] != '-') && (maze[Y.peek()-1][X.peek()] != '@')) {
					dir = dir + "N";
				}
			//east?
			if( (X.peek() + 1) < maze[0].length) 
				if( (maze[Y.peek()][X.peek()+1] != '#') && (maze[Y.peek()][X.peek()+1] != '-') && (maze[Y.peek()][X.peek()+1] != '@')) {
					dir = dir + "E";
				}
			//west?
			if( (X.peek() - 1) >= 0)
				if( (maze[Y.peek()][X.peek()-1] != '#') && (maze[Y.peek()][X.peek()-1] != '-') && (maze[Y.peek()][X.peek()-1] != '@')) {
					dir = dir + "W";
				}

			//debug
			System.out.println(dir);
			
			//if I cant go any direction then I need to pop
			if( dir.equals("")) {
				//set the popped location to be an @ so I dont go down the path again
				maze[Y.pop()][X.pop()] = '@';
				maze[Y.peek()][X.peek()] = '-';
			} else {
				//I should be able to go a different direction so lets try to go east first
				if( dir.contains("E")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek()+1);
					dir = "";
				}
				//if that does not work I might be able to go north
				if( dir.contains("N")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek()-1);
					X.push(X.peek());
					dir = "";
				}
				//possibly south?
				if( dir.contains("S")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek()+1);
					X.push(X.peek());
					dir = "";
				}
				//must be west then
				if( dir.contains("W")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek()-1);
					dir = "";
				}
			}

			//print maze out
			int i = 0;
			int j = 0;
			while (i < maze.length) {
				j = 0;
				while (j < maze[0].length) {
					System.out.print(maze[i][j] + " ");
					j++;
				}
				System.out.println("");
				i++;
			}
			
			//If I reach the farthest east side I must have found the exit
			if( (X.peek() >= (maze[0].length)-1)) {
				found = true;
				blankScreen();
				System.out.println("I found the exit");
				//change the maze to be all spaces along the path
				while (!X.isEmpty() && !Y.isEmpty()) {
					maze[Y.pop()][X.pop()] = ' ';
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void blankScreen() {
		for ( int t = 1; t <= 50; t++) {
			System.out.println("");
		}
	}

}

////Find a path from (1,1) to the exit (m,m).
////Initialize wall of obstacles around the maze
////Initialize variables to keep track of our current
////position in the maze
//Position here;
//here.row = 1;
//here.col = 1;
////Prevent return to entrance
//maze[1][1] = 'X';
////Search for a path to the exit
//while( not at exit) do {
//find a neighbor to move to;
//if( there is such a neighbor) {
//add position here to path stack;
//// Move to and block neighbor
//here = neighbor;
//maze[here.row][here.col] = 'X';
//}
//else { // Cannot move forward, backup
//if( path empty) return false;
//back up to position here which is at top of path stack;
//}
//return true;
//}