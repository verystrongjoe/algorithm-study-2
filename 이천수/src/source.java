import java.io.IOException;
import java.util.Scanner;

public class source {
	
	static long[][] D = new long[90][2];

	public static void main(String[] args) throws IOException {
	
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();

		D[1][0] = 0;
		D[1][1] = 1;
				
		for(int i = 2; i <= input; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}

		System.out.println(D[input][0] + D[input][1]);
	
	}

}
