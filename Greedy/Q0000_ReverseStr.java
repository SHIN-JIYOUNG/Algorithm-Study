package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 0과 1로만 이루어진 문자열을 뒤집어서 모두 같은 숫자로 만드려 한다. 모두 같은 숫자로 만들기까지 걸리는 최소횟수를 구하라
 * 
 * 풀이방법: 직접 바꿔서 횟수를 카운트 하여 비교하여야 한다. 
 * 틀렸던 점: 0 그룹과 1 그룹의 갯수를 각각 재어 더 작은 수를 print했음
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_ReverseStr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int g1 = 0; 
		int g0 = 0;  

		if (str.charAt(0) == '1') {//시작문자가 1이면 
			g0++;//0으로 바꿔줘야 하니 0++
		} else {//반대라면 
			g1++;//1으로 바꿔줘야 하니 1++
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {//현재 보고있는 숫자와 다음 숫자가 다른데 
				if (str.charAt(i + 1) == '1') {//그 다른 숫자가 1이라면 
					g0++;//0그룹 끝났으니 ++
				} else {
					// 그 다른 숫자가 0이라면 
					g1++;//1그룹 끝났으니 ++ 
				}
			}
		}
		System.out.println(Math.min(g0, g1));
	}
}
