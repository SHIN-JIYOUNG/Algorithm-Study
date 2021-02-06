package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오. 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이
 * 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 풀이 방법: 일반 정렬 라이브러리로 정렬 
 * 
 * @author JIYOUNG
 *
 */
public class Q2750_SortingNum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		int[] array = new int[input];

		for (int i = 0; i < input; i++) {
			array[i] = Integer.parseInt(br.readLine()); //입력되는 값 배열에 넣기 
		}

		Arrays.sort(array); //정렬 

		for (int a : array) {
			bw.write(String.valueOf(a)+"\n"); //하나씩 프린트 
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
