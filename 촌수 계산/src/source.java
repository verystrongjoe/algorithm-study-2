import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class source {
	
	static List<Integer>[] relations  = new ArrayList[100]; 
	static int[] visited = new int[100];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine().trim());
		String[] splits = br.readLine().split(" ");
		int q1 = Integer.parseInt(splits[0]);
		int q2 = Integer.parseInt(splits[1]);
		int m = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i < m; i++) {
			splits = br.readLine().split(" ");
			int x = Integer.parseInt(splits[0]);
			int y = Integer.parseInt(splits[1]);
			
			if(relations[x] == null ) {
				relations[x] = new ArrayList<Integer>();
			}

			if(relations[y] == null ) {
				relations[y] = new ArrayList<Integer>();
			}

			
			if(!relations[x].contains(y)) relations[x].add(y);
			if(!relations[y].contains(x)) relations[y].add(x);
		}
		
		System.out.println(  bfs(q1,q2)   );
	}

	private static int bfs(int q1, int q2) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
	
		visited[q1] = 1;
		queue.add(q1);
		
		int depth = 1;
		
		while(!queue.isEmpty()) {

			int q = queue.poll();
			visited[q] = 1;
			
			if(relations[q] == null) return -1;

			for(int c : relations[q]) {
				if(visited [c]!=1) {
					if(c == q2) {
						return depth;
					} else {
						queue.add(c);
					}
				}
			}
			depth++;
		}
		
		return -1;
	}

}
