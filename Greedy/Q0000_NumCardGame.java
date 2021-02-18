package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 숫자 카드 게임은 여러 개의 숫자 카드 중 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 * 룰은 아래와 같다.
 * 1. 숫자가 쓰인 카드들이 N x M 형태로 놓여있다. 이때 N은 행의 개수, M은 열의 개수 이다.
 * 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 * 3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다
 * 4. 따라서 처음에 카드를 골라낼 행을 선택시, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여
 * 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 * 
 * 풀이 방법: 한 행마다 배열을 초기화 시키며 계속 받아온다, 그 과정에서 정렬을 하여 가장 최솟값을 맨 앞 인덱스로 배치한다
 * 그래서 각 행을 돌면서 최솟값, 즉 출력이 되어야 하는 최댓값을 갱신시켜나간다.
 * @author JIYOUNG
 *
 */
public class Q0000_NumCardGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int idx=0;
		int max=0; //최고값을 갱신해나갈 변수 
		
		String[] inputRowStr=new String[N];//한 행씩 받아올 배열 
		int[] inputRow = new int[N];//위 배열을 Integer로 형변환 할 배열 

		while (M > 0) {
			inputRowStr = br.readLine().split(" "); //한 행씩 받아오고 
			idx=0;
			for (int i = 0; i < inputRowStr.length; i++) {
				inputRow[idx] = Integer.parseInt(inputRowStr[idx]);//integer로 형변환 하고 
				idx++;
			}
			Arrays.sort(inputRow);// 정렬 (오름차순)
			if (max < inputRow[0]) { //최댓값 갱신 
				max = inputRow[0];
			}
			M--;
		}
		System.out.println(max);
	}
}
