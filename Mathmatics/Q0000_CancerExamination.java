package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용자 한테 이름, 출생연도를 입력받아 무료암검진 대상자 인지 판별하여 결과를 출력하는 프로그램<br>
 * 
 * 조건) 이름 출생연도 사이에 ' '공백을 주어 입력할 것<br>
 * 무료 암 검진 대상자: 해당 연도와 끝자리의 홀/짝이 맞는 경우. ex)2021년-홀수년도 출생자<br>
 * 위암, 간암, 유방암: 만 40세 이상/ 대장암: 만 50세 이상/ 자궁경부암: 만 20세 이상 / 폐암: 만 54세이상~ 만 74세 이하<br>
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_CancerExamination {

	final static int YEAR = 2021;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String inputName;
		int inputBirth;

		inputName = st.nextToken();
		inputBirth = Integer.parseInt(st.nextToken());

		if (YEAR % 2 != inputBirth % 2) {
			bw.write(inputName+" 님은 해당년도의 검진 대상자가 아닙니다");
			bw.write("\n");
			bw.flush();
		}
		if (YEAR % 2 == inputBirth % 2) {		
			if ((YEAR - inputBirth) >= 20) {
				bw.write(inputName+" 님은 자궁경부암(여성) 검진 대상자입니다.\n");
				if ((YEAR - inputBirth) >= 40) {
					bw.write(inputName+" 님은 위암, 간암, 유방암(여성) 검진 대상자입니다.\n");
					if ((YEAR - inputBirth) >= 50) {
						bw.write(inputName+" 님은 대장암 검진 대상자입니다.\n");
						if ((YEAR - inputBirth) >= 54 && (YEAR - inputBirth) <= 74) {
							bw.write(inputName+" 님은 폐암 검진 대상자입니다.\n");
						}
					}
				}
			}
			bw.flush();
		}
		br.close();
		bw.close();
	}
}