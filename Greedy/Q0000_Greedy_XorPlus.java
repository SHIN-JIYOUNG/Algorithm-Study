package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 S가 주어졌을 시, 숫자 사이에 x 또는 + 연산자를 넣어 가장 큰 수를 하라, 단 모든 연산은 왼쪽부터 오른쪽으로 순서대로 이루어진다.
 * 
 * 풀이방법: 그리디 알고리즘 이용, 각 숫자의 더하기값/곱하기값을 대소비교하여 result에 얹어나간다 
 * @author JIYOUNG
 *
 */
public class Q00000_Greedy_XorPlus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");//입력된 숫자를 모두 나눠서 배열에 입력
		int[] arr = new int[input.length];//위 배열을 Integer형으로 변환하기 위한 배열 

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}//배열에 모두 넣어줌 

		int idx = 0;
		int result = 0;

		if (arr[idx] + arr[idx + 1] > arr[idx] * arr[idx + 1]) { //만약 첫번째 숫자와 두번째 숫자가 더해진 값이 곱해진 값보다 크다면 
			result = arr[idx] + arr[idx + 1];//result 로 더한값을 넣어줌 
		} else {//반대라면 
			result = arr[idx] * arr[idx + 1];//곱한값을 넣어줌 
		}
		
		idx = 2;//첫번째, 두번째 값은 다 사용했으니 idx를 2로 갱신 
		while (idx != arr.length) {//모든 인덱스의 값을 사용할 때까지 반복 
			if (result + arr[idx] > result * arr[idx]) { //위와 동일한 논리 
				result +=  arr[idx];
			} else {
				result *= arr[idx];
			}
			idx++;
		}
		
		System.out.println(result);

	}
}