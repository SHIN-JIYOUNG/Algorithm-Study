package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * 무작위로 입력되는 괄호의 짝이 맞으면 Yes, 아니면 No를 출력한다 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가
 * 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
 * 
 * 풀이방법: 스택에 왼쪽 괄호를 하나씩 넣고 오른쪽 괄호를 만날 때마다 왼쪽 괄호 하나씩 빼내기. 오른쪽 괄호가 끝났을 시 스택이 비어있으면
 * Yes, 남아있으면 No
 * 
 * @author JIYOUNG
 *
 */
public class Q9012_Stack_Bracket {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 입력 받기
		int testcase = Integer.parseInt(br.readLine()); // test할 경우의 수
		Stack<Integer> stack = new Stack<Integer>(); // stack 생성

		while (testcase > 0) {
			String input = br.readLine();
			String[] split=input.split(""); // 입력된 괄호를 하나씩 뜯어주기
			
			for(int i=0; i<split.length; i++) {
				if ("(".equals(split[i])) { // 입력값이 좌측 괄호라면
					stack.push(1); // 괄호에 임의의 숫자를 넣고 (=왼쪽 괄호 대신 1로 갈음)
				}
				if (")".equals(split[i])) { // 입력값이 우측 괄호라면
					if (stack.isEmpty()) { // 만약 스택이 비어있다면
						stack.push(2); // 임의의 숫자 2를 넣기 (스택을 채워놓아 No를 뱉기 위해)
						break; //나가기 
					}
					stack.pop(); // 담겨있던 좌측 괄호 꺼내서 없애버리기
				}
			}
			if (!stack.isEmpty()) { // stack이 비어있지 않다 = 짝이 안맞는다
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			stack.clear(); // 연산 끝났으면 스택 비우고 다시 시작
			testcase--;
		}
	}
}