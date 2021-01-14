package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용자 한테 이름, 생년, 생월, 생일, 생시를 입력받아 사주팔자를 판별하여 출력하는 프로그램 <br>
 * 
 * 조건) 이름 생년월일(000000000) 생시(00~24) 사이에 ' '공백을 주어 입력할 것<br>
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_CheckSaju {
	static String[] sajuArr = { "자: 천귀", "축: 천액", "인: 천권", "묘: 천파", "진: 천인", "사: 천문",
			"오: 천복", "미: 천고", "신: 천역", "유: 천간", "술: 천수", "해: 천명" };

	public static String checkSajuByYear(int year) {
		int idx = (year % 12) + 8;
		if (idx >= 12)
			idx = idx - 12;

		return sajuArr[idx];
	}

	public static String checkSajuByMonth(int year, int month) {
		// 출생한 띠에 해당하는 성좌에 출발하여 태어난 달까지 한 칸씩 옮겨가기
		int yearIdx = (year % 12) + 8;
		if (yearIdx >= 12)
			yearIdx = yearIdx - 12;

		int idx = (yearIdx) - 1 + month;
		if (idx >= 12)
			idx = idx - 12;
		return sajuArr[idx + 1];
	}

	public static String checkSajuByDay(int day) {
		// 처음부터 태어난 일까지 한 칸씩 옮겨가기

		return sajuArr[(day % 12) - 1];
	}

	public static String checkSajuByTime(int day, int time) {
		// 출생일의 성좌에서 출발하여 태어난 시간까지 한 칸씩 옮겨가기
		int idx = 0;

		if (time >= 1 && time < 3) {
			idx = 2;
		} else if (time >= 3 && time < 5) {
			idx = 3;
		} else if (time >= 5 && time < 7) {
			idx = 4;
		} else if (time >= 7 && time < 9) {
			idx = 5;
		} else if (time >= 9 && time < 11) {
			idx = 6;
		} else if (time >= 11 && time < 13) {
			idx = 7;
		} else if (time >= 13 && time < 15) {
			idx = 8;
		} else if (time >= 15 && time < 17) {
			idx = 9;
		} else if (time >= 17 && time < 19) {
			idx = 10;
		} else if (time >= 19 && time < 21) {
			idx = 11;
		} else if (time >= 21 && time < 23) {
			idx = 12;
		} else if (time >= 23 && time <= 24) {
			idx = 1;
		} else if (time >= 0 && time < 1) {
			idx = 1;
		}
		return sajuArr[((day % 12) - 1) + idx];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String inputName, inputBirth, sajuYear, sajuMonth, sajuDay, sajuTime;
		int inputTime;

		inputName = st.nextToken();
		inputBirth = st.nextToken();
		inputTime = Integer.parseInt(st.nextToken());

		int birthYear = Integer.parseInt(inputBirth.substring(0, 4));
		int birthMonth = Integer.parseInt(inputBirth.substring(4, 6));
		int birthDay = Integer.parseInt(inputBirth.substring(6, 8));

		sajuYear = checkSajuByYear(birthYear);
		sajuMonth = checkSajuByMonth(birthYear, birthMonth);
		sajuDay = checkSajuByDay(birthDay);
		sajuTime = checkSajuByTime(birthDay, inputTime);

		bw.write(inputName + " 님의 사주\n");
		bw.write("년주) " + sajuYear + "\n");
		bw.write("월주) " + sajuMonth + "\n");
		bw.write("일주) " + sajuDay + "\n");
		bw.write("시주) " + sajuTime);
		bw.flush();
		br.close();
		bw.close();
	}
}