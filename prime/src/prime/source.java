package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/***
	 * 
	 * 
	 * ����
			� ���� S�� �־�����. ���� S���� �� �� �̻� ���Ҹ� �������� ��, ������ �� Ȥ�� ������ �ִ������� 1�� �Ǵ� ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
			
			�Է�
			ù ��° �ٿ� ������ ũ�� N�� �־�����. (1 �� N �� 100)
			
			�� ��° �ٺ��� N���� �ٿ� ���� ������ �� ���� Si�� �־�����. � �� ���Ұ� ���� �� �ִ�. (1 �� Si �� 100,000)
			
			���
			ù ��° �ٿ� ������ 10,000,003���� ���� �������� ����Ѵ�.
			
			��Ʈ
			�Է� ����
			
			3
			2
			4
			3
			��� ����
			
			3
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 * 
	 * 
	 */
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		int[] S = new int[N];

		for(int i = 0 ; i < N; i++) {
			S[i]=  Integer.parseInt(br.readLine());
			
		}
		
		
		
	}

}
