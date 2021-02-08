package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을
 * 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 * 
 * 풀이 방법: 1~99까지는 자기 자신이 한수가 된다. 왜?: 3자리 수부터 각 자리수의 Interval을 비교 가능하기 때문. 때문에
 * 100 이상 숫자부터 찾아주면 된다.
 * 
 * @author JIYOUNG
 *
 */
public class Q1065_HanSoo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		if ("1000".equals(input)) { // 만약 1000이 입력 됐다면, 1000은 한수가 아니기 때문에 999로 바꿔치기 해준다
			input = "999";
		}

		int inputInt = Integer.parseInt(input); // for문을 돌리기 위해 int로 형변환
		int cnt = 99;// 100 이상 숫자를 세어 나갈때 99를 더하고 시작하기 위해 초기화를 99로 해놓음
		int interval = 0; // 각 자릿수의 차이를 저장할 변수
		String start = "100"; // 100부터 input까지 반복하여 세어나갈 것
		int startInt = 100;
		int a, b, c; // 각 자릿수를 담아놓을 변수

		if (input.length() <= 2) { // 두자리수 이하라면 입력된 숫자 그대로 반환
			bw.write(input);
			bw.flush();
		}

		if (input.length() == 3) { // 세자릿수라면 (1000이 들어와도 999로 바꿔줬기 때문에 해당 if문에 태워진다)
			for (; startInt <= inputInt; startInt++) { // 100부터 시작해서 input을 만날 때까지 한수인지 아닌지 체크
				start = String.valueOf(startInt);
				a = start.charAt(0); // 백의자리
				b = start.charAt(1); // 십의자리
				c = start.charAt(2); // 일의자리
				interval = Math.abs(a - b); // 백의자리와 십의자리의 공차 구하기
				if ((Math.abs(b - c) == interval)) {// 만약 백의자리와 십의자리의 공차가 십의자리와 일의자리의 공차와 같다면
					if (a >= b && b - interval == c) {// 백의자리 수가 십의자리 수보다 같거나 크다면 b-공차=c여야 한다
						cnt++;
					} else if (a < b && b + interval == c) {// 백의자리 수가 십의자리 수보다 작다면 b+공차=c여야 한다
						cnt++;
					}
				}
			}
			bw.write(String.valueOf(cnt));
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
