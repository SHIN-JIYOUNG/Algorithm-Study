package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의
 * 최솟값을 구하는 프로그램을 작성하시오.
 * 
 * 풀이 방법: 대기시간을 오름차순으로 정렬 후, 맨 마지막 사람을 제외해가며 누적합을 해 나간다 
 * 
 * @author JIYOUNG
 *
 */
public class Q11399_ATM {

	static public int sumArr(int[] arr) {// 배열에 있는 모든 요소를 더해주는 method
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());// 사람 수
		String[] input = br.readLine().split(" ");// 입력되는 대기 시간을 배열로 생성

		int[] people = new int[n];// String형으로 입력된 배열을 int로 형변환하여줄 people[] 생성
		int idx = 0;
		int result = 0;

		for (String min : input) {
			people[idx++] = Integer.parseInt(min); // String형으로 입력된 배열을 int로 형변환하여 people[]에 넣어줌
		}

		Arrays.sort(people); // 대기 시간이 적은 순서대로 정렬

		for (int i = n - 1; i >= 0; i--) { // 대기 시간이 긴 사람부터 한명씩 빼내며 배열의 모든 값을 더하여 나갈 것
			result += sumArr(people);
			people[i] = 0;// 마지막 값을 0으로 바꿔줘서 연산에 방해받지 않도록 빼준다
		}
		System.out.println(result);
		
		
//		수열로 누적합 구하는 방식도 있음!
//        for(int i=1; i<N; i++) {
//        arrSum[i] = arrSum[i-1] + arr[i];
//        sum += arrSum[i];
//	    	}
	}
}
