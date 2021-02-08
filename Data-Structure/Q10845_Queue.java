package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 큐를 구현하는 프로그램 만들기
 * 
 * 풀이법: frontIndex, backIndex 를모두 배열의 최대값을 주고, 값이 들어오면 하나씩 줄여나간다.
 * 
 * @author JIYOUNG
 *
 */
public class Q10845_Queue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// 주어진 명령의 개수. 모두 push 로 가정할 경우 큐의 최대값이기도 함
		int[] queue = new int[N + 1]; // 큐 배열
		int frontIndex = N; // 큐의 앞쪽 인덱스 (값이 들어있는 실제 위치)
		int backIndex = N; // 큐의 뒷쪽 인덱스 (값이 들어있는 실제 위치보다 하나 작은 인덱스)
		String command; // 입력받은 명령어
		int var; // 명령어가 push 일 때 인자 값
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			System.out.println(Arrays.toString(queue));
			
			switch (command) {
			
			case "push":// push X: 정수 X를 큐에 넣는 연산이다.
				var = Integer.parseInt(st.nextToken());
				queue[backIndex] = var;
				backIndex--;
				break;
				
			case "pop": // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (frontIndex == backIndex) {
					System.out.println(-1); // 큐에 정수가 없는 경우 -1 출력
				} else {
					System.out.println(queue[frontIndex]);
					frontIndex--;
				}
				break;
				
			case "size":
				// size: 큐에 들어있는 정수의 개수를 출력한다.
				System.out.println(frontIndex - backIndex);
				break;
				
			case "empty": // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
				if (frontIndex == backIndex) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
				
			case "front": // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (frontIndex == backIndex) {
					System.out.println(-1); // 큐에 정수가 없는 경우 -1 출력
				} else {
					System.out.println(queue[frontIndex]); // frontIndex 는 값이 들어있는 실제 위치를 가리킴
				}
				break;
				
			case "back": // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (frontIndex == backIndex) {
					System.out.println(-1);// 큐에 정수가 없는 경우 -1 출력
				} else {
					System.out.println(queue[backIndex + 1]);// backIndex 는 값이 들어있는 실제 위치보다 하나 작은 인덱스를 가리킴
				}
				break;
				
			default:
				break;
			}
		}
	}
}
