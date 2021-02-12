package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는
 * 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * @author JIYOUNG
 *
 */
public class Q1260_BFSDFS {

	static int node[][]; // 인접행렬 배열
	static int check[]; // 노드의 방문여부 표시 배열
	static Queue<Integer> queue = new LinkedList<Integer>(); // BFS를 위한 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 노드의 개수
		int m = Integer.parseInt(input[1]); // 연결된 간선의 개수
		int v = Integer.parseInt(input[2]); // 탐색 시작 노드

		node = new int[n + 1][n + 1];
		check = new int[n + 1];

		for (int i = 0; i < m; i++) { // 인접행렬로 그래프를 구현
			String[] inputLinked = br.readLine().split(" ");
			int a = Integer.parseInt(inputLinked[0]);
			int b = Integer.parseInt(inputLinked[1]);
			node[a][b] = 1;
			node[b][a] = 1;
		}

		dfs(v);
		Arrays.fill(check, 0); // DFS이후 동일한 방문 여부배열을 사용하기 때문에 다시 0으로 초기화 해준다.
		System.out.println();
		bfs(v);

	}

	static void dfs(int x) { // DFS 메소드 재귀호출 반복한다.
		if (check[x] == 1)
			return; // 이미 방문한 노드라면 종료한다.

		check[x] = 1; // 방문하지 않은 노드라면 방문여부를 표시하고 출력한다.
		System.out.print(x + " ");
		for (int i = 1; i < node.length; i++) { // 인접행렬의 경우 행열이 대각선을 기준으로 대칭이 되므로 행 또는 열을 기준으로만 탐색하면된다.
			if (node[x][i] == 1) { // 현재 탐색하는 노드와 인접한 노드가 연결되어있을 경우 == 값이 1인 경우
				dfs(i); // 해당 노드로 이동
			}
		}
	}

	static void bfs(int x) { // BFS 메소드 큐를 이용해 구현

		queue.offer(x); // 큐에 시작 노드 삽입
		check[x] = 1; // 시작 노드를 방문 표시
		while (!queue.isEmpty()) { // 공백큐가 될 때까지 반복
			x = queue.poll(); // 큐에서 하나 꺼낸다.
			System.out.print(x + " "); // 출력
			for (int i = 1; i < node.length; i++) { // 큐에서 꺼낸 노드와 연결된 노드를 탐색
				if (check[i] != 1 && node[x][i] == 1) { // 큐에서 꺼낸 노드와 연결된 노드가 방문하지 않았던 노드라면
					queue.offer(i); // 큐에 삽입 후
					check[i] = 1; // 방문 표시
				}
			}
		}
	}
}
