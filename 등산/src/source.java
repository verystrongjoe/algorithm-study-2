import java.io.IOException;
import java.util.Scanner;

public class source {
	
	static int[][] altitude;
	static int result = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
	
		N = sc.nextInt();
		altitude = new int[N][N];

		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				altitude[i][j] = sc.nextInt();
			}
		}

		backtracking(0,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	
		System.out.println(result);
	}


	private static void backtracking(int x, int y, int maxAltitude, int minAltitude) {

		if( x > N || x < 0 || y > N || y < 0) return;

		maxAltitude = Math.max(maxAltitude, altitude[x][y]);
		minAltitude = Math.min(minAltitude, altitude[x][y]);
		
		if(x == N-1 && y == N-1) {
			result = Math.min(result, maxAltitude - minAltitude); 
			return;
		}
		
		//pruning
		if(maxAltitude-minAltitude > result) return;

		if(y-1 >= 0 ) backtracking(x, y-1, maxAltitude, minAltitude); //╩С
		if(y+1 < N ) backtracking(x, y+1, maxAltitude, minAltitude); //го
		if(x-1 >= 0 ) backtracking(x-1, y, maxAltitude, minAltitude); //аб
		if(x+1 < N) backtracking(x+1, y, maxAltitude, minAltitude); //©Л
		
	}
	
}
