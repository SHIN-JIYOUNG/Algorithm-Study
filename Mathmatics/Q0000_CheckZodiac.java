package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용자 한테 이름, 생월, 생일을 입력받아 별자리를 판별하여 출력하는 프로그램 <br>
 * 
 * 조건) 이름 생월,생일(0000) 사이에 ' '공백을 주어 입력할 것<br>
 * @author JIYOUNG
 *
 */
public class Q0000_CheckZodiac {
	
	public static String checkZodi(int birth) {
		if(birth>=120&&birth<=218) {
			return "물병자리";
		}else if(birth>=219&&birth<=320) {
			return "물고기자리";
		}else if(birth>=321&&birth<=419) {
			return "양자리";
		}else if(birth>=420&&birth<=520) {
			return "황소자리";
		}else if(birth>=521&&birth<=621) {
			return "쌍둥이자리";
		}else if(birth>=622&&birth<=722) {
			return "게자리";
		}else if(birth>=723&&birth<=822) {
			return "사자자리";
		}else if(birth>=823&&birth<=923) {
			return "처녀자리";
		}else if(birth>=924&&birth<=1022) {
			return "천칭자리";
		}else if(birth>=1023&&birth<=1122) {
			return "전갈자리";
		}else if(birth>=1123&&birth<=1224) {
			return "사수자리";
		}else if(birth>=1225&&birth<=1231) {
			return "염소자리";
		}else if(birth>=101&&birth<=119) {
			return "염소자리";
		}else {
			return "생월, 생일 입력 방식이 잘못되었음 (0000)";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String inputName, result;
		int inputBirth;

		inputName = st.nextToken();
		inputBirth = Integer.parseInt(st.nextToken());
		
		result=checkZodi(inputBirth);
		
		bw.write(inputName+"님의 별자리는 "+result+"입니다.\n");
		bw.flush();
		br.close();
		bw.close();
	}
}