package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 큰 수의 법칙이란, 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다. 단, 배열의 특정한
 * 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다. 또한, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른
 * 것이라 간주한다. ex. [3, 4, 3, 4, 3], m=7, k=2 일 시, 2번째 4와 4번째 4가 2번씩 번갈아가며 더해져도 된다는
 * 것이다.
 * 
 * 풀이방법: 그리디 알고리즘을 이용, 배열을 정렬 후, 마지막 인덱스가 가장 큰 숫자이기 때문에 최대한 (M회)더한 후, 마지막에서 두번째
 * 인덱스를 1번만 더하여 총 N회를 채운다 
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_TheLawOfGreatNums {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int size = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);// 총 더하는 갯수
		int M = Integer.parseInt(input[2]);// 똑같은 숫자를 사용할 수 있는 갯수

		int[] arr = new int[size];
		int idx = 0;
		int result = 0;
		String[] inputArr = br.readLine().split(" ");
		for (String s : inputArr) {
			arr[idx] = Integer.parseInt(inputArr[idx++]);
		}

		Arrays.sort(arr); //오름차순 정렬, 가장 큰 숫자는 맨 뒤에 있을 것 

		while (N != 0) {
			for (int i = 0; i < M; i++) {
				result += arr[size - 1]; //맨 뒤의 숫자를 M회 더한다 
				N--;
				if (N == 0) { //더해가는 도중 모든 횟수를 다 차감했다면 
					System.out.println(result);//답 반환 후 
					return;//나간다 
				}
			}
			result += arr[size - 2];//맨 뒤의 숫자를 M회 더한 후에는 뒤에서 두번째 숫자를 더한다 
			N--;
			if (N == 0) {//더해가는 도중 모든 횟수를 다 차감했다면 
				System.out.println(result);//답 반환 후 
				return;//나간다 
			}
		}
	}
}
