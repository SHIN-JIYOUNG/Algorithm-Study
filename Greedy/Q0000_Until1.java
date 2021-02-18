package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려 한다. 단 두번째 연산은 N이 K로 나누어 떨어질
 * 때만 선택할 수 있다. 
 * 1. N에서 1을 뺀다 
 * 2. N을 K로 나눈다 
 * N이 1이 될 때까지 1 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오
 * 
 * 풀이 방법: 그리디 알고리즘 사용, 가장 빠른 해는 나누기 연산이므로, 나누기 연산이 해당되지 않으면 N--;
 * @author JIYOUNG
 *
 */
public class Q0000_Until1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int cnt = 0;

		while (N != 1) {
			if (N % K == 0) {//2번 연산이 가능하다면 실행 
				N = N / K;
				cnt++;
			} else {//불가능하다면 
				N--;//1씩 빼나감 
				cnt++;
			}
			if (N == 1) {//1이 만들어지면 
				break;//탈출 
			}
		}
		System.out.println(cnt);
	}
}
