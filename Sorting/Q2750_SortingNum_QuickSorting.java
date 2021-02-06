package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오. 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이
 * 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 풀이 방법: 퀵 정렬 사용해보기
 * 
 * @author JIYOUNG
 *
 */
public class Q2750_SortingNum_QuickSorting {

	static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2]; // 중간 피봇을 구하기
		while (start <= end) { // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같을 때까지
			while (array[start] < pivot) // 왼쪽 값들이 중간값보다 커지기 전까지
				start++;
			while (array[end] > pivot) // 오른쪽 값들이 중간값보다 작아지기 전까지
				end--;
			if (start <= end) {// 왼쪽 포인터가 오른쪽 포인터보다 작거나 같다면
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp; // 값 바꿔치기
				start++;
				end--;
			}
		}
		return start;
	}

	static int[] quickSort(int[] array, int start, int end) {
		int p = partition(array, start, end); //중간 값 구해놓기 
		if (start < p - 1)//왼쪽 포인터가 중간지점보다 작다면 
			quickSort(array, start, p - 1); //해당 메소드로 재귀, end지점에 p-1넣기 
		if (p < end)//중간값이 오른쪽 포인터보다 작다면 
			quickSort(array, p, end); // 중간값을 start로 놓기 
		return array;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		int[] array = new int[input];

		for (int i = 0; i < input; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		array = quickSort(array, 0, array.length - 1);

		for (int a : array) {
			bw.write(String.valueOf(a) + "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
