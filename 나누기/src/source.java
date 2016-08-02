import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source {

	/***
	 * 
	 * 
	 * 
	 * 
	 * 문제
	 * 
			아래와 같이 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 0으로 칠해져 있거나 1로 칠해져 있다. 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 0 또는 1로 칠해진 색종이를 만들려고 한다.
			
			11000011
			11000011
			00001100
			00001100
			10001111
			01001111
			00111111
			00111111
			전체 종이의 크기가 N×N(N=2^k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙은 다음과 같다.
			
			전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다. 나누어진 종이 I, II, III, IV 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다. 이와 같은 과정을 잘라진 종이가 모두 0 또는 모두 1으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
			
			입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(0 또는 1)이 주어질 때 잘린 조각들 중 0으로 칠해진 색종이의 수와 1로 칠해진 색종이의 개수를 구하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다. 색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
			
			각 숫자 사이에는 빈칸이 하나씩 있다.
			
			출력
			첫째 줄에는 잘라진 색종이들 중 0으로 칠해진 색종이의 수를 출력하고, 두 번째 줄에는 잘린 색종이들 중 1로 칠해진 색종이의 수를 출력하라.
			
			힌트
			예제 입력
			8
			1 1 0 0 0 0 1 1
			1 1 0 0 0 0 1 1
			0 0 0 0 1 1 0 0
			0 0 0 0 1 1 0 0
			1 0 0 0 1 1 1 1 
			0 1 0 0 1 1 1 1
			0 0 1 1 1 1 1 1
			0 0 1 1 1 1 1 1
			예제 출력
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
