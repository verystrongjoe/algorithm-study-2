import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class source_r {
	
	public static List woodStickLengthList;
	public static int result;
	public static int stickCount;
	public static int totalLength;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splits = br.readLine().split(" ");

		stickCount = Integer.parseInt(splits[0]);
		totalLength = Integer.parseInt(splits[1]);
		woodStickLengthList = new ArrayList<Integer>();
		
		
		for(int j = 0 ; j < stickCount; j++) {
			woodStickLengthList.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(woodStickLengthList);
		
		partialCalculate(totalLength, stickCount);
		
		System.out.println(result%1000000);
	}
	
	public static void partialCalculate(int remainder,  int position) {

		if(remainder == 0)  {
			result ++; 
		}
		else {

			if(position < 1) return; 
			
			int l = (int)woodStickLengthList.get(position-1);
			int v = remainder / l;
 
			for(int usedCnt = 0 ; usedCnt <=v; usedCnt++) {
				if(usedCnt == 0) partialCalculate(remainder, position-1);
				else partialCalculate(remainder-(l*usedCnt), position-1);
			}
			
		}
		
	}
	
	
}