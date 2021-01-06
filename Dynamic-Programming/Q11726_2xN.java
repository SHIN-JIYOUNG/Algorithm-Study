package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * bottom-up 방식을 사용
 * 세로는 2, 가로는 input인 사각형을 만들기 위한 경우의 수를 구하는 문제
 * 단, 사각형은 2*1, 1*2 형태 뿐이다.
 * 풀이:
 * 바꾸어 말하면 case 1. 가로의 길이가 1이 늘어나는 경우도 있고, (마지막 사각형에서 2*1을 덧붙인 경우)
 * case 2. 가로의 길이가 2가 늘어나는 경우가 있음 (마지막 사각형에서 1*2를 2개 덧붙여 정사각형인 2*2형태를 만들어 붙인 경우)
 * 즉, 마지막 사각형의 '가로'길이는 input의 길이보다 1만큼 짧거나 2만큼 짧은 사각형의 경우이다.
 * 
 * @author JIYOUNG
 *
 */
public class Q11726_2xN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine()); // 가로 길이를 입력할 변수 

		int row[] = new int[input + 1]; // input 길이에 따라 사각형을 만들 수 있는 경우의 수를 넣어줄 배열 생성
		row[0] = 0; // 가로가 0일 수는 없으니 값으로 0을 넣어줌
		row[1] = 1; // 2x1막대 뿐이므로 1을 넣어줌 
		row[2] = 2; // 2x1막대 2개를 합친 경우, 1x2막대 2개를 합친 경우 뿐이므로 2를 넣어줌
		for (int i = 3; i <= input; i++) { // 3부터 시작, input의 길이만큼 반복
			row[i] = row[i - 1] + row[i - 2]; // i의 경우의 수는 i의 길이가 1만큼 짧거나 2만큼 짧은 직사각형의 경우의 수를 합친 것임
			row[i] = row[i]%10007; //답 검증용 연산 
		}
		System.out.println(row[input]);
		br.close();
		// 편의상 BufferedWriter 생략
	}

}
