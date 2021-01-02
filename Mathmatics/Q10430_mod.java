package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 줄을 읽어들일 때 " "(space)간격으로 잘라낸 후 배열에 넣고 
 * 배열의 index 1, 2, 3 값을 하나씩 불러들여 연산하기
 * 
 * 개선 코드: 배열을 쓰지 않아도 연산 가능
 */
public class Q10430_mod {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();

		StringTokenizer st = new StringTokenizer(input, " "); // tokenizer클래스의 nextToken() 메소드를 사용하여 공백 단위로 잘라낼 준비

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()); // 문제에서 제시한 대로 변수는 대문자를 사용

		bw.write(((A + B) % C) + "\n");
		bw.write(((A % C + B % C) % C) + "\n");
		bw.write(((A * B) % C) + "\n");
		bw.write(((A % C * B % C) % C) + "\n");
		bw.flush();

		br.close();
		bw.close();
	}
}