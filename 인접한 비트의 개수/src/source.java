import java.io.IOException;
import java.util.Scanner;

public class source {
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();	

		long[][][] D= new long[101][101][100];
		
		for(int t= 1; t <= T; t++) {
			int testcase = sc.nextInt();	
			int n = sc.nextInt();
			int k = sc.nextInt();
		
			D[1][0][0] = 1;
			D[1][0][1] = 1;
			
			for(int i = 2; i<=n;  i++) {
				for(int j = 0; j<=k; j++) {
					D[i][j][0] = D[i-1][j][0] + D[i-1][j][1];
					
					if(j-1 < 0) {
						D[i][j][1] = D[i-1][j][0];
					} else {
						D[i][j][1] = D[i-1][j][0] + D[i-1][j-1][1];
					}
					
				}
			}
			
			System.out.println (testcase + " " + (D[n][k][0] + D[n][k][1]) );
		}
		
		
//		/*
//		1 6
//		2 63426
//		3 1861225
//		4 168212501
//		5 44874764
//		6 160916
//		7 22937308
//		8 99167
//		9 15476
//		10 23076518*/
		
		
	}

}
