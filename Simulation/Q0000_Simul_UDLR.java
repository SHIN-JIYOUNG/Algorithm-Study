package AlgorithmStudy;

import java.util.Scanner;

/**
 * 시작좌표 (1,1) 에서 상, 하, 좌, 우를 입력받아서 움직인 최종 좌표를 구한다.
 * 만약 입력된 NxN 의 정사각형 공간을 벗어나는 움직임은 무시된다. 
 * @author JIYOUNG
 *
 */
public class Q0000_Simul_UDLR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N을 입력받기
		int n = sc.nextInt();
		sc.nextLine(); // 버퍼 비우기
		String[] plans = sc.nextLine().split(" ");
		int x = 1, y = 1;

		// L, R, U, D에 따른 이동 방향
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		char[] moveTypes = { 'L', 'R', 'U', 'D' };

		// 이동 계획을 하나씩 확인
		for (int i = 0; i < plans.length; i++) {
			char plan = plans[i].charAt(0);
			// 이동 후 좌표 구하기
			int nx = -1, ny = -1;
			for (int j = 0; j < 4; j++) {
				if (plan == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			// 공간을 벗어나는 경우 무시
			if (nx < 1 || ny < 1 || nx > n || ny > n)
				continue; //x나 y를 갱신시키지 않은 채로 다시 for문으로 돌아간다. 
			// 이동 수행
			x = nx;
			y = ny;
		}

		System.out.println(x + " " + y);
	}

}