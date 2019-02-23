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
		char[][] maze = mazeGenerate();
		
		int i = 0, j = 0;
//		while (i<p){
//			j=0;
//			while (j<q) {
//				System.out.println(maze[i][j]);
//				j++;
//			}
//			i++;
//		}
		int X = 2;
		int Y = 2;
		//System.out.println(maze[1][1]);
		
//		mazeTraverse(maze, X, Y);
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
			maze[0][t] = 'X';
			maze[Y-1][t] = 'X';
		}

		int i = 0;
		int j = 0;

//		while (i<X) {
//			j = 0;
//			while (j<Y) {
//				System.out.print(maze[i][j] + " ");
//				j++;
//			}
//			System.out.println("");
//			i++;
//		}

		return maze;
	}

//	public static void mazeTraverse(char[][] maze, int XS, int YS) {
//
//		boolean visited[][] = new boolean[XS][YS];
//
//		XS = XS - 1;
//		YS = YS - 1;
//		boolean found = false;
//		LinkedStack<Integer> X = new LinkedStack<Integer>();
//		LinkedStack<Integer> Y = new LinkedStack<Integer>();
//
//		X.push(XS);
//		Y.push(YS);
//		
//		System.out.println(maze);
//		int lastX = XS;
//		int lastY = YS;
//		while (found == false) {
//			System.out.println(X.peek() + " " + Y.peek());
//
//			if ((maze[(int)X.peek()][(int)Y.peek()+1] == '.' ) && ((X.peek() != lastX) && Y.peek() != lastY)) {
//				System.out.println("test1");
//			} else if ((maze[X.peek()][Y.peek()-1] == '.') && ((X.peek() != lastX) && Y.peek() != lastY)) {
//				System.out.println("test2");
//			} else if ((maze[X.peek()+1][Y.peek()] == '.') && ((X.peek() != lastX) && Y.peek() != lastY)) {
//				System.out.println("test3");
//			} else if ((maze[X.peek()-1][Y.peek()] == '.') && ((X.peek() != lastX) && Y.peek() != lastY)) {
//				System.out.println("test4");
//			} else {
//				found = true;
//				System.out.println("shhoot");
//			}
//				
//		}
//		
//	}

}
