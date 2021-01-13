package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다. 이 세 수는 서로 다른 범위를 가진다.
 * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19) 1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.
 * E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때, 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 E S M으로 표시되는 가장 빠른 연도를 출력한다. 1 1 1은 항상 1이기 때문에, 정답이 음수가 나오는 경우는 없다.
 * 
 * 풀이: 각 1, 1, 1년에서 시작하여 1년씩 더해가며 풀이한다. e가 16이 되는 순간 1로 초기화해주고, s는 29, m은 20이 되는 순간 초기화한다.
 * 계속 1년씩 더하여 가다가 처음에 문제로 입력한 연수에 도달하면 year를 반환한다.
 * 
 * @author JIYOUNG
 *
 */
public class Q1476_DateCalculation {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //입력 받고, 공백 기준으로 나눠주기 

		int E, S, M; //입력 받을 년도수 
		int e, s, m; //1, 1, 1부터 올라갈 것 
		int year;//1년부터 세어줄 것 

		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		e = 1;
		s = 1;
		m = 1;
		year = 1;

		while (true) {
			if (E == e && S == s && M == m) { //만약 입력받은 값과 1씩 더하여간 값이 일치하는 순간 
				break;//반복문 나가며 year 반환 
			}

			e++;
			s++;
			m++;
			
			if (e == 16) { //초기화 
				e = 1;
			}
			if (s == 29) {
				s = 1;
			}
			if (m == 20) {
				m = 1;
			}
			year++;

		}
		bw.write(String.valueOf(year));
		bw.flush();

		br.close();
		bw.close();
	}
}