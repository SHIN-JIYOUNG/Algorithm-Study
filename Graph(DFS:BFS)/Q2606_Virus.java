package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다. 컴퓨터의 수와
 * 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을
 * 작성하시오.
 * 
 * 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터
 * 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 * 
 * 풀이방법: 깊이우선탐색을 이용하여, 모든 컴퓨터 중에서 감염된 컴퓨터의 갯수를 빼어 살아남은 컴퓨터의 갯수만 출력한다 
 * 
 * @author JIYOUNG
 *
 */
public class Q2606_Virus {

	static int[][] map;//연결된 노드를 표시해놓을 이차원배열 
	static boolean[] check;//방문 여부를 체크할 배열 
	static ArrayList<Integer> coms = new ArrayList<Integer>();//컴퓨터가 1번부터 n번까지 늘어설 배열 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());// 컴퓨터의 수
		int pair = Integer.parseInt(br.readLine());// 연결된 간선의 갯수

		for (int i = 1; i <= n; i++) {
			coms.add(i);
		}

		map = new int[n + 1][n + 1];
		check = new boolean[n + 1];
		
		for (int i = 0; i < pair; i++) { // 인접행렬로 그래프를 구현
			String[] inputLinked = br.readLine().split(" ");
			int a = Integer.parseInt(inputLinked[0]);
			int b = Integer.parseInt(inputLinked[1]);
			map[a][b] = 1;
			map[b][a] = 1;
		}

		DFS(1); // DFS로 감염된 컴퓨터의 갯수 찾기, 1번부터 시작 
		//감염된 컴퓨터 갯수: 전체 컴퓨터-컴퓨터중에 살아남은 컴퓨터-1번컴퓨터
		System.out.println(n-coms.size()-1);//1번 외 감염된 컴퓨터를 찾는 것이니, 1번 자기 자신도 빼내야 하기 때문에 -1
	}

	static public void DFS(int node) {//감염된 컴퓨터를 깊이우선탐색으로 찾아나가기 
		if (check[node] == true) {
			return;// 이미 방문한 노드라면 종료한다
		} else {
			check[node] = true; //첫 방문이면 true를 채워주고 
			coms.remove(coms.indexOf(node));//coms배열에서 감염된 컴퓨터를 빼준다 
			for (int i = 1; i <map.length; i++) {
				if (map[node][i] == 1) {// 감염된 컴퓨터와 연결된 노드라면
					DFS(i);// 해당 노드를 시작점으로 다시 깊이 탐색
				}
			}
		}
	}
}
