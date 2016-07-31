import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	
	/**
	 * 
	 * 문제
			몬테 칼로 알고리즘을 사용하여 원주율(pi)의 근사값을 구하여라.
			
			입력
			무의미한 1을 입력 받는다.
			
			출력
			몬테 칼로 알고리즘을 사용하여 원주율(pi)값을 소수점 2번째 자리까지 반올림하여 출력하라.
			
			(꼭 몬테 칼로 알고리즘을 사용하여야 함)
			
			힌트
			예제 입력
			
			1
			예제 출력
			
			3.14
			

	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
//		String[] splits = br.readLine().split(" ");

//		int[] arrays = new int[N];
//		for(int i = 0 ; i < N; i++)
//			arrays[i] = Integer.parseInt(splits[i]);
		
		
		int[] D = new int[N+1];
		
		D[1] = 0;
		D[2] = 1;
		
		for(int i=2; i <=N; i++) {
			if(i==2) continue; 
			D[i] = ( i-1 )* ( D[i-1] + D[i-2] );
		}
		System.out.println(D[N]);	
				
	}
		

}


