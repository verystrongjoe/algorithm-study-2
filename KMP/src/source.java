import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *  KMP 알고리즘 
 *  http://blog.naver.com/choyi0521?Redirect=Log&logNo=80206821567
 *  문자열 패턴 검색시 유용한 알고리즘
 *  
 *  테스트 케이스!!
 *  ababcababcababac
	ababcababcababaa

	ABCDABCDABEE
	ABCDABE
	
	AAAA
	AA
	
	ABAABCCA
	AA
	
	A B C D A B E
	-1-1-1 -1 0 -1 -1
 */
class source {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		String context = br.readLine();
		String pattern = br.readLine();

		int[] P = new int[pattern.length()];
		P[0] = -1;
		int now = -1;

		for(int i = 1 ; i < pattern.length(); i++) {
			if(  pattern.charAt(1+now) == pattern.charAt(i) ) {
				P[i] = ++now ;
			} else if(now == -1) {
				P[i] = -1;
			}else {
				now= i-1;
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

		int p= 0;
		int i = 0;
		int result=0;
		List<Integer>l = new ArrayList<Integer>();

		while( i  < context.length()  ) {
			
			if(pattern.charAt(p) == context.charAt(i)) {
				if(p == pattern.length()-1) {
					result ++;
					l.add(i +1 - pattern.length() + 1);
					p =P[p];
				} 
				p++;
				i++;
			} 
			else { 	// 여기는 unmatch가 일어났당!!
				if(p==0) i++;
				else {
					while(p != 0) {
							p = P[p-1];
							if( p == -1) {
								p=0; break;
							} else if(context.charAt(i) == pattern.charAt(p+1)) {
								p++;
								break;
							}
					}
				}
			}
		}
		
		bw.write(result + "\n");
//		System.out.println(result);
		for(int q = 0; q < l.size(); q++) {
//			System.out.print(l.get(q)  + " " );
			bw.write(l.get(q)  + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
