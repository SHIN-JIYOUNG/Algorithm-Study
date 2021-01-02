package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 틀렸던 점: 배열을 만들어서 값을 하나씩 밀어냄
 * -> 재귀method를 생성하여 계속 반복시키면 됨 
 */
public class Q2609_GCDLCM {

	public static int makeGCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return makeGCD(b, a % b);//재귀함수 호출 
		} // method GCD

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " "); // tokenizer클래스의 nextToken() 메소드를 사용하여 공백 단위로 잘라낼 준비
		int GCD;// 최대공배수
		int LCM;// 최소공배수

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		GCD = makeGCD(a, b); //method 호출 
		LCM = a * b / GCD;

		System.out.println(GCD);
		System.out.println(LCM);

		br.close();
	}

}
