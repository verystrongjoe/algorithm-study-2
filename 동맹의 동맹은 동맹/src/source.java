import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class source {

	/**
	 * 
	 * 
	 * 나만의 해설 
	 *  - > 정말 오랜 시간이 소요. 사소한 실수
	 *  그리고 결국 범인은 if else if... 문을 쓰는데도 BL이 각각 있어 선언 순서가 의미가 있는데 그것을 간과한게 문제
	 *  예외 케이스를 if문으로 너무 분기한 것도 하나의 잘못!!
	 *  
	 *  여튼 해결해서 속시원 얼른 다음문제 고고싱!!
	 * 
	 * 
	 * 
	 * 
	 * 문제
			낙성마을에는 N명의 사람이 있다. 편의상 각 사람들을 1번부터 N번까지 번호를 매기도록 하자. 처음 이 사람들은 서로를 모르기 때문에, '적대 관계'를 갖고 있다.
			
			하지만 언제까지나 '적대 관계'로 살아갈 수는 없는 법이다. 이 마을의 사람들은 한 두명씩 '동맹 관계'를 맺기로 하였다. 당연히 어떤 사람 A와 B가 동맹 관계를 맺으면, 자연스럽게 A의 동맹들과 B의 동맹들도 서로 동맹 관계를 맺게 된다. 이런 관계들이 많아지다보니 점점 더 복잡한 구조의 동맹 관계가 구성되게 되었다. 누가 누구와 동맹 관계인지 확실히 알기 위해, 이런 관계를 찾아내는 프로그램을 작성하기로 하였다.
			
			동맹 관계를 쉽게 알아내는 프로그램을 작성하시오.
			
			시간제한 : 1초
			
			입력
			첫 번째 줄에 낙성마을의 사람의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
			
			두 번째 줄에 질의의 수 Q가 주어진다. (1 ≤ Q ≤ 200,000)
			
			세 번째 줄부터 Q개의 줄에 걸쳐 질의가 주어진다. 각 질의는 다음의 형태 중 하나로 주어진다. (1 ≤ a, b ≤ N)
			
			0 a b : a번 사람과 b번 사람이 동맹 관계를 맺었음을 의미하는 질의이다.
			1 a b : a번 사람과 b번 사람이 동맹 관계에 있는지 물어보는 질의이다.
			출력
			1로 시작하는 모든 질의에 대해, 각 줄에 하나씩 동맹 관계가 아니면 0, 동맹 관계이면 1을 출력한다.
			
			힌트
			입력 예제
			
			7 
			9
			0 1 3
			1 1 7
			0 7 6
			1 3 7
			0 3 7
			0 4 2
			0 1 3
			1 1 7
			1 1 1
			출력 예제
			
			0
			0
			1
			1
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int Q = Integer.parseInt(br.readLine().trim());

//		Map<Integer, ArrayList<Integer>> groupCountList = new HashMap<Integer, ArrayList<Integer>>();
		
		List<Integer>[] groupList = new ArrayList[N+1];
		
		int[]  groupNum  = new int[N+1];

		for(int q = 0; q < Q; q++ ) {
			
			String[] splits = br.readLine().split(" ");
			boolean isQuestion;
			int p1, p2;
			isQuestion = (Integer.parseInt(splits[0]) ==0 ) ? false : true;
			p1 = Integer.parseInt(splits[1]);
			p2 = Integer.parseInt(splits[2]);
			int groupNum1 = groupNum[p1];
			int groupNum2 = groupNum[p2];
			
			if(!isQuestion) {
				if(p1 == p2 ) {
				} 
				else if( groupNum1 == groupNum2 && groupNum1 != 0) {
				}
				else if(groupNum1 == 0 && groupNum2 == 0 ) {
//					ArrayList newList = new ArrayList<Integer>();
					
					int key = (p1 < p2) ? p1 : p2;
					groupNum[p1] = key;	
					groupNum[p2] = key;
					
					groupList[key] = new ArrayList<Integer>();
					groupList[key].add(p1);
					groupList[key].add(p2);
					
				} else if(groupNum1 != 0 && groupNum2 == 0) { 
					groupList[groupNum1].add(p2);
					groupNum[p2] = groupNum1;
				} else if(groupNum1 == 0 && groupNum2 != 0){
					groupList[groupNum2].add(p1);
					groupNum[p1] = groupNum2;
				} else { 
					int group1Size  = groupList[groupNum1].size();
					int group2Size =  groupList[groupNum2].size();

					if(group1Size <= group2Size) {
						for(int i =0; i <  group1Size; i++) {
							int elem = groupList[groupNum1].get(i);
							groupList[groupNum2].add(elem);
							groupNum[elem] = groupNum2;
						}
						groupList[groupNum1] = null;
					}
					else {
						for(int i =0; i <  group2Size; i++) {
							int elem = groupList[groupNum2].get(i);
							groupList[groupNum1].add(elem);
							groupNum[elem] = groupNum1;
						}
						groupList[groupNum2] = null;
					}
				}
			} else {
				
				if(p1 == p2)  bw.write("1\n"); 
				else if(groupNum1  == groupNum2) {
					if( groupNum1 == 0) bw.write("0\n"); 
					else  bw.write("1\n");
				}
				else bw.write("0\n");
			}
	
		}
		bw.flush(); 
		bw.close();
	}
}