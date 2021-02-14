package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 입력되는 배열의 수들을 합하여 가장 큰 숫자로 만들어 보자. ex. [6, 10, 2] => 6210
 * 
 * 풀이방법: String[]으로 정렬 후에 제일 끝에 있는 인덱스부터 숫자를 하나씩 더해나간다. 만약 같은 앞자리를 가진 수라면
 * 두 숫자를 더하여 더 큰 결과값이 나오는 대로 더해준다 (주석 참고)
 * 
 * @author JIYOUNG
 *
 */
public class Q00000_Sorting_MaxNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String result = "";
		String numA = "", numB = "";
		int idx = input.length - 1;

		Arrays.sort(input); // 오름차순으로 정렬

		while (idx > 0) {//인덱스가 1일 때까지 반복, 
			if (input[idx].charAt(0) == input[idx - 1].charAt(0)) { //만약 해당 인덱스와 그 이전 숫자의 앞자리가 같다면 
				numA = input[idx] + input[idx - 1]; // 두 숫자를 string형으로 더해본다
				numB = input[idx - 1] + input[idx];

				if (Integer.parseInt(numA) >= Integer.parseInt(numB)) {// 그 두 숫자를 대소비교해서
					// 앞 숫자를 먼저 더한 값이 크다면
					result += input[idx--];// 그 숫자를 먼저 사용
				} else {// 아니라면 그 뒷 숫자를 먼저 사용
					result += input[idx - 1];
					input[idx - 1] = input[idx];
					idx--;
				}
			} else {
				result += input[idx--];
			}
		}
		result += input[idx];//idx 0까지 더해내기

		if (Integer.parseInt(result) == 0) { // 0으로 채워진 배열이라면
			System.out.println("0");// 0만 반환하도록
		} else {
			System.out.println(result);
		}
	}
}
