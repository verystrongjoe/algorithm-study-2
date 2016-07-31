import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class source {
	
	static int n;
	
	static List things = new ArrayList<Integer>();
	static List sorted = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n; i++)  {
			 things.add(Integer.parseInt(br.readLine()));
		}
		
		sorted.addAll(things);
		Collections.sort(sorted);

		/**
		 * 사이클 순회 문제를 풀기 위해서 아래의 공식이 필요하다.
		 * 
		 * C 사이클 크기 S 사이클 전체 합 Sn 사이클 가장 작은 값 Bn 배열 중 가장 작은 값 이라고 한다면
		 * 사이클을 전부 찾아서 아래의 공식에 위를 참조하여 대입해서 구하면 된다.
		 * 
		 *  사이클당 사이클 해소를 위해서 소모되는 비용
		 *  
		 *  Math,min(   S + Sn(C-2))      ,      S+Sn+Bn*(C+1)   )
		 *  
		 *  이걸 한글로 풀어서 사용하면
		 *  
		 *  처음 Math.min ()함수의 첫 파라메터는 그냥 사이클을 사이클 안의 있는 엘리먼트들만 사용해서 해결하는 방법
		 *         사이클 전체 합 + 사이클에서 가장 작은 값 * ( 사이클의 크기 - 2) 
		 *  
		 *  두번째파라메터는 이게 위에 엘리먼트들의 weight나 가지는 비용들이 클 경우는 현저하게 비효율적일수 있어서
		 *        사이클의 전체의 합 + 사이클 내 가장 작은 값 +  배열에서 가장 작은 값 * ( 사이클의 크기 + 1)
		 */
		
		/**
		 *  1. 사이클 배열 획득
		 *  2. 찾은 사이클들을 이터레이션 돌면서 위의 공식대로 비용 합산
		 */
		
		int weightTotal = 0 ;
		int Bn = (int) sorted.get(0);
		int start, end;

		Stack<Integer> indexStack = new Stack<Integer>();
		indexStack.add(0);
		
		start = 0;
		
		for(int i = 0 ;  i <n; i++) {
			
			if(indexStack.contains( sorted.indexOf(  things.get(i) )) ) {
				
				//사이클 발견했시오!!
				int Sn = Integer.MAX_VALUE, S = 0; 
				int C = 0, counter;
		
				end = i;
				
				start = sorted.indexOf(  things.get(i) );
				indexStack.add(i+1);
				
				C = end - start + 1;

				while( end >= start) {
					int w = (int) things.get(end--);
					if(w < Sn) Sn = w;
					S+=w;
				}
				
				weightTotal += Math.min(   S + Sn*(C-2)      ,      S+Sn+Bn*(C+1)   );
//				if(i+1<n ) {	
//					indexStack = new Stack<Integer>();
//					start = i+1;
//					start = sorted.indexOf(  things.get(i) );
//					indexStack.add(i+1);
//				}
				
			} else {
				indexStack.add( sorted.indexOf(  things.get(i)  ));
			}
			
		}
		System.out.println(weightTotal);
	}
	
}
