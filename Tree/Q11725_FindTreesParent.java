package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * 
 * 풀이 방법: 배열을 이용하여 해당 인덱스의 값으로 그 인덱스의 부모의 값을 넣어주는 방법?을 생각해 보았음
 * 
 * @author JIYOUNG
 *
 */
public class Q11725_FindTreesParent {

	static int[][] map;// 연결된 노드를 표시해놓을 이차원배열
	static boolean[] check;// 방문 여부를 체크할 배열
	static int[] child;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());// 노드의 갯수

		map = new int[n + 1][n + 1];
		check = new boolean[n + 1];
		child = new int[n + 1];

		for (int i = 0; i < n - 1; i++) { // 인접행렬로 그래프를 구현, n-1은 간선의 갯수
			String[] inputLinked = br.readLine().split(" ");
			int a = Integer.parseInt(inputLinked[0]);
			int b = Integer.parseInt(inputLinked[1]);
			map[a][b] = 1;
			map[b][a] = 1;
		}

		DFS(1);

		for (int i = 2; i < child.length; i++) {
			System.out.println(child[i]);
		}
	}

	static public void DFS(int node) {// 감염된 컴퓨터를 깊이우선탐색으로 찾아나가기
		if (check[node] == true) {
			return;// 이미 방문한 노드라면 종료한다
		} else {
			check[node] = true; // 첫 방문이면 true를 채워주고
			for (int i = 1; i < map.length; i++) {
				if (map[node][i] == 1 && !(check[i])) {// 패러미터로 들어온 노드와 연결된 노드를 찾았다면
					child[i] = node;
					DFS(i);// 해당 노드를 시작점으로 다시 깊이 탐색
				}
			}
		}
	}
}
