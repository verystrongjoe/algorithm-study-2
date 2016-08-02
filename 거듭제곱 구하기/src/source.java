import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * 
 * 해설 모듈로 연산자에 대한 우선 퍼포먼스를 위한 트릭이 필요하므로 아래 URL 참고
 * https://en.wikipedia.org/wiki/Modulo_operation
 * 
 * 
 * 문제
		정수 a와 m이 주어 졌을때, a의 m 거듭제곱을 1,000,000,007 로 나눈 나머지를 출력하는 문제이다.
		
		입력
		두 정수 a와 m이 주어진다. 1 <= a, m <= 2^63 - 1
		
		출력
		a 의 m 제곱 값을 10억 7로 나눈 나머지를 출력한다.
		
		힌트
		예제 입력
		2 4
		예제 출력
		16
 * 
 *
 */
public class source {
	
	final static int MOD =  1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		String[] splits = br.readLine().split(" ");
		
		long a = Long.parseLong(splits [0]);
		long m = Long.parseLong(splits [1]);
		
		long result = 1, now = a;
		
		while(m != 0) {
			if( (m & 1) == 1) result =  ( result * now ) % MOD ;
			now = (now * now) % MOD;
			m = m >> 1;
		}
		System.out.println(result);
	}

}
