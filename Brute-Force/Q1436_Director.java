package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 숫자는 666이고, 그 다음으로 큰 수는
 * 1666, 2666, 3666, .... 과 같다. 숌은 첫 번째 영화의 제목은 세상의 종말 666, 두 번째 영화의 제목은 세상의 종말
 * 1666 이렇게 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자) 와 같다. 숌이
 * 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지
 * 않는다.
 * 
 * 첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
 * 
 * 풀이: 666에서 시작해서 num++
 * 
 * @author JIYOUNG
 *
 */
public class Q1436_Director {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());
		int num = 665; // 666이 1번째 수니까 665에서 시작

		while (input > 0) {
			num++;// 숫자는 계속 증가

			String numToStr = String.valueOf(num);
			if (numToStr.contains("666")) { // 해당 숫자에 666이 들어있다면
				input--;// 입력된 input 변수를 감소시키기
			}
		}

		bw.write(String.valueOf(num));
		bw.flush();

		bw.close();
		br.close();

	}

}
