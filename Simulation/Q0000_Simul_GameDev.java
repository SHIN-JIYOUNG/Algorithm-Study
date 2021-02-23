package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발해야 한다.
 * 캐릭터가 있는 장소는 1 * 1크기의 정사각형으로 이루어진 N * M 크기의 직사각형이다. 
 * 각 칸은 육지 혹은 바다이고, 캐릭터는 동서남북 중 한 곳을 바라본다
 * 맵의 각 칸은 (A, B)로 나타낼 수 있다. A는 북쪽으로부터 떨어진 칸의 갯수, B는 서쪽으로부터 떨어진 칸의 갯수이다. 
 * 캐릭터는 상하좌우로 움직일 수 있고 바다로 되어있는 공간에는 갈 수 없다.
 * 캐릭터는 아래와 같은 순서로 움직여야 한다 
 * 
 * 1. 현재 위치에서 현재 방향을 기준으로 왼쪽방향(반시계방향 90도)부터 차례대로 갈 곳을 정한다
 * 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전 후 왼쪽으로 한 칸 전진한다. 왼쪽에 가보지 않은 칸이 없다면 왼쪽 방향으로 회전만 하고 1단계로 돌아간다.
 * 3. 네 방향 모두 이미 가본 칸이거나 바다인 경우, 바라보는 방향을 유지한 채로 한칸 뒤로가고 1단계로 돌아간다. 뒤쪽도 바다인칸이라면 움직임을 멈춘다
 * 
 * 위를 반복적으로 수행하며 캐릭터의 움직임에 이상이 있는지 테스트해야한다. 매뉴얼에 따라 캐릭터를 이동시킨 뒤에 캐릭터가 방문한 칸의 수를 출력하라. 
 * 
 * 입력조건: 첫째줄에는 맵의 크기, 둘째줄에는 게임 캐릭터가 있는 (A, B)좌표와 바라보는 방향 (0/1/2/3: 북/동/서/남)이 입력된다.
 * 셋째줄에는 맵이 육지인지 바다인지에 대한 정보가 주어진다. (0/1: 육지/바다) 맵의 밖으론 나갈 수 없다.
 * 
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_Simul_GameDev {
	
	public static int n, m, x, y, direction; //direction: 방향 틀어줄 때 쓸 변수 (상하좌우를 가리키는 인덱스)
	public static int[][] map = new int[50][50]; // 게임 캐릭터가 돌아다닐 맵
	public static boolean[][] mapCheck = new boolean[50][50]; // 방문한 위치를 저장하기 위한 subMap

	// 북 동 남 서 방향을 정의한다
	public static int dx[] = { -1, 0, 1, 0 }; //dx[]는 행을 기준으로 움직이기 때문에 위 아래인 북 남 쪽에 -1 1을 넣어준 것 
	public static int dy[] = { 0, 1, 0, -1 }; //dy[]는 열을 기준으로 움직이기 때문에 좌 우인 서 동 쪽에 1 -1을 넣어준 것 
	
	//왼쪽으로 회전하기 위한 메소드
	public static void turn_left() {
		direction--; // 인덱스를 하나 빼줘서 왼쪽으로 돌게 만든다
		if (direction == -1) { // 만약 한바퀴 다 돌아서 인덱스가 -1이 된다면
			direction = 3;// 3으로 초기화해줘야 함
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 맵의 가로길이
		int m = Integer.parseInt(input[1]); // 맵의 세로길이

		input = br.readLine().split(" ");
		x = Integer.parseInt(input[0]);// 현재 위치한 x좌표
		y = Integer.parseInt(input[1]);// y좌표
		direction = Integer.parseInt(input[2]);// 바라보고 있는 방향

		mapCheck[x][y] = true; //현재 시작하는 좌표에 방문표시를 해놓아야 함
		
		//map 전체에 육지0/바다1 채워주기 
		for(int i=0; i<n; i++) {
			input = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(input[j]); 
			}
		}
		
		////////////////////////////////
		// 시뮬레이션 시작

		int cnt = 1; //캐릭터가 방문한 칸의 갯수, 이미 시작좌표에 서있으니 1로 시작 
		int turn_time = 0; //제자리에서 몇 번 회전했나를 담아주는 변수 
		while (true) {
			turn_left(); // 왼쪽으로 회전해보고 
			int nx = x + dx[direction]; //그 방향으로 갔다고 가정하여 nx, ny 셋팅 
			int ny = y + dy[direction];
			// 회전 한 이후 전진했다고 가정한 그 칸이, 가보지 않은 칸이면서 육지인 경우에는 그 칸으로 이동 (즉 x, y 갱신) 
			if (mapCheck[nx][ny] == false && map[nx][ny] == 0) {
				mapCheck[nx][ny] = true;//방문 체크 
				x = nx;//갱신 
				y = ny;
				cnt++;//캐릭터가 밟은 땅 ++ 
				turn_time = 0;//회전 횟수를 0으로 리셋 
				continue;//다시 while문 처음으로 진입 
			} else {// 정면이 바다이거나, 가보지 않은 칸이 없는 경우
				turn_time++; //다시 왼쪽으로 회전해버려야 하므로 turn_time을 올리기 
			}

			if (turn_time == 4) { //사방으로 다 돌아봤는데 갈 곳이 없다면  
				nx = x - dx[direction]; // 바라보는 방향을 유지한 채로 뒤로 가야하니까 모두 반대로 움직여주면 됨 (= -연산) 
				ny = y - dy[direction];
				if (map[nx][ny] == 0) {// 뒤가 육지라서 뒤로갈 수 있다면 뒷칸으로 이동해버리기 (check) 
					x = nx; //갱신 
					y = ny; //갱신 
				} else { // 뒤도 바다로 막혀있다면 
					break; // while문 탈출
				}
				turn_time = 0;//턴타임 초기화 
			}
		}
		System.out.println(cnt);
	}
}
