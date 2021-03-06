import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class source {
	
	static final int N = 5842;
	static int[] D = new int[N]; 
	
	static Queue<Integer> queue2 = new LinkedList<Integer>(); 
	static Queue<Integer> queue3 = new LinkedList<Integer>(); 
	static Queue<Integer> queue5 = new LinkedList<Integer>(); 
	static Queue<Integer> queue7 = new LinkedList<Integer>(); 
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		queue2.add(1);
		queue3.add(1);
		queue5.add(1);
		queue7.add(1);

		int i = 0;
		int v2,v3,v5,v7;
		
		
		D[0] = 1;

		v2 = queue2.peek() * 2;
		v3 = queue3.peek() * 3;
		v5 = queue5.peek() * 5;
		v7 = queue7.peek() * 7;

		do {
			
			switch(min(v2,v3,v5,v7)) {
			case 0 :
				D[++i] = queue2.poll() * 2;
				break;
			case 1 : 
				D[++i] = queue3.poll() * 3;
				break;
			case 2 : 
				D[++i] = queue3.poll() * 5;
				break;
			case 3 : 
				D[++i] = queue3.poll() * 7;
				break;
			default: 
				throw new Exception("no case"); 
			}
			
			queue2.add(D[i]);
			queue3.add(D[i]);
			queue5.add(D[i]);
			queue7.add(D[i]);
			
		} while(i < N);
		
	}
	
	public static int min(int v1, int v2, int v3, int v4) {
		
		int[] v = {v1,v2,v3,v4};
		
		Arrays.sort(v);
		
		if(v[0] == v1) return 0;
		else if(v[0] == v2) return 1;
		else if(v[0] == v3) return 2;
		else if(v[0] == v4) return 3;
		else return -1;
	}
	
	
}
