import java.io.IOException;
import java.util.Scanner;

public class source {
	
	static long[][] D = new long[201][201];
	static final int mod =  1000000000;
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
	
		// D[i][j] : 0~i의 숫자를 j개 사용하여 i를 만들수 있는 경우의 수
		for(int i =  0; i <= N; i++)  {
			D[i][0] = 0;
			D[i][1] = 1;
		}
		for(int j = 1; j <=K; j++) {
			D[0][j] = 1;
		}
		
		
		for(int i = 1; i <= N; i++) { // `1~N까지 숫자
			for(int j = 1; j <= K; j++) {   // j는 사용가능한 숫자 개수
				for(int k = 0; k <=i; k++) {
					D[i][j] = (D[i][j] + D[i-k][j-1]) % mod; 
				}
			}
		}
		
		System.out.println(D[N][K]);
	}
				
}
