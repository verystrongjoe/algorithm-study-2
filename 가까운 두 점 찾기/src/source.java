import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point {
	public Point(int x2, int y2) {
		this.x = x2;
		this.y = y2;
	}
	public int x;
	public int y;
	
}

public class source {
	

	
	/**
	 * 
	 * https://lyfat.wordpress.com/2012/05/22/euclidean-vs-chebyshev-vs-manhattan-distance/
	 * 
	 * 유클리안 체스보드 그리고 택시캡 거리를 각각 구해서 각각의 최소 좌표를 출력하라
	 * 
	 * 
	 * 문제
			2차원 좌표에서 n개의 점들이 순서대로 주어질 때, 거리가 가장 짧은 쌍을 출력하자.
			
			입력
			첫째 줄에 점들의 개수 n이 주어진다 (2<= n <=5000)
			
			두번째 줄부터 n+1줄까지 한 줄에 하나씩 점의 x좌표와 y좌표가 주어진다.
			
			(좌표 제한 : lxl<=10^8 , lyl<=10^8, 정수)
			
			같은 지점에 2개의 점이 있는 경우는 없다.
			
			출력
			유클리디안 거리가 가장 짧은 쌍,
			
			city-block 거리가 가장 짧은 쌍,
			
			chessboard 거리가 가장 짧은 쌍을 한 줄에 한 쌍씩 출력하라.
			
			거리가 가장 짧은 쌍을 출력할 때는 점의 번호를 오름차순으로 출력하라.
			
			또한, 거리가 가장 짧은 쌍이 여러쌍일때는 번호 쌍이 가장 작은 쌍을 출력하라.
			
			ex)
			
			(1,2) < (5, 8)
			
			(2,7) < (2,10)
			
			힌트
			입력 예제
			
			3
			1 1
			-1 -1
			0 0
			출력 예제
			
			1 3
			1 3
			1 3
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p1e = -1, p2e = -1;
		int p1c= -1, p2c = -1;
		int p1m= -1, p2m= -1;
		
		int minE = Integer.MAX_VALUE;
		int minC = Integer.MAX_VALUE;
		int minM = Integer.MAX_VALUE;
		
		int n = Integer.parseInt(br.readLine().trim());
		Point[]  point = new Point[n];
		
		for(int i = 0; i < n; i++) {
			String[] splits = br.readLine().split(" ");
			int x = Integer.parseInt(splits[0]);
			int y = Integer.parseInt(splits[1]);
			
			point[i] = new Point(x,y);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				
				int dx = point[i].x - point[j].x;
				int dy = point[i].y - point[j].y;

				if( dx == 0 ||  dy == 0)  {
					
					int result;
					
					if(dx == 0 ) {
						result = Math.abs(dy);
					}else{
						result = Math.abs(dx);
					}
					
					if(minE > result ) {
						minE = result;
						p1e = i;
						p2e = j;
					}
					
					if(minC > result ) {
						minC = result;
						p1c = i;
						p2c = j;
					}
					
					if(minM > result ) {
						minM = result;
						p1m = i;
						p2m = j;
					}
					
				} else {

					int resultE = (int) Math.sqrt(Math.pow(dx ,  2)  +  Math.pow( dy, 2));
					int resultM = Math.abs(dx) + Math.abs(dy); // 
					int resultC = Math.max(Math.abs(dx),Math.abs(dy));
					
					if(minE > resultE ) {
						minE = resultE;
						p1e = i;
						p2e = j;
					}
					
					if(minM > resultM ) {
						minM = resultM;
						p1m = i;
						p2m = j;
					}
					
					if(minC > resultC ) {
						minC = resultC;
						p1c = i;
						p2c = j;
					}
					

					
				}
				
			}
		}
		
		System.out.println((p1e +1) + " " +( p2e +1));
		System.out.println((p1m +1) + " " + (p2m +1));
		System.out.println((p1c +1) + " " + (p2c +1));
	}

}


