import java.io.IOException;
import java.util.Scanner;

public class source {
	
	public static int[] L;
	public static int n;
	public static int k;
	public static int[][] D  = new int[101][10001]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] splits = br.readLine().split(" ");

		Scanner sc = new Scanner(System.in);
		
//		n = Integer.parseInt(splits[0]);
//		k = Integer.parseInt(splits[1]);
		
		n = sc.nextInt();
		k = sc.nextInt();
		L = new int[n+1];
		
		for(int j = 1 ; j <= n; j++) {
//			L[j] =  Integer.parseInt(br.readLine());
			L[j] = sc.nextInt();
		}
		

		D[0][0] = 1;
		
		for(int i = 1; i <=n; i++) {
			for(int j = 0; j <= k; j++)  {
				for(int m = 0; m <= j/L[i]; m++) {
						D[i][j] = (D[i][j] +  D[i-1][ j -  ( m *  L[i] )] ) % 1000000; 
				}
			}
		}
		
		System.out.println(D[n][k]);

	}
	
}