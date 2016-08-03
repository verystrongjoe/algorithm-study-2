import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  KMP �˰����� 
 *  http://blog.naver.com/choyi0521?Redirect=Log&logNo=80206821567
 *   
 *  ���ڿ� ���� �˻��� ������ �˰�����
 */
class source {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
	
		String context = br.readLine();
		String pattern = br.readLine();

		/**
		 * P�� Prefix/Postfix�� �ظ��� ���� ���� ��ư ��ȭ�� �Լ��̴�. �� �˰������� ����� �������α׷����̶�� �˾Ƶ���
		 * P[i]�� 1~i������ ���ڿ��� ���� 1~i�� ���ڿ�(��ü�� prefix = postfix�� ���� �ǹǷ� �ǹ� ���) ������ prefix�� postfix�� ���� �ִ� ���ڿ��� ���̶�� ����!!
		 */ 
		int[] P = new int[pattern.length()];
		P[0] = -1;
		int now = 0;

		for(int i = 1 ; i < pattern.length(); i++) {
			if(  pattern.charAt(now) == pattern.charAt(i) ) {
				P[i] = now ;
				now++;
			} else if(now == -1) {
				P[i] = -1;
			}else {
				now = P[now];
			}
		}

		/**
		 * P[i]�� ���ϰ� �Ǹ� �̸� ������ ���� context��  iterate�ϸ鼭 ��� ��ĵ�� �Ѵ�. 
		 * �׷��� ������ P[i]�� �̿��Ͽ� ���
		 * ������ ã�� ��  ������ sum up �ϸ鼭 �� ã�� Ƚ���� ã�� �� �ִ�.
		 * 
		 */
		int p= 0;
		int i = 0;
		int result=0;
		List<Integer>startIndexList = new ArrayList<Integer>();

		while( ( i =i+p ) < context.length()  ) {
			if(pattern.charAt(p) == context.charAt(i)) {
				if(p == pattern.length()-1) {
					p = -1;
					result ++;
					startIndexList.add(i);
				}
				p++;
			} else {
				p = P[p];
				i++;
			}
		}
		
		System.out.println(result);
	}
}