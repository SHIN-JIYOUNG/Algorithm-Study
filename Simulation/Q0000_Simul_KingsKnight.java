package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 8x8 좌표평면의 특정한 한 칸에 나이트가 서있다. 나이트는 L자 형태로만 이동ㅇ할 수 있고, 좌표평면밖으로 나갈 수 없다. 또한, 특정한
 * 위치에서 아래와 같이 두 가지 경우로 이동 가능하다. 
 * 1. 수평으로 두 칸 이동한 뒤 수직으로 한 칸 
 * 2. 수직으로 두 칸 이동한 뒤 수평으로 한 칸
 * 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하라.행은 1~8로 표현하며, 열은 a~h로 표현한다. (ex. a1~h8)
 *
 * 풀이 방법: 움직일 수 있는 공간을 모두 배열에 넣어 옮겨가며, 가능한 위치이면 cnt++ 
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_Simul_KingsKnight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(""); //입력받은 문자열을 나눠서 배열에 넣어준 후 
		int y = Integer.parseInt(input[1]);//숫자는 y 
		int x = 0;//문자는 x에 넣어줘야함 
		switch (input[0]) {// 문자열을 숫자로 바꿔 연산해야 하기 때문에 
		case "a": x = 1; break;//케이스에 맞게 숫자로 바꿔줌 
		case "b": x = 2; break;
		case "c": x = 3; break;
		case "d": x = 4; break;
		case "e": x = 5; break;
		case "f": x = 6; break;
		case "g": x = 7; break;
		case "h": x = 8; break;
		}

		int[] row = { -2, -2, -1, 1, -1, 1, 2, 2 }; //L형태를 돌려서 나올 수 있는 움직임의 경우의 수는 8개, 그 움직임에 맞게 이동 거리를 넣어줌 
		int[] col = { 1, -1, -2, -2, 2, 2, 1, -1 };

		int nx, ny; //움직인 후의 위치를 넣어줄 변수 
		int cnt = 0;//좌표평면 안에서 가능한 움직임이면 cnt++
		for (int i = 0; i < 8; i++) { // L형태는 8가지 형태이기 때문에 8번 검사해야 함 
			nx = 0;
			ny = 0;
			nx = x + row[i];//x축 움직이기 
			ny = y + col[i];//y축 움직이기 

			if (nx <= 8 && ny <= 8 && nx >= 1 && ny >= 1) { //x, y 둘다 1~8범위 내에 있다면 
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
