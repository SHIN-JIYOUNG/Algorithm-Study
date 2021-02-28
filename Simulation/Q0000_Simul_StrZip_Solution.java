package AlgorithmStudy_notyet;

import java.io.IOException;

/**
 * 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수가 반복되는 값으로 표현하여 더 짧을 문자열로 줄여서 표현하는 알고리즘이 문자열
 * 압축이다. 문자열이 매개변수로 주어질 때, 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
 * 하라.
 * 
 * 풀이방법: 완전탐색의 느낌? 문자열 길이(1000)만큼 다 짤라봐서 탐색하고, 배열에 넣어버리기
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_Simul_StrZip_Solution {

	public int solution(String s) {
		int answer = s.length();

		for (int n = 1; n <= s.length() / 2; n++) {//글자열의 길이를 정하는 for문 
			//asdfgh //2글자씩 끊는다 
			StringBuilder temp = new StringBuilder();//글자 붙이기 

			for (int i = 0; i < s.length(); i = i + n) { //비교군 1 만들기 
				//0 번째 인덱스부터 시작을 해야 하므로 (i, i+n) 만큼 문자열을 나누고 
				String word1 = "";

				if (i + n >= s.length())
					word1 = s.substring(i, s.length());
				else
					word1 = s.substring(i, i + n);

				int cnt = 1;
				StringBuilder sb = new StringBuilder();

				for (int j = i + n; j < s.length(); j = j + n) { //비교군 2 만들기 
					//그 다음 위치부터 끝까지 (j = i+n, j+n) 를 반복하면서 문자열 비교
					String word2 = "";

					if (j + n >= s.length()) {
						word2 = s.substring(j, s.length());
					} else {
						word2 = s.substring(j, j + n);
					}

					if (word1.equals(word2)) {
						cnt++;
						i = j;
					} else {
						break;
					}
				}

				if (cnt == 1)
					sb.append(word1);
				else
					sb.append(cnt).append(word1);

				temp.append(sb.toString());
			}

			answer = Math.min(answer, temp.toString().length());
		}

		return answer;
	}
}