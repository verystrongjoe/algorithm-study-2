import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class source {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int Q = Integer.parseInt(br.readLine().trim());

		Map<Integer, ArrayList<Integer>> groupCountList = new HashMap<Integer, ArrayList<Integer>>();
		int[]  groupList  = new int[N+1];

		loop:
		for(int q = 0; q < Q; q++ ) {
			
			String[] splits = br.readLine().split(" ");
			boolean isQuestion;
			int p1, p2;
			isQuestion = (Integer.parseInt(splits[0]) ==0 ) ? false : true;
			p1 = Integer.parseInt(splits[1]);
			p2 = Integer.parseInt(splits[2]);

			if(!isQuestion) {
				
				if(p1 == p2 ) {
				} else if(groupList[p1] == 0 && groupList[p2] == 0 ) {
					ArrayList newList = new ArrayList<Integer>();
					groupList[p1] = p1;	
					groupList[p2] = p1;
					newList.add(p1);
					newList.add(p2);
					groupCountList.put(p1, newList);
				} else if(groupList[p1] != 0 && groupList[p2] == 0) { 
					groupCountList.get(groupList[p1]).add(p2);
					groupList[p2] = groupList[p1];
				} else if(groupList[p1] == 0 && groupList[p2] != 0){
					groupCountList.get(groupList[p2]).add(p1);
					groupList[p1] = groupList[p2];
				} else { 
					
					if(groupList[p1] == groupList[p2]) continue loop;
					int group1Size  = groupCountList.get(groupList[p1]).size();
					int group2Size =  groupCountList.get(groupList[p2]).size();
					int deleteGroupIndex;

					if(group1Size <= group2Size) {
						deleteGroupIndex =  groupList[p1];
						for(int i =0; i <  group1Size; i++) {
							int elem = groupCountList.get(groupList[p1]).get(i);
							groupCountList.get(groupList[p2]).add(elem);
							groupList[elem] = groupList[p2];
						}
						groupCountList.remove(deleteGroupIndex);

					}
					else {
						deleteGroupIndex =  groupList[p2];
						for(int i =0; i <  group2Size; i++) {
							int elem = groupCountList.get(groupList[p2]).get(i);
							groupCountList.get(groupList[p1]).add(elem);
							groupList[elem] = groupList[p1];
						}
						groupCountList.remove(deleteGroupIndex);
					}
				}
			} else {
				if(p1 == p2)  bw.write("1\n");
				else if(groupList[p1] == groupList[p2]) bw.write("1\n");
				else bw.write("0\n");
			}
		}
		bw.flush(); 
		bw.close();
	}
}
