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
						{'#', '.', '.', '.', '.', '#', '#', '#', '#', '.', '#'},
						{'.', '.', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
						{'#', '#', '#', '#', '.', '.', '.', '.', '#', '.', '#'},
						{'#', '.', '#', '#', '.', '#', '.', '.', '#', '#', '#'},
						{'#', '.', '.', '.', '.', '.', '#', '#', '#', '.', '#'},
						{'#', '#', '#', '.', '#', '.', '#', '#', '#', '.', '#'},
						{'#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#'},
						{'#', '#', '#', '#', '#', '#', '.', '.', '#', '#', '#'},
						{'#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '#'},
						{'#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#'}
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

		LinkedStack<Integer> X = new LinkedStack<>();
		LinkedStack<Integer> Y = new LinkedStack<>();
		
		X.push(XS);
		Y.push(YS);

		maze[YS][XS] = '#';

		String dir = "";
		maze[Y.peek()][X.peek()] = '#';
		boolean found = false;
		while (!found) {
			System.out.println("I am at : " + X.peek() + " " + Y.peek());
			if( (Y.peek() + 1) < maze.length)
				if( (maze[Y.peek()+1][X.peek()] != '#') && (maze[Y.peek()+1][X.peek()] != '-') && (maze[Y.peek()+1][X.peek()] != '@') && (maze[Y.peek()+1][X.peek()] != '-')) {
					dir = dir + "S";
				}
			if( (Y.peek() - 1) >= 0)
				if( (maze[Y.peek()-1][X.peek()] != '#') && (maze[Y.peek()-1][X.peek()] != '-') && (maze[Y.peek()-1][X.peek()] != '@') && (maze[Y.peek()-1][X.peek()] != '-')) {
					dir = dir + "N";
				}
			if( (X.peek() + 1) < maze[0].length) 
				if( (maze[Y.peek()][X.peek()+1] != '#') && (maze[Y.peek()][X.peek()+1] != '-') && (maze[Y.peek()][X.peek()+1] != '@') && (maze[Y.peek()][X.peek()+1] != '-')) {
					dir = dir + "E";
				}
			if( (X.peek() - 1) >= 0)
				if( (maze[Y.peek()][X.peek()-1] != '#') && (maze[Y.peek()][X.peek()-1] != '-') && (maze[Y.peek()][X.peek()-1] != '@') && (maze[Y.peek()][X.peek()-1] != '-')) {
					dir = dir + "W";
				}


			System.out.println(dir);
			if( dir.equals("")) {
				maze[Y.peek()][X.peek()] = '@';
				X.pop();
				Y.pop();
				maze[Y.peek()][X.peek()] = '-';
			} else {
				if( dir.contains("E")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek()+1);
					dir = "";
				}
				if( dir.contains("N")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek()-1);
					X.push(X.peek());
					dir = "";
				}
				if( dir.contains("S")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek()+1);
					X.push(X.peek());
					dir = "";
				}
				if( dir.contains("W")) {
					maze[Y.peek()][X.peek()] = '-';
					Y.push(Y.peek());
					X.push(X.peek()-1);
					dir = "";
				}
			}
			int i = 0;
			int j = 0;

			while (i<maze.length) {
				j = 0;
				while (j<maze[0].length) {
					System.out.print(maze[i][j] + " ");
					j++;
				}
				System.out.println("");
				i++;
			}
			
			if( (X.peek() >= (maze[0].length)-1)) {
				found = true;
				System.out.println("I found the exit");
				
				while (!X.isEmpty() && !Y.isEmpty()) {
					maze[Y.pop()][X.pop()] = '-';
				}
				
				break;
			}

			dir = "";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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