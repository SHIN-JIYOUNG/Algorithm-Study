package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

/**
 * 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를
 * 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오
 * 
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * 
 * 풀이방법: DFS 사용, 배열 전체를 훑으며 방문 안한 곳을 깊이탐색해나가며 cnt++ 
 * 
 * @author JIYOUNG
 *
 */
public class Q2667_DFS_NumberingAptSection {
	
	static int[][] map = new int[25][25]; //지도
	static boolean[][] visited = new boolean[25][25]; //방문여부
	static int apartNum = 0; //아파트 단지 번호의 수
	static int N;
	static int[] aparts = new int[25*25];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

    private static void dfs(int x, int y) { //깊이 우선 탐색으로 찾아나가기
        visited[x][y] = true;//방문한 아파트는 true로 바꿔주고 
        aparts[apartNum]++;//해당 단지의 아파트 수를 ++ 

        for(int i=0; i<4; i++){//현재 방문중인 아파트의 상하좌우를 살피며 1을 찾아야함 
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < N && ny < N){ //아파트 좌표가 맵 안에 있으며, 
                if(map[nx][ny] == 1 && !visited[nx][ny]){//옮겨진 좌표가 방문하지 않았고 1이라면 
                    dfs(nx,ny);//깊이탐색 재시작  
                }
            }
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {// map 채워넣기
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) { //단지의 시작점을 찾기 위한 for문 
			for (int j = 0; j < N; j++) {//맵의 전체를 훑어나가면서 최초의 1을 찾는다 
				if (map[i][j] == 1 && !visited[i][j]) {//찾았다면!
					apartNum++;//첫번째 단지부터 시작, 다시 돌아오면 ++되기 때문에 2가 되어 두번째 단지 시작  
					dfs(i, j);//깊이탐색 시작 
				}
			}
		}

		Arrays.sort(aparts);//단지 내의 아파트 수를 정렬해야 하기 때문에 sort 사용 
		System.out.println(apartNum);//단지 수 프린트 

		for (int i = 0; i < aparts.length; i++) { //apart 배열을 돌면서 
			if (aparts[i] == 0) {//0이면 무시 
			} else {//0이 아니라면 == 단지에 아파트가 있다면!
				System.out.println(aparts[i]);//그 아파트 값을 프린트 
			}
		}
	}
}
