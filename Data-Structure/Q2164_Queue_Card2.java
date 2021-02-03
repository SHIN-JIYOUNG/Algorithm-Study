package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * N장의 카드가 있다. 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다. 우선, 제일 위에 있는 카드를
 * 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다. N이 주어졌을 때, 제일 마지막에 남게 되는
 * 카드를 구하는 프로그램을 작성하시오. 첫째 줄에 남게 되는 카드의 번호를 출력한다.
 * 
 * 풀이방법: queue구조를 이용, 선입선출의 특성을 이용하여 1. 버린다 2. 버린다 2. 그 값을 추가 를 반복한다
 * 
 * @author JIYOUNG
 *
 */
public class Q2164_Queue_Card2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>(); 

		for (int i = 1; i <= N; i++) {
			queue.add(i); //1부터 입력받은 값까지 큐에 넣어놓기 
		}

		while (queue.size() > 1) {//큐의 사이즈가 1보다 클때까지 (== 1이 되면 바로 프린트문으로 간다) 
			queue.poll();//버리고 
			queue.add(queue.poll());//버린 값을 더한다 
		}
		
		System.out.println(queue.peek());
	}
}
