package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 다. 전화번호부에 적힌 전화번호를 담은 배열
 * phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지
 * 않으면 true를 return 하도록 한다.
 * 
 * 풀이방법: startsWith 메소드 사용, 우선 입력받은 배열을 정렬한 후에 (빨리 찾을 수 있도록) 인덱스를 하나씩 옆으로 밀며 찾아나간다.
 * 접두사를 배열의 뒷쪽에 취하고 있는 배열이 입력될 수도 있으므로 거꾸로도 훑어준다 
 *
 * @author JIYOUNG
 */
public class Q00000_TeleNumBook {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean answer = true;

		String[] input = br.readLine().split(" ");
		Arrays.sort(input); //빨리 찾을 수 있도록 = 비슷한 문자열들 끼리 모이도록 쏘팅을 해준다 

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[j].startsWith(input[i])) {
					answer = false;
					System.out.println(answer);
					return;
				}
			}
		}

		if (answer == true) {
			for (int i = input.length - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (input[i].startsWith(input[j])) {
						answer = false;
						System.out.println(answer);
						return;
					}
				}
			}
		}
		
	}
}
