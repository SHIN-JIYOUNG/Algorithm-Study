package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오. 첫째 줄에
 * N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에
 * Ai는 Ai-1의 배수)
 * 
 * 풀이방법: 그리디 알고리즘으로 풀이, 주어진 금액에서 가장 큰 금액을 가진 동전부터 빼낸다.
 * 
 * @author JIYOUNG
 *
 */
public class Q11047_Coin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int coins = Integer.parseInt(input[0]); //동전의 갯수 
		int money = Integer.parseInt(input[1]); //만들어야 하는 금액 
		int[] coinArr = new int[coins]; //코인을 넣어 놓을 배열 
		int cnt = 0; //연산 횟수 

		for (int i = 0; i < coins; i++) {
			coinArr[i] = Integer.parseInt(br.readLine());
		}

		while (money != 0) { //돈이 0원이 될 때까지 
			for (int i = coins - 1; i >= 0; i--) { //제일 큰 금액부터 빼나가기 시작 
				if (money >= coinArr[i]) {//money가 해당 배열의 코인의 가격보다 크다면 
					cnt += money / coinArr[i]; // 나눈 몫 만큼 cnt에 저장해놓고 
					money = money % coinArr[i];// 나눈 나머지를 money로 남겨놓는다 
				}
			}
		}
		System.out.println(cnt);
	}
}
