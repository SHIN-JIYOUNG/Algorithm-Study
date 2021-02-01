package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * T자형 스택에 무작위로 값이 입력되고, 이를 순차적으로 왼쪽으로 빼낼 수 있어야 한다. 만약 순차적으로 빼내지 못한다면 Sad, 가능하다면
 * Nice를 출력한다.
 * 첫 줄에는 번호표의 마지막 숫자를 입력, 두번째 줄에는 현재 정렬되기 전 줄의 순서를 입력 (공백으로 구분)
 * https://www.acmicpc.net/problem/12789
 * 
 * 풀이 방법: 우선 1을 만날 때까지 스택에 넣는다. 스택에 넣을 때, 위의 숫자가 아래에 있는 숫자보다 크면 Sad를 반환하도록 한다.
 * 
 * @author JIYOUNG
 *
 */
public class Q12789_Stack_SnackDreamee {

	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int maxNum = Integer.parseInt(br.readLine()); // 번호표의 최대 숫자
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		int[] line = new int[maxNum]; //우선 정렬되지 않고 서있는 그대로 배열에 넣어준다 
		Stack<Integer> stack = new Stack<Integer>(); // 순서대로 들어갈 수 있는지 검증해줄 stack 선언 

		int cnt = 1;//1을 만날 때까지 pop하기 위해 선언한 cnt

		for (int i = 0; i < maxNum; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		} // 처음 줄 선 순서를 나타내는 line[]에 값 넣기

		for (int i = 0; i < maxNum; i++) {
			stack.push(line[i]); //우선 처음 줄 선 순서대로 push 
			if (line[i] == cnt) {//만약 넣으려 하는 값이 cnt와 같다면 
				cnt++;//우선 목표값인 cnt++ 
				stack.pop();//그 값을 pop한다. 
				while(!(stack.isEmpty())&&stack.peek()==cnt) { //pop 한 후에도 stack에 목표값이 남아있을 수 있기 때문에 
					stack.pop();//목표값을 만나면 pop 
					cnt++;
				}
			}
		}
		////넣으면서 목표값을 만난 것들은 다 pop이 되었지만, 만나지 못한 것들은 stack에 남아있을 것
		//stack에 남아있는 것들을 하나씩 꺼내보는데, 만약 위에 쌓인 요소가 아래에 쌓인 요소보다 크면 그것은 Sad를 뱉어내야 한다 
		for (int i = stack.size(); i > 0; i--) {
			if (stack.elementAt(stack.size() - 1) < stack.elementAt(stack.size() - 2)) { //위가 아래보다 작으면 정상 
				stack.pop();//pop 
				if (stack.size() == 1) { //stack에 요소가 1개밖에 안남았을때는 어짜피 잘 짜여진 프로그램이기 때문에 
					stack.pop();//값을 꺼낸 후 
					break;//반복문 탈출 
				}
			} else { //위가 아래보다 작지 않으면 
				System.out.println("Sad");
				break;//반복문 탈출 
			}
		}
		if (stack.empty()) {//스택을 정상적으로 다 비워냈다면 옳은 순열 
			System.out.println("Nice");
		}
	}
}
