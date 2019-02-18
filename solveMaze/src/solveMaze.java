import java.util.Random;
public class solveMaze {

	public static void main(String[] args) {

//Over then down
//		char[][] maze = {
//						{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
//						{'.', '.', '#', '#', '#', '#', '#', '#', '#', '#'},
//						{'#', '.', '#', '#', '.', '.', '.', '#', '#', '#'},
//						{'#', '.', '#', '#', '.', '#', '.', '.', '.', '#'},
//						{'#', '.', '.', '.', '.', '#', '#', '#', '.', '#'},
//						{'#', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
//						{'#', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
//						{'#', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
//						{'#', '#', '#', '#', '#', '#', '#', '#', '.', '.'},
//						{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
//						};
		int p = 10;
		int q = 10;
		char[][] maze = mazeGenerate(p, q);
		
		int X = 0;
		int Y = 0;
		//System.out.println(maze[1][1]);
		
		//mazeTraverse(maze, X, Y);
	}
	
	private static char[][] mazeGenerate( int p, int q) {

		char[][] maze = new char[p][q];
		
		Random rand = new Random();
		int start = rand.nextInt(q);
		return null;
	}

	public static void mazeTraverse(char[][] maze, int X, int Y) {

		boolean found = false;
		
		while (found) {
			if (maze[X+1][Y] == '.') {
				
			} else if ( maze[1][1] == '1') {
				
			}
		}
		
	}

}
