package AlgorithmStudy;

import java.util.Arrays;

/**
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다. 배열 array, [i, j,
 * k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을
 * 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 풀이 방법: 배열을 도려내어 k에 해당하는 값을 반환한 후 answer에 추가한다.
 * 풀이 방법 2: copyOfRange를 이용하여 배열을 도려내기 
 * 
 * @author JIYOUNG
 *
 */
public class Q00000_Sorting_KthNum {
	static public int[] solution(int[] array, int[][] commands) {
		int i, j, k, tc, idx;
		int[] answer = new int[commands.length]; //답을 담을 배열 설정 

		for (tc = 0; tc < commands.length; tc++) {
			i = commands[tc][0]; 
			j = commands[tc][1];
			k = commands[tc][2];

			int[] newArr = new int[j - i + 1];// i, j, k를 반영하기 위한 새로운 배열

			for (idx = 0; i - 1 <= j - 1; i++) {
				newArr[idx] = array[i - 1];
				idx++;
			}

			for (int a = 0; a < newArr.length; a++) { //newArr 값들을 정렬하기 위한 반복문 
				for (int b = a + 1; b < newArr.length; b++) {
					if (newArr[a] > newArr[b]) {
						int temp = newArr[a];
						newArr[a] = newArr[b];
						newArr[b] = temp;
					}
				}
			}
			answer[tc] = newArr[k - 1]; //답으로 반환할 배열에 값을 하나씩 추가하기 
		}
		return answer;
	}

	public static void main(String[] args) {
		//testCase
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] result = solution(array, commands);
		System.out.println(Arrays.toString(result));
	}

}


// copyOfRange를 이용한 풀이 
//import java.util.Arrays;
//class Solution {
//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//
//        for(int i=0; i<commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2]-1];
//        }
//
//        return answer;
//    }
//}
