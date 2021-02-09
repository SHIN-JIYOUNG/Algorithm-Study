package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
 * 
 * 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
 * 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다. 오른쪽으로 한 칸
 * 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
 * 
 * 큐에 처음에 포함되어 있던 수 N이 주어진다. 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는
 * 프로그램을 작성하시오.
 * 
 * 풀이 방법: 큐를 구현한 후 1번 연산이 올 때까지 움직여준다, 그리고 그 다음 값의 인덱스를 찾은 후 그 인덱스가 큐의 크기의 반보다
 * 작다면 오른쪽으로, 크다면 왼쪽으로 움직이게끔 하면 된다 == 최솟값을 구현하는 방식
 * 
 * @author JIYOUNG
 *
 */
public class Q1021_RoundingQue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> list = new LinkedList<Integer>();

		String[] testcase = br.readLine().split(" ");
		int N = Integer.parseInt(testcase[0]); // 큐의 사이즈
		int M = Integer.parseInt(testcase[1]); // 뺄 숫자의 개수

		String[] inputNumString = br.readLine().split(" ");
		int[] inputNum = new int[M];
		for (int i = 0; i < M; i++) {
			inputNum[i] = Integer.parseInt(inputNumString[i]); // 찾아야 할 숫자들을 임의로 배열에 넣어놓는다
		}

		int trial = 0; // 찾아야 할 숫자를 찾는 시도를 담은 변수
		int cnt = 0; // 2, 3번 식 연산 횟수를 담은 변수

		for (int i = 1; i <= N; i++) {
			list.add(i); // 1~N까지 배열에 넣어놓기
		}

		while (trial < M) {
			if (list.get(0) == inputNum[trial]) { // 만약 리스트의 맨 앞의 숫자와 내가 꺼낼 숫자가 같다면
				list.remove(0);// 즉시 삭제
			} else if (list.indexOf(inputNum[trial]) <= (list.size() / 2)) { // 만약 내가 꺼낼 숫자의 인덱스가 리스트의 사이즈의 반절보다 작거나 같다면
				// 리스트를 왼쪽으로 밀어줘야함
				while (list.get(0) != inputNum[trial]) { // 리스트 맨 앞 숫자가 꺼내려는 숫자가 될 때까지
					list.add(list.size(), list.get(0)); // 맨 뒤에 맨 앞 숫자를 우선 붙여놓은 후에
					list.remove(0);// 맨 앞 숫자 지우기
					cnt++;
				}
				list.remove(0);// 리스트 맨 앞 숫자를 지워내기
			} else if (list.indexOf(inputNum[trial]) > list.size() / 2) {// 만약 내가 꺼낼 숫자의 인덱스가 리스트의 사이즈의 반절보다 크다면
				// 리스트를 오른쪽으로 밀어줘야함
				while (list.get(0) != inputNum[trial]) {// 리스트 맨 앞 숫자가 꺼내려는 숫자가 될 때까지
					list.add(0, list.get(list.size() - 1)); // 맨 앞에 맨 뒤 숫자를 우선 붙여놓은 후에
					list.remove(list.size() - 1);// 맨 뒤 숫자 지우기
					cnt++;
				}
				list.remove(0);// 리스트 맨 앞 숫자를 지워내기
			}
			trial++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}
