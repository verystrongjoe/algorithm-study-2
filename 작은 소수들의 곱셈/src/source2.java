import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class source2 {
	
	static final int MAX = 5842+1;
	
//	static int[] D = new int[MAX+1];
	static List<Integer> D = new ArrayList<Integer>();
	static int index;

	public static void main(String[] args) {

		index = 0;
		int inspectNumber = 1;
		D.add(0);
		
		while(index < MAX) {
			if(check(inspectNumber)) {
//				D[++index] = inspectNumber; 
				D.add(inspectNumber);
				index ++;
			}
			inspectNumber++;
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for(int t = 0; t < T; t++) {
			int d = sc.nextInt();
			System.out.println(D.get(d));
		}
	}
	
	private static boolean check(int n) {
		
		if( n == 1) return true;
		int[] div = { 2,3,5,7};
		
	
		if(D.get(index) * 2 >= n ) {
			for(int j = index; j >1; j--) {
				if( n % D.get(j)  == 0 ) {
					n = n / D.get(j); 
					if(D.contains(n)) return true;
				}
			}
		}
		
		for(int i = 0 ; i < div.length; i++ ) {
			while( n % div[i] == 0) n = n / div[i];
			if( n == 1) return true;
		}
		return false;
	}
	
}
