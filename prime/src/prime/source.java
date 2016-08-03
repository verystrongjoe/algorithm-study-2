package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/***
	 * 
	 * 
	 * 문제
			어떤 수열 S가 주어진다. 수열 S에서 한 개 이상 원소를 선택했을 때, 선택한 수 혹은 수들의 최대공약수가 1이 되는 것의 개수를 구하는 프로그램을 작성하시오.
			
			입력
			첫 번째 줄에 수열의 크기 N이 주어진다. (1 ≤ N ≤ 100)
			
			두 번째 줄부터 N개의 줄에 걸쳐 수열의 각 원소 Si가 주어진다. 어떤 두 원소가 같을 수 있다. (1 ≤ Si ≤ 100,000)
			
			출력
			첫 번째 줄에 정답을 10,000,003으로 나눈 나머지를 출력한다.
			
			힌트
			입력 예제
			
			3
			2
			4
			3
			출력 예제
			
			3
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 * 
	 * 
	 */
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		int[] S = new int[N];

		for(int i = 0 ; i < N; i++) {
			S[i]=  Integer.parseInt(br.readLine());
			
		}
		
		
		
	}

}
