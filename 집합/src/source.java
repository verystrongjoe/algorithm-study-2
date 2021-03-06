import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class source {
	
	static final int  bigVal = 1000001;
	
	public static void main(String[] args) throws IOException {

		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt(); 
		int M = sc.nextInt();

		int[] A = new int[N+1];
		int[] B = new int[M+1];

		int [][] D = new int[N+1][M+1];


		A[0] = 0;
		for(int n = 1; n <= N; n++) {
			A[n] = sc.nextInt();
		}

		B[0] = 0;
		for(int m = 1; m <= M; m++) {
			B[m] = sc.nextInt();
		}

		Arrays.sort(A);
		Arrays.sort(B);

		D[0][0] = 0;

		if(N > M) {

			for(int i = 1; i <= M; i++) {
				D[0][i] = bigVal;
			}

			for(int i = 1; i <= N; i++) {
				if(N-M < i) D[i][0] = bigVal;
			}
			
		} else if( N < M) {

			for(int i = 1; i <= N; i++) {
				D[i][0] = bigVal;
			}
			
			for(int i = 1; i <= M; i++) {
				if(M-N < i) D[0][i] = bigVal;
			}
			
		}

		for(int i = 1 ; i <= N;  i++) {
			for(int j = 1; j <= M; j++) {
				D[i][j] = Math.min( D[i-1][j],  D[i-1][j-1] + Math.abs(A[i]- B[j]) );
			}
		}

		System.out.println(D[N][M]);
	}
}
