import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/***
	 * 
	 * 
	 *  문제
			고속도로에서 자동차를 타고 Lkm 떨어진 목적지로 이동하려고 한다. 출발지에서 자동차의 기름 탱크에는 기름이 가득 차 있다. 하지만 자동차의 기름 탱크의 크기가 충분히 크지 않기 때문에, 고속도로 가운데의 N개의 휴게소들 중 몇 개에 들러 주유를 해야 한다. 목적지에 다다르기 위한 최소 주유 횟수를 계산하는 프로그램을 작성하시오.
			
			입력
			첫 줄에는 휴게소의 수 N과 기름 탱크의 크기 M, 출발지에서 목적지까지의 거리 L이 주어진다. (1≤N≤1,000, 1≤M<L≤1,000,000,000) 기름 탱크 크기 M은 이 자동차가 주유를 받지 않고 이동할 수 있는 거리가 최대 M km까지임을 의미한다.
			
			그 다음 N개의 줄에는 각각의 휴게소의 위치 정보가 주어진다. 한 줄에는 한 개의 휴게소의 위치를 나타내는 한 개의 수 Xi(0<Xi<L)가 주어진다. 이것은 출발지로부터 Xi km 떨어진 휴게소가 존재함을 의미한다. 휴게소는 위치 순서대로(출발지에서 가까운 것부터 차례대로) 주어진다. 같은 위치에 두 개 이상의 휴게소가 존재하는 경우는 입력으로 주어지지 않는다.
			
			목적지에 도착하는 것이 불가능한 경우는 입력으로 주어지지 않는다.
			
			출력
			목적지까지 도착하기 위한 최소 주유 횟수를 하나의 정수로 출력한다.
			
			힌트
			입력 예제
			5 30 100
			30
			40
			50
			60
			70
			출력 예제
			3
	 * @throws IOException 
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] splits = br.readLine().split(" ");
		int N = Integer.parseInt(splits[0]);
		int M = Integer.parseInt(splits[1]);
		int L = Integer.parseInt(splits[2]);
		
		int gas[] = new int [N];
		
		for(int i=0; i<N; i++) {
			gas[i] = Integer.parseInt(br.readLine());
		}
		
		.
		
		
	}

}
