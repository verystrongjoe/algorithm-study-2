package �߾Ӱ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ؼ�
 * http://stackoverflow.com/questions/15319561/how-to-implement-a-median-heap
 * 
 * 
 * 
 * @author SDS
 *
 */
public class source {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int Q = Integer.parseInt(br.readLine().trim());

		Map<Integer, ArrayList<Integer>> groupCountList = new HashMap<Integer, ArrayList<Integer>>();
		int[]  groupList  = new int[N+1];
	}

}
