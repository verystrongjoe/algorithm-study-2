import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class source {

	static Queue<Integer>  queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int height = sc.nextInt();	
		
		int[][]  board = new int[width][height];
		int[][]  visited = new int[width][height];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0 ; j < height; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int p = 0 * 101 + 0;
		queue.add(p);
		int flag = board[0][0];
		
		while(!queue.isEmpty()) {
			
			p = queue.poll();
			
			int x = p / 101;
			int y = p % 101;
			
//			if(flag == visited[x][y]) visited
				
			
		}
		
		
		
		
		
		sc.close();
		
	}

}
