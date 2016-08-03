import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  KMP 알고리즘 
 *  http://blog.naver.com/choyi0521?Redirect=Log&logNo=80206821567
 *   
 *  문자열 패턴 검색시 유용한 알고리즘
 */
class source {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
	
		String context = br.readLine();
		String pattern = br.readLine();

		/**
		 * P는 Prefix/Postfix의 준말을 쓴거 같고 여튼 점화식 함수이다. 이 알고리즘의 기반은 동적프로그래밍이라고 알아두자
		 * P[i]는 1~i까지의 문자열에 대해 1~i의 문자열(전체로 prefix = postfix가 같게 되므로 의미 상실) 제외한 prefix와 postfix가 같은 최대 문자열의 길이라고 정의!!
		 */ 
		int[] P = new int[pattern.length()];
		P[0] = -1;
		int now = -1;

		for(int i = 1 ; i < pattern.length(); i++) {
			if(  pattern.charAt(1+now) == pattern.charAt(i) ) {
				now++;
				P[i] = now ;
			} else if(now == -1) {
				P[i] = -1;
			}else {
				now= i-1;;
				while(now!= -1) {
					now = P[now];
					if(pattern.charAt(now+1)  == pattern.charAt(i)) {
						P[i] = now+1;
						break;
					}
				}
				if(now == -1) P[i] = now;
			}
		}

		/**
		 * P[i]를 구하게 되면 이를 가지고 원래 context를  iterate하면서 계속 스캔을 한다. 
		 * 그래서 실제로 P[i]를 이용하여 계산
		 * 실제로 찾은 것  개수를 sum up 하면서 총 찾은 횟수를 찾을 수 있다.
		 * 
		 */
		int p= 0;
		int i = 0;
		int result=0;
		List<Integer>startIndexList = new ArrayList<Integer>();

		while( i  < context.length()  ) {
			if(pattern.charAt(p) == context.charAt(i)) {
				if(p == pattern.length()-1) {
					result ++;
					startIndexList.add(i +1 - pattern.length() + 1);
					
					if(P[p] == -1) {
						p = 0;
						i ++;
					}else {
						p  = P[p]+1;
						i+=p;
					}
					i ++;
				} else {
					p++;
					i++;
				}
			} else {
				if(P[p] == -1) {
					p = 0;
					i ++;
				}else {
					p  = P[p]+1;
					i+=p;
				}
			}
		}
		
		System.out.println(result);
		for(Integer s : startIndexList)
			System.out.print(s + " ");
		System.out.println();
	}
}
