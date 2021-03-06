import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class source2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int Q = Integer.parseInt(br.readLine().trim());

		Map<Integer, ArrayList<Integer>> groupCountList = new HashMap<Integer, ArrayList<Integer>>();
		int[]  groupList  = new int[N+1];

		for(int q = 0; q < Q; q++ ) {
			
			String[] splits = br.readLine().split(" ");
			boolean isQuestion;
			int p1, p2;
			isQuestion = (Integer.parseInt(splits[0]) ==0 ) ? false : true;
			p1 = Integer.parseInt(splits[1]);
			p2 = Integer.parseInt(splits[2]);

			//질문이 아닌 경우!!
			if(!isQuestion) {
				
				if(p1 == p2 ) {
				} else if(groupList[p1] == 0 && groupList[p2] == 0 ) { // 둘다 그룹이 안정해져있을경우
					ArrayList newList = new ArrayList<Integer>();
					groupList[p1] = p1;	
					groupList[p2] = p1;
					newList.add(p1);
					newList.add(p2);
					groupCountList.put(p1, newList);
				} else if(groupList[p1] != 0 && groupList[p2] == 0) { //이미 p1만이 그룹이 정해져있는 경우
					groupCountList.get(groupList[p1]).add(p2);
					groupList[p2] = groupList[p1];
				} else if(groupList[p1] == 0 && groupList[p2] != 0){ //이미 p2만이 그룹이 정해져있는 경우
					groupCountList.get(groupList[p2]).add(p1);
					groupList[p1] = groupList[p2];
				} else { // 둘다 그룹이 정해져 있는 경우
					int group1Size  = groupCountList.get(groupList[p1]).size();
					int group2Size =  groupCountList.get(groupList[p2]).size();
					int deleteGroupIndex;

					// p1의 그룹이 더 크기가 적은 경우 합병 당하는... 
					if(group1Size <= group2Size) {
						deleteGroupIndex =  groupList[p1];
						for(int i =0; i <  group1Size; i++) {
							// 작은 쪽의 회원들을 가져와서 
							int elem = groupCountList.get(groupList[p1]).get(i);
							// 큰쪽에다 넣어두고
							groupCountList.get(groupList[p2]).add(elem);
							// 그리고 지워진 그룹 번호 대신 새 소속 그룹 번호를 바꿔준다
							groupList[elem] = groupList[p2];
						}
						//group을 제거해야 한다 슬프지만
						groupCountList.remove(deleteGroupIndex);

					}
					// p2의 그룹이 더 크기가 적은 경우 이것 또한 합병 당하는
					else {
						deleteGroupIndex =  groupList[p2];
						for(int i =0; i <  group2Size; i++) {
							// 작은 쪽의 회원들을 가져와서 
							int elem = groupCountList.get(groupList[p2]).get(i);
							// 큰쪽에다 넣어두고
							groupCountList.get(groupList[p1]).add(elem);
							// 그리고 지워진 그룹 번호 대신 새 소속 그룹 번호를 바꿔준다
							groupList[elem] = groupList[p1];
						}
						//group을 제거해야 한다 슬프지만
						groupCountList.remove(deleteGroupIndex);
					}
				}
			} else {
				if(p1 == p2)  bw.write("1\n");
				else if(groupList[p1] == groupList[p2]) bw.write("1\n");
				else bw.write("0\n");
			}
		}
		bw.flush(); // 이 부분이 없으면 출력이 되지 않을 수도 있음
		bw.close();
	}
}
