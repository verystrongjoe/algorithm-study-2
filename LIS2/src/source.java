import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/****
 * 
 * 
 * 
 * �ð� ����	�޸� ����
	2.0 ��	512 MB
	����
	N���� �ڿ����� �̷���� ������ ������ �� ���� �� ���� �κ� ������ ����غ���.
	
	�Է�
	ù° �ٿ� ���� N(1 �� N �� 300,000)�� �Էµȴ�.
	
	��° �ٿ� N���� �ڿ����� ���ʴ�� ���´�.
	
	�� �ڿ����� 32��Ʈ ��ȣ �ִ� �������� ���� �־�����.
	
	���
	LIS�� ���̸� ����Ѵ�.
	
	��Ʈ
	�Է� ����
	
	10
	1 1 2 2 3 3 2 2 5 5
	��� ����
	
	4
	
	
	
	�������� �� ����� ����Ʈ�� �ؼ� Ǫ�� ����� �����Ͽ�����
	�Ʒ���ũ����ó��  Segment Tree�ε� ������ Ǯ���� 
	http://manzzup.blogspot.kr/2015/08/explained-finding-longest-increasing.html

 * 
 * 
 * ��ư �������� ������ �����
 * 
 * �켱 � ����Ʈ�� �ִµ� �� ����Ʈ���� �����Ͱ� �ö󰥼��� ��� increasing�ϰ� �����Ͱ� ���̰�
 * ���࿡  1 5 7 8 2 3 �̶�� �༮�� LIS�� ���ϱ� ���ؼ�
 *
 *1 5 7 8 �� ���ٰ� 2�� 5 ��� ���� ��� 5�� �ִ� ������ 5 7 8 �̶�� ���� �����ʹ� ��ũ ������ ��� ����
 * �׸��� 2 ���� 3�� ���� ���̴�. �׷��� 
 * 
 *    �� �� �׷�����
 *        
 *
 */

public class source {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];

		String[] splits = br.readLine().split(" ");
		
		for(int i = 0 ; i < N; i++) {
			sequence[i]= Integer.parseInt(splits[i]);
			
		}
		
		
		
		
	}

}