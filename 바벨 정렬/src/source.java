import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/****
 * 
 * 
 * 해설
 * 
 * 이 문제의 경우 정말 우여곡절이 많았다. 정말 3일동안 내 머리속에서 맴돌았고 삽질 정말 많았던 문제!!
 * 
 * 
 * 
 * 
 * 
 * http://koitp.org/problem/SDS_PRO_4_7/read/
 * 문제
		삼성 SDS 체력단련장에는 각기 다른 무게를 가진 N 개의 역기들이 고정대 위에 놓여있다.
		
		아침에는 체력단련장 이용자들의 편의를 위하여 바벨들을 무게순으로 정렬하여 둔다.
		
		하지만, 체력 단련장이 문을 닫을 때가 되면 , N 개의역기들은 무게 순과는 무관하게 어지럽게 놓여져 있다.
		
		체력단련장 관리자인 동현이는 체력단련장의 문을 닫으면서 어지럽게 놓인 N 개의 역기들을 무게의 오름차순으로 정렬하는 일을 담당하고 있다.
		
		역기의 무게가 만만치 않기 때문에 동현이는 들어 옮기는 역기의무게의 합을 최소로 하여 정렬하고자 한다.
		
		안전을 위하여 동현이는 한 번에 두 개의 역기를 들어 옮기지는 않는다. 옮기는 바벨이 꼭 인접해 있을 필요는 없다.
		
		들어올리는 무게의 합이 최소로 되도록 바벨들을 정렬할 때 , 그 때의 무게 합을 구하는 프로그램을 작성하시오.
		
		시간제한 : 1초
		
		입력
		첫 줄에 역기의 개수 N 이 10,000 이하인 양의 정수로 주어지고 , 다음 줄 부터 역기들의 무게(Wi <= 100,000) 가 주어진다. 역기들의 무게는 서로 다르다.
		
		출력
		오름차순으로 역기들을 정렬하기 위하여 옮겨야 하는 무게의 합의 최소값을 출력한다.
		
		힌트
		입력 예제
		3
		2
		3
		1
		출력 예제
		7
		힌트
		
		2 3 1 : 초기 상태
		2 1 3 : 1과 3의 위치를 바꿈 (4 = 1 + 3)
		1 2 3 : 1과 2의 위치를 바꿈 (3 = 1 + 2)
		
		따라서 들어올리는 무게의 합은 7이며, 이때가 최소이다.
		
		

 * 
 * 
		 * 사이클 순회 문제를 풀기 위해서 아래의 공식이 필요하다.
		 * 
		 * C 사이클 크기 S 사이클 전체 합 Sn 사이클 가장 작은 값 Bn 배열 중 가장 작은 값 이라고 한다면
		 * 사이클을 전부 찾아서 아래의 공식에 위를 참조하여 대입해서 구하면 된다.
		 * 
		 *  사이클당 사이클 해소를 위해서 소모되는 비용
		 *  
		 *  Math.min(   S + Sn*(C-2))      ,      S+Sn+Bn*(C+1)   )
		 *  
		 *  이걸 한글로 풀어서 사용하면
		 *  
		 *  처음 Math.min ()함수의 첫 파라메터는 그냥 사이클을 사이클 안의 있는 엘리먼트들만 사용해서 해결하는 방법
		 *         사이클 전체 합 + 사이클에서 가장 작은 값 * ( 사이클의 크기 - 2) 
		 *  
		 *  두번째파라메터는 이게 위에 엘리먼트들의 weight나 가지는 비용들이 클 경우는 현저하게 비효율적일수 있어서
		 *        사이클의 전체의 합 + 사이클 내 가장 작은 값 +  배열에서 가장 작은 값 * ( 사이클의 크기 + 1)

		 *  1. 사이클 배열 획득
		 *  2. 찾은 사이클들을 이터레이션 돌면서 위의 공식대로 비용 합산
 *
 */
class Node {
	int i,d;
	public Node(int i, int d) {
		this.i = i;
		this.d = d;
	} 
}

class Cycle  {
	List<Node> nodes = new ArrayList<Node>();

	public void addNode(Node n) {
		nodes.add(n);
	}

	public int[] findCycleWithStartIndex(int s) {
		Stack<Integer> stack = new Stack<Integer>();

		int p = s;
		int next = -1;

		while( ! stack.contains(next) && stack.size() < nodes.size() ) {
			if(next != p) {
				if(next != -1) p = next;
				stack.push(p);
			} else {
				break;
			}
			
			if(p >= s && p <= nodes.size()) {
				next = nodes.get(p).d;
			}
			
		}

		if( p == next) return null;
		int[] result = new int[stack.size()];
		int size = stack.size();
		for(int i=0; i<size; i++) {
			result[i] = stack.pop();
		}

		return result;

	}
}


public class source {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> things = new ArrayList<Integer>();
		List<Integer> sorted = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < n; i++)	things.add(Integer.parseInt(br.readLine()));

		sorted.addAll(things);
		Collections.sort(sorted);

		int[] cycle;
		long weightTotal = 0 ;
		int Bn = (int) sorted.get(0);
		int startCycleCheck = 1;
		
		Cycle c = new Cycle();
		
		c.addNode(new Node(0,0));
		for(int i = 0 ; i < n; i++)  {
			c.addNode(new Node(i+1,   sorted.indexOf(things.get(i))  + 1   )  );
		}

		do {
			long S = 0, Sn = Integer.MAX_VALUE, C = 0; 
			cycle = c.findCycleWithStartIndex(startCycleCheck++);

			if(cycle != null) {
					for(Integer i : cycle) {
						int w = (int) things.get(i-1);
						if(Sn > w) Sn = w;
						C++;
						S+=w;
					}
					weightTotal+=Math.min(S + Sn*(C-2)      ,      S+Sn+Bn*(C+1)   );
			}
		} while( startCycleCheck < n);
		System.out.println(weightTotal);
	}

}
