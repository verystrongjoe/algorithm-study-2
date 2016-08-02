import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/***
	 * 
	 * 
	 * 
	 * 
	 * ����
	 * 
			�Ʒ��� ���� �������� ���簢��ĭ��� �̷���� ���簢�� ����� ���̰� �־��� �ְ�, �� ���簢������ 0���� ĥ���� �ְų� 1�� ĥ���� �ִ�. �־��� ���̸� ������ ��Ģ�� ���� �߶� �پ��� ũ�⸦ ���� ���簢�� ����� 0 �Ǵ� 1�� ĥ���� �����̸� ������� �Ѵ�.
			
			11000011
			11000011
			00001100
			00001100
			10001111
			01001111
			00111111
			00111111
			��ü ������ ũ�Ⱑ N��N(N=2^k, k�� 1 �̻� 7 ������ �ڿ���) �̶�� ���̸� �ڸ��� ��Ģ�� ������ ����.
			
			��ü ���̰� ��� ���� ������ ĥ���� ���� ������ ���ο� ���η� �߰� �κ��� �߶� �Ȱ��� ũ���� �� ���� N/2 �� N/2�����̷� ������. �������� ���� I, II, III, IV ������ ���ؼ��� �տ����� ���������� ��� ���� ������ ĥ���� ���� ������ ���� ������� �Ȱ��� ũ���� �� ���� �����̷� ������. �̿� ���� ������ �߶��� ���̰� ��� 0 �Ǵ� ��� 1���� ĥ���� �ְų�, �ϳ��� ���簢�� ĭ�� �Ǿ� �� �̻� �ڸ� �� ���� ������ �ݺ��Ѵ�.
			
			�Է����� �־��� ������ �� ���� ���� N�� �� ���簢��ĭ�� ��(0 �Ǵ� 1)�� �־��� �� �߸� ������ �� 0���� ĥ���� �������� ���� 1�� ĥ���� �������� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
			
			�Է�
			ù° �ٿ��� ��ü ������ �� ���� ���� N�� �־��� �ִ�. N�� 2, 4, 8, 16, 32, 64, 128 �� �ϳ��̴�. �������� �� �������� ���簢��ĭ���� ���� ���ٺ��� ���ʷ� ��° �ٺ��� ������ �ٱ��� �־�����.
			
			�� ���� ���̿��� ��ĭ�� �ϳ��� �ִ�.
			
			���
			ù° �ٿ��� �߶��� �����̵� �� 0���� ĥ���� �������� ���� ����ϰ�, �� ��° �ٿ��� �߸� �����̵� �� 1�� ĥ���� �������� ���� ����϶�.
			
			��Ʈ
			���� �Է�
			8
			1 1 0 0 0 0 1 1
			1 1 0 0 0 0 1 1
			0 0 0 0 1 1 0 0
			0 0 0 0 1 1 0 0
			1 0 0 0 1 1 1 1 
			0 1 0 0 1 1 1 1
			0 0 1 1 1 1 1 1
			0 0 1 1 1 1 1 1
			���� ���
			9
			7
	 * 
	 * 
	 * 
	 */
	static int[][] matrix;
	static int count0  = 0;
	static int count1 = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		matrix = new int[N][N];

		for(int i = 0 ; i < N; i++)  {
			String[] splits = br.readLine().split(" ");
			for(int j = 0 ; j < N; j++)  {
				matrix[i][j] = Integer.parseInt(splits[j]);
			}
		}
		
		f(0,0,N);
		System.out.println(count0);
		System.out.println(count1);
	}
	
	public static void f(int x, int y, int size) {
		
		int sum = 0;
		for(int i = x; i < x +size; i++) {
			for(int j = y; j < y + size; j++) {
				sum+=matrix[i][j];
			}
		}
		if( sum==size*size ) count1++;
		else if( sum ==0 ) count0++;
		else  {
			int half = size/2;
			f(x, y, half);
			f(x+half, y, half);
			f(x, y+half, half);
			f(x+half, y+half, half);
		}
		
	}

}
