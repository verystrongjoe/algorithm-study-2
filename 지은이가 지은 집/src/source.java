import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/*
	 * 문제
		최근에 지은이는 건축에 관심이 많아 집을 짓게 되었다. 태양이는 지은이가 지은 집에 놀러갔다. 근데 아니나 다를까 집에 작은 구멍이 있는 것이다. 지은이와 태양이는 집을 보수하기로 했다.
		다행히도 지은이가 집을 짓다가 남은 재료가 남아서, 이를 이용하여 집을 보수하기로 했다. 구멍이 난 곳의 너비는 x센티미터이다. 태양이와 지은이는 사이가 너무 좋아서, 남은 재료 중 하나씩 골라서 이어 붙이고, 이로 구멍을 막기로 했다. 즉, 태양이과 지은이가 고른 재료의 길이가 L1, L2이면, L1+L2가 x와 같아야 구멍을 막을 수 있다. 크기가 다르면, 또 망가질 위험이 있기 때문이다.
		그럼 이제 구멍을 완벽하게 막을 수 있는 두 막대를 구하는 프로그램을 작성하시오.
		시간제한: 1초
		
		입력
		첫째 줄에는 구멍의 너비 x가 주어진다. X의 단위는 센티미터이다.
		다음 줄에는 재료의 개수 n이 주어진다. (1<=n<=1000000)
		다음 n개의 줄에는 재료의 길이 L이 주어진다. L의 단위는 나노미터이다. 재료의 길이는 10센티미터(100000000 나노미터)를 넘지 않는다.
		
		출력
		구멍을 완벽하게 막을 수 있는 두 조각이 없다면 ‘danger’를 줄력한다. 
		막을 수 있는 경우에는 ‘yes L1 L2’를 출력한다. (L1<=L2). 정답이 여러 개인 경우에는 |L1-L2|가 가장 큰 것을 출력한다.
		
		힌트
		입력 예제
		1
		4
		9999998
		1
		2
		9999999
		출력 예제
		yes 1 9999999
	 */
	
	
	public static int result = -1;
	public static int result_first_index =  -1;
	public static int result_last_index = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
//
//		int holeWidth = sc.nextInt() * 10000000; //나노 미터로 변경
//		int materialCount = sc.nextInt();
//		int[] materialLengthList = new int[materialCount]; 
//		int realsize = 0;
//		
//		for(int i = 0 ; i < materialCount; i++) {  // 1< = materialCount < = 1000000
//			int l = sc.nextInt();
//		
//			if(l <= holeWidth) {
//				materialLengthList[i] = l;     //   10센티미터(100000000 나노미터)
//				realsize ++;
//			}
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int holeWidth = Integer.parseInt(br.readLine()) * 10000000; //나노 미터로 변경
		int materialCount = Integer.parseInt(br.readLine());
		int[] materialLengthList = new int[materialCount]; 
		int realsize = 0;
		
		
		for(int i = 0 ; i < materialCount; i++) {  // 1< = materialCount < = 1000000
			int l = Integer.parseInt(br.readLine());
		
			if(l <= holeWidth) {
				materialLengthList[i] = l;     //   10센티미터(100000000 나노미터)
				realsize ++;
			}
		}
		
		
		int first = 0;
		int last = realsize - 1;
		
		if(realsize >= 2) {
		
			while( first != last ) {
				
				int sumLength = materialLengthList[first] + materialLengthList[last]; 
				if( sumLength == holeWidth)  {
					int tmp = Math.abs(materialLengthList[first] - materialLengthList[last]);
					if(result <= tmp) {
						result =  tmp;
						result_first_index = first;
						result_last_index = last;
					} 
					first ++;
					last = realsize-1;
				} else if( sumLength > holeWidth) {
					
					
				} else {
					last --;
					if(last  == first) {
						last = realsize-1;
						if(first < last) first ++;
					}
					
				}
			}
		}

		if(result != -1) {
			System.out.println("yes " + materialLengthList[result_first_index] + " " + materialLengthList[result_last_index] );
		} else {
			System.out.println("danger");
		}
		
	}

}