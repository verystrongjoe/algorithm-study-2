import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {

	/**
	 * http://koitp.org/problem/SDS_PRO_6_2/read/
	 * @throws IOException 
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String magic = br.readLine();	
		String angelBridge = br.readLine();
		String devilBridge = br.readLine();
		
		int[][][] D = new int[magic.length()+1][angelBridge.length()+1][2+1];
		
		for(int i = 1 ; i <= magic.length(); i++) {
			for(int j = 1; j <= angelBridge.length(); j++) {
				for(int k =1; k <=2; k++) {

					if( i == 1) {
						D[1][j][0] +=  ( angelBridge.charAt(j) == magic.charAt(i-1) ) ? 1 : 0;
						D[1][j][1] +=  ( devilBridge.charAt(j) == magic.charAt(i-1) ) ? 1 : 0;
					} 
					
					D[i][j] = D[i-1][j][0] + 
				
					
					
				}
			}
		}
		
		
	}

}
