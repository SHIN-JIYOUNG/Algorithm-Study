package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 00시 00분 00초 부터 N시 59분 59초까지 모든 시각 중 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하라.
 * 
 * @author JIYOUNG
 *
 */
public class Q0000_simul_Time {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i <= n; i++) {
			if (String.valueOf(i).contains("3")) { //시간에 3을 가지고 있다면 
				cnt += 60 * 60;//60분*60초 만큼 가지고 있는 것이니 60*60을 더해주고 반복문으로 다시 돌아감 
			} else {//시간에 3이 없다면 분으로 진입 
				for (int j = 0; j <= 59; j++) { //59분까지 돌면서 
					if (String.valueOf(j).contains("3")) {//3을 가지고 있다면 
						cnt += 60;//60초 만큼도 가지고 있는 것이니 60을 더해줌 
					} else {//분에 3이 없다면 초로 진입 
						for (int k = 0; k <= 59; k++) {//59초까지 돌면서  
							if (String.valueOf(k).contains("3")) {//3을 가지고 있다면 
								cnt++;//그 즉시 cnt++ 
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	
	//////////////////////////////////////////////////////
	//모범 코드
	
//	public static boolean check(int h, int m, int s) { // 10단위로 나눠주면 된다.
//		if(h/10 == 3 || h%10 == 3 || m/10 == 3 || m%10 == 3 || s/10 ==3 || s%10 ==3) {
//			return true;
//		}
//		return false;
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int cnt = 0;
//		for(int i=0; i<=n; i++) { // 시
//			for(int j=0; j<60; j++) { // 분
//				for(int k=0; k<60; k++) { // 초
//					if(check(i,j,k)) cnt++;
//					} 
//				}
//			}
//		System.out.println(cnt);
//	}
}
