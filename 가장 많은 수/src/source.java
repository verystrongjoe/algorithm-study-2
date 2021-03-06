import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class source {

	static int max = Integer.MIN_VALUE;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {

//		Scanner sc= new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] list  = new int[N];
//
//		for(int i = 0 ; i < list.length; i++) {
//			list[i]  = sc.nextInt();
//		}

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한 줄에 정수 하나가 주어지는 경우
		int N = Integer.parseInt(br.readLine());

		// 한 줄에 정수 N개가 공백으로 분리되어 주어지는 경우
		int[] list = new int[N];
		for(int i = 0 ; i < list.length; i++) {
			list[i] =  Integer.parseInt(br.readLine());
		}
		
		
//		mergeSort(list);
		Arrays.sort(list);
		
		int max_present = 0;

		for(int i = 1; i < list.length; i++) {
			
			if(list[i] == list[i-1]) {
				max_present++;
			} else {
				max_present = 0;
			}
			
			if(max < max_present) {
				result = list[i];
				max = max_present;
			} 
			
		}
		System.out.println(result);
		
	}

	public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

}
