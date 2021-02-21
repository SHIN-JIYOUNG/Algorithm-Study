package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 서로 무게가 다른 볼링공을 골라야 한다. 볼링공은 총 N개가 있으며, 볼링공 마다 무게가 적혀있다. 공 번호는 1번부터 순서대로 부여된다.
 * 같은 무게의 공이 여러개 있을 수 있지만 서로 다른 공으로 간주한다. 볼링공의 무게는 M까지 존재한다. 무게가 다른 볼링공을 고르는 경우의
 * 수를 구하라
 *
 * 풀이방법: nC2/2을 구한 후 무게가 같은 공이 들어올려지는 경우를 뺀다.
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_Greedy_PickBalling {

	static int factorial(int n) { //nC2/2 구하기 
		int result = 1;

		for (int i = 0; i < 2; i++) {
			result *= n;
			n--;
		}
		result = result/2;

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);// 볼링공의 갯수
		int m = Integer.parseInt(input[1]);// 볼링공의 최대 무게
		String[] arr = br.readLine().split(" "); //볼링공들 입력 

		int total = factorial(n);//중복이 없다는 가정 하에 모든 경우의 수를 total에 입력 
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) { //짝을 2개씩 지어가며, 만약 같은 수가 짝지어졌을 때에는 
					total--;//전체 경우의 수에서 빼줌 
				}
			}
		}
		System.out.println(total);
	}
}
