package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 어떤 극장의 좌석은 1번부터 N번까지 번호가 매겨져 있다. 예를 들어서, 입장권에 5번이 쓰여 있으면 5번 좌석에 앉아야 한다. 단,
 * 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다. 예를 들어서, 7번 입장권을 가진 사람은 7번 좌석은 물론이고,
 * 6번 좌석이나 8번 좌석에도 앉을 수 있다. 그런데 “VIP 회원”들은 반드시 자기 좌석에만 앉아야 하며 옆 좌석으로 자리를 옮길 수
 * 없다. VIP 회원들의 좌석 번호들이 주어졌을 때, 사람들이 좌석에 앉는 서로 다른 방법의 가짓수를 구하는 프로그램을 작성하시오. 예를
 * 들어서, 좌석이 9개이고, 4번 좌석과 7번 좌석이 VIP석인 경우에 <312456789> 와 <123546789> 는 허용되지 않는 배치
 * 방법이다.
 * 
 * 첫째 줄에는 좌석의 개수 N이 입력된다. N은 1 이상 40 이하이다. 둘째 줄에는 고정석의 개수 M이 입력된다. M은 0 이상 N
 * 이하이다. 다음 M 개의 줄에는 고정석의 번호가 작은 수부터 큰 수의 순서로 한 줄에 하나씩 입력된다.
 * 
 * 풀이: 받아내는 VIP석 좌석번호들을 기점으로 좌석 배열을 잘라낸 후, bottom-up방식으로 잘라내어진 좌석 배열들의 경우의 수를 모두
 * 합쳐 구할 것이다. ex. 4번, 7번이 VIP석이라면 1~3번 좌석끼리의 경우의 수 + 5~6번 좌석끼리의 경우의 수 + 8~9번
 * 좌석끼리의 경우의 수 가 된다.
 * 
 * @author JIYOUNG
 *
 */
public class Q2302_TheaterSeat {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 처음에 입력될 '좌석의 수' N, 1 이상 40 이하
		int M = Integer.parseInt(br.readLine()); // 두번째로 입력될 고정석의 갯수 M, 0 이상 N 이하
		int result = 1; // 앉을 수 있는 경우의 수를 넣어줄 변수
		int afterVIP = 0; //VIP 좌석번호를 넣어서 끊어주는 단위로 쓸 변수를 선언 

		int[] seats = new int[41];// 우리가 가질 수 있는 좌석의 수는 0개(사람 없음)부터 40번까지이므로 방의 갯수는 41개로 설정,
		// 시간복잡도가 최대인 경우, 1번~41번까지 VIP석 없이 배치한다는 가정 하에 41번까지 값을 채울 수도 있음.

		seats[0] = 1; // 공집합
		seats[1] = 1; // 1번만 들어오면 1번이 그자리에 앉아있어야하므로 1
		seats[2] = 2; // 2번까지 들어오면 1.2 / 2.1 총 2가지 경우 가능

		for (int i = 3; i <= N; i++) {//N번 까지만 값을 넣어줄 것 
			seats[i] = seats[i - 1]/* 자리 바꿈 없이 옆에 붙어 앉는 경우, i의 바로 직전 경우의 수와 변함이 없다 */
					+ seats[i - 2];/* 자리 바꿈을 하는 경우, i는 i-1에, i-1은 i에 앉아야 하므로 고정되어있는건 i-2 경우의 수 뿐이다 */
		}

		// VIP 좌석을 제외한 나머지 좌석 집단 끼리의 경우의 수를 서로 곱한 것이 답이다.
		for (int i = 1; i <= M; i++) { //M번만 반복시킬 것
			int VIP = Integer.parseInt(br.readLine()); //VIP숫자들을 입력받을 변수 
			result *= seats[VIP - afterVIP - 1];//내가 출력해야하는 값은=새로 받은 VIP숫자에서-마지막 VIP숫자를 뺀 후-1 끼리 곱 
			//왜 -1?: -1을 안하면 자기 자신도 포함하는 배열이 되기 때문에.
			afterVIP = VIP;//새로운 VIP번호를 받기 전 끊어줄 변수에 VIP번호를 넣어줌 
		}
		result *= seats[N - afterVIP]; // 마지막으로, 마지막 VIP번호부터 끝 좌석까지의 경우의 수.

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
