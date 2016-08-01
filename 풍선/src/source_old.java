import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * ����
		ū �濡 N���� ǳ���� ���ִ�. ǳ������ ���ʺ��� �����ʱ��� �Ϸķ� �ִ�. �����̴� ȭ�� ������ ��� �Ͱ� ��� �����ϴ� ���� �����Ѵ�. �����̴� ȭ���� ���ʿ��� ���������� ���.
		
		���̴� ���Ƿ� �����Ѵ�. ȭ���� ���õ� ���� H���� ǳ���� ����ĥ ������ ���ʿ��� ���������� �̵��Ѵ�. ȭ���� ǳ���� ����ġ�� ����, ǳ���� ������ �������. ȭ���� ����ؼ� �������� ���µ� ���̴� 1 �پ���. �׷��Ƿ� ���� ȭ���� ���� H���� �̵� ���̾��ٸ� ǳ���� ��Ʈ�� �Ŀ��� ���̰� H-1�� �ȴ�.
		
		�츮�� ��ǥ�� ��� ǳ���� ��Ʈ���� �������� ���� ȭ���� ����ϴ� ���̴�.
		
		�Է�
		ù ��° �ٿ��� ���� N(1 �� N �� 1 000 000)�� ���´�.
		
		�� ��° �ٿ��� �迭 Hi�� N�� ���´�.
		
		������ Hi(1 �� Hi �� 1 000 000)�� i��° ǳ���� ���̿� �ش��ϸ� ���ʿ��� ���������� �����Ǵ� �����̴�.
		
		���
		ù��° �� ���ٿ� �ּ��� �ʿ��� ȭ���� ������ ����Ѵ�.
		
		��Ʈ
		���� �Է� 1
		
		5
		2 1 5 4 3
		���� ��� 1
		
		2
		���� �Է� 2
		
		5
		1 2 3 4 5
		���� ��� 2
		
		5
		���� �Է� 1
		
		5
		4 5 2 1 4
		���� ��� 3
		
		3
 * 
 */
public class source_old {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] splits = br.readLine().split(" ");
		int[] balloons = new int[N];
		int[] poppedBalloon = new int[N];
		int poppedCnt = 0;
		int target = 0, height = -1, arrowCnt = 0;

		for(int i = 0 ; i < N; i++) balloons[i] = Integer.parseInt(splits[i]);
		
		while(poppedCnt != N) {
			
			arrowCnt++; 			/// ȭ�� ���!
			
			// Arrow�� ó�� ǳ���� ���ߴ� �� ����
			for(int i =target; i<N; i++) {
				if(poppedBalloon[i] == 0) {
					poppedBalloon[i] = 1;
					height = balloons[i]-1;
					target = i+1;
					poppedCnt++;
					break;
				}
			}
			
			// ó�� ���� ���� ���� ǳ�� �����°� ���
			for(int i =target; i<N && height > 0; i++) {
				if(poppedBalloon[i] == 0 && balloons[i] == height) {
					height--;
					poppedBalloon[i] = 1;
					poppedCnt++;
				}
			}
		}
		System.out.println(arrowCnt);
	}
}